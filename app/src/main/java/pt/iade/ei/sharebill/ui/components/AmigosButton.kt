package pt.iade.ei.sharebill.ui.components

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.sharebill.AmigosActivity
import pt.iade.ei.sharebill.R

@Composable
fun AmigosButton(imageRes: Int, containerColor: Color, activityClass: Class<*> ) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(vertical = 0.dp, horizontal = 0.dp)
            .size(width = 90.dp, height = 90.dp),
        colors = CardDefaults.cardColors(
            containerColor = containerColor // Cor do fundo
        ),
        onClick = {
            val intent = Intent(context, activityClass)
            context.startActivity(intent)
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // Adicionando a imagem como fundo
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Imagem de Amigos",
                contentScale = ContentScale.Crop,  // Para a imagem cobrir todo o espaço
                modifier = Modifier.fillMaxSize() // A imagem vai preencher todo o Box
            )

            // Colocando o conteúdo sobre a imagem
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AmigosButtonPreview() {
    AmigosButton(
        imageRes = R.drawable.amigos,
        containerColor = Color.Transparent ,
        AmigosActivity::class.java
    )
}