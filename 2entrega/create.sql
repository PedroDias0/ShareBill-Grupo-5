
CREATE TABLE User (
   user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_nome VARCHAR(100) NOT NULL,
    user_email VARCHAR(100) UNIQUE NOT NULL,
    user_password VARCHAR(255) NOT NULL
);


CREATE TABLE grupo (
    grupo_id INT AUTO_INCREMENT PRIMARY KEY,
    grupo_nome VARCHAR(100) NOT NULL,
    grupo_descricao VARCHAR(255)
);

CREATE TABLE ug (
    ug_id INT AUTO_INCREMENT PRIMARY KEY,
    ug_id_utilizador INT NOT NULL,
    ug_id_grupo INT NOT NULL,
    FOREIGN KEY (ug_id_utilizador) REFERENCES User(user_id) ON DELETE CASCADE,
    FOREIGN KEY (ug_id_grupo) REFERENCES grupo(grupo_id) ON DELETE CASCADE
);

CREATE TABLE despesas (
    despesas_id INT AUTO_INCREMENT PRIMARY KEY,
    despesas_id_utilizador INT NOT NULL,
    despesas_id_grupo INT,
    despesas_valor DECIMAL(10, 2) NOT NULL,
    despesas_descricao VARCHAR(255),
    data DATETIME NOT NULL,
    FOREIGN KEY (despesas_id_utilizador) REFERENCES User(user_id) ON DELETE CASCADE,
    FOREIGN KEY (despesas_id_grupo) REFERENCES grupo(grupo_id) ON DELETE SET NULL
);


CREATE TABLE categorias (
    categoria_id INT AUTO_INCREMENT PRIMARY KEY,
    categoria_nome VARCHAR(100) NOT NULL,
    categoria_descricao VARCHAR(255)
);


CREATE TABLE atividades (
    atividade_id INT AUTO_INCREMENT PRIMARY KEY,
    atividade_id_categoria INT NOT NULL,
    atividade_descricao VARCHAR(255),
    data DATETIME NOT NULL,
    FOREIGN KEY (atividade_id_categoria) REFERENCES categorias(categoria_id) ON DELETE CASCADE

);

CREATE TABLE amigos (
    amizade_id INT AUTO_INCREMENT PRIMARY KEY,
    utilizador1_id INT NOT NULL,
    utilizador2_id INT NOT NULL,
    estado ENUM('Pending', 'Accepted', 'Blocked') DEFAULT 'Pending', -- Estado da amizade
    data_pedido DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, -- Data do pedido de amizade
    FOREIGN KEY (utilizador1_id) REFERENCES User(user_id) ON DELETE CASCADE,
    FOREIGN KEY (utilizador2_id) REFERENCES User(user_id) ON DELETE CASCADE,
    UNIQUE KEY (utilizador1_id, utilizador2_id) -- Evita duplicação de amizades
);