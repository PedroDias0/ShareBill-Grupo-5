package pt.iade.ei.sharebill.ui.menus

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.sharebill.AmigosActivity
import pt.iade.ei.sharebill.R
import pt.iade.ei.sharebill.models.User
import pt.iade.ei.sharebill.ui.components.AdicionarAmigosButton
import pt.iade.ei.sharebill.ui.components.AmigosButton
import pt.iade.ei.sharebill.ui.components.AtividadeButton
import pt.iade.ei.sharebill.ui.components.GruposButton
import pt.iade.ei.sharebill.ui.components.ShowContactButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmigosMenu() {
    var text by remember{mutableStateOf("") }
    var active by remember{mutableStateOf(false) }
    Scaffold(
        containerColor = Color.Transparent
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Definindo a imagem de fundo
            Image(
                painter = painterResource(id = R.drawable.fundo_amigos), // Substitua com a sua imagem
                contentDescription = "Fundo",
                contentScale = ContentScale.Crop, // Escolha o ContentScale adequado
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                )
                 {
                    SearchBar(
                colors = SearchBarDefaults.colors(containerColor = Color.Transparent),

                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(
                        start = 25.dp,
                        end = 10.dp,
                        top = 10.dp,
                        bottom = 5.dp,),
                query = text,
                onQueryChange = {
                    text = it
                },
                onSearch = {
                    active = false
                },
                active = active,
                onActiveChange = {
                    active = it
                },
                placeholder = {
                    Text(text = "")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon",
                        modifier = Modifier.size(33.dp)
                    )
                },
                trailingIcon = {
                    if (active) {
                        Icon(
                            modifier = Modifier.clickable {
                                if (text.isNotEmpty()) {

                                    text = ""
                                } else {

                                    active = false
                                }
                            },
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close Icon"
                        )
                    }
                }
            ){}
                Spacer(modifier = Modifier.padding(start = 30.dp))
                Image(
                    painter = painterResource(R.drawable.icon),
                    contentDescription = "Logo",
                    modifier = Modifier.size(110.dp, 110.dp)
                        .padding(top = 5.dp)
                ) }

                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = "Contactos",
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .padding(start = 20.dp, top = 30.dp) // Padding individual para o texto
                            .border(1.dp, Color.hsl(0f, 0f, 0.75f))
                            .padding(start = 20.dp, end = 20.dp, top = 8.dp, bottom = 8.dp),
                        fontSize = 18.sp,
                        letterSpacing = 1.sp,
                        textAlign = TextAlign.Center,
                        color = Color.hsl(0f, 0f, 0f)
                    )
                    Spacer(modifier = Modifier.padding(bottom = 5.dp))
                    LazyColumn(
                        modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 12.dp)
                        .height(420.dp)
                    ) {
                        items(UserContentListExample()) { contacto ->
                            ShowContactButton(user = contacto)
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 80.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        AdicionarAmigosButton("+ Adicionar amigos")
                    }

                    Spacer(modifier = Modifier.height(10.dp)) // Espaço entre o botão e os ícones

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        AmigosButton(
                            imageRes = R.drawable.amigos,
                            containerColor = Color.Transparent,
                            AmigosActivity::class.java
                        )
                        GruposButton(
                            imageRes = R.drawable.grupos,
                            containerColor = Color.Transparent
                        )
                        AtividadeButton(
                            imageRes = R.drawable.atividade,
                            containerColor = Color.Transparent
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable

fun AmigosMenuPreview(){
    AmigosMenu()
}

fun UserContentListExample(): List<User> {
    return listOf(
        User(
            id = 1,
            name = "João"
        ),
        User(
            id = 2,
            name = "Tiago"
        ),
        User(
            id = 3,
            name = "Gongas"
        ),
        User(
            id = 4,
            name = "Zed"
        ),
        User(
            id = 5,
            name = "Alien"
        ),
        User(
            id = 6,
            name = "Fifi"
        ),
        User(
            id = 6,
            name = "Fifi"
        ),
        User(
            id = 6,
            name = "Fifi"
        ),
        User(
            id = 6,
            name = "Fifi"
        ),
        User(
            id = 6,
            name = "Fifi"
        ),
        User(
            id = 6,
            name = "Fifi"
        ),
        User(
            id = 6,
            name = "Fifi"
        ),
        User(
            id = 6,
            name = "Fifi"
        )
    )
}