package pt.iade.ei.ShareBill.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pt.iade.ei.ShareBill.models.LoginRequestDTO;
import pt.iade.ei.ShareBill.models.LoginResponseDTO;
import pt.iade.ei.ShareBill.models.User;
import pt.iade.ei.ShareBill.models.repositories.UserRepository;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.text.Normalizer;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    private static final String SECRET_KEY = "YourSuperSecretKeyForJWTToken12345";

    // Função para remover acentos
    public static String removeAccents(String text) {
        String normalized = Normalizer.normalize(text, Normalizer.Form.NFD);
        return normalized.replaceAll("\\p{M}", "");
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<User> getUser() {
        logger.info("Sending all users without sensitive data");
        return userRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<User> getUser(@PathVariable int id) {
        logger.info("Sending user with id {} without sensitive data", id);
        return userRepository.findById(id);
    }

    @GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> searchUsersByName(@RequestParam String query) {
        logger.info("Searching for users with name containing: {}", query);

        // Remover acentos do texto de busca
        String normalizedQuery = removeAccents(query);

        // Buscar no repositório
        List<User> users = userRepository.findByNomeContainingIgnoreCase(normalizedQuery);

        return users;
    }

    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User registerUser(@Valid @RequestBody User newUser) {
        logger.info("Registering a new user: {}", newUser.getEmail());

        // Verificar se o e-mail já existe
        Optional<User> existingPerson = userRepository.findByEmail(newUser.getEmail());
        if (existingPerson.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already in use");
        }

        // Logar o nome do utilizador
        logger.info("User name: {}", newUser.getNome());

        // Aqui você pode implementar hashing de senha
        newUser.setPassword(newUser.getPassword()); // Use hashing seguro em produção.

        return userRepository.save(newUser);
    }

    // Login do usuário
    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginResponseDTO loginUser(@Valid @RequestBody LoginRequestDTO loginRequest) {
        logger.info("Authenticating user: {}", loginRequest.getEmail());

        Optional<User> existingUser = userRepository.findByEmail(loginRequest.getEmail());
        if (existingUser.isPresent()) {
            if (existingUser.get().getPassword().equals(loginRequest.getPassword())) {
                String token = generateToken(existingUser.get());
                return new LoginResponseDTO(existingUser.get().getId(), token);
            } else {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid password");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    // Método auxiliar para gerar o token JWT
    private String generateToken(User user) {
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("id", user.getId())
                .claim("name", user.getNome())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // Token válido por 24 horas
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Endpoint para validar o token JWT
    @GetMapping(path = "/validate", produces = MediaType.APPLICATION_JSON_VALUE)
    public String validateToken(@RequestHeader("Authorization") String token) {
        try {
            // Remover "Bearer " do token, se presente
            if (token.startsWith("Bearer ")) {
                token = token.substring(7);
            }

            Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return "Token is valid";
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid or expired token");
        }
    }
}
