package pt.iade.ei.sharebill.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.sharebill.R
import pt.iade.ei.sharebill.models.User

@Composable
fun ShowContactButton(user: User) {
    OutlinedCard(
        modifier = Modifier
            .padding(vertical = 5.dp, horizontal = 8.dp)
            .size(width = 338.dp, height = 60.dp),
        shape = RectangleShape
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Start, // Alinha os itens no início
            verticalAlignment = Alignment.CenterVertically // Alinha verticalmente no centro
        ) {
            // Imagem à esquerda do texto
            Image(
                painter = painterResource(id = R.drawable.icon), // Substitua pelo seu recurso de imagem
                contentDescription = "User Icon",
                modifier = Modifier.size(80.dp, 80.dp) // Ajuste o tamanho da imagem
            )

            // Texto à esquerda, sem o uso de weight
            Text(
                text = user.name,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                letterSpacing = 1.sp,
                textAlign = TextAlign.Start, // Alinha o texto à esquerda
                color = Color.hsl(0f, 0f, 0f),
                modifier = Modifier
                    .padding(end = 8.dp) // Espaço à direita do texto
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowContactButtonPreview() {
    ShowContactButton(User(
        id = 1,
        name = "João"
    ))
}