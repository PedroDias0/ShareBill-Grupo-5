package pt.iade.ei.sharebill.ui.menus

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.sharebill.R
import pt.iade.ei.sharebill.ui.components.CriarContaButton1
import pt.iade.ei.sharebill.ui.components.JaTenhoContaButton

@Composable

fun CriarContaMenu() {
    Scaffold(
        containerColor = Color.Transparent
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 40.dp), // Ajuste de padding superior para espaçamento global
                horizontalAlignment = Alignment.CenterHorizontally // Alinha os elementos horizontalmente ao centro
            ) {
                // Logo
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = "Logo",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(250.dp, 300.dp)
                        .padding(bottom = 50.dp, top = 10.dp) // Padding individual para o logo
                )
                val borderStrokeWidthSize = 3.0f
                Text(
                    text = "NOME",
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(end = 230.dp, top = 0.dp), // Padding individual para o texto
                    fontSize = 18.sp,
                    letterSpacing = 2.sp,
                    textAlign = TextAlign.Center,
                    color = Color.hsl(199f, 0.33f, 0.20f)
                )
                OutlinedCard(
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 15.dp)
                        .size(width = 338.dp, height = 44.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.hsl(0f,0f,1f)),
                    border = BorderStroke(borderStrokeWidthSize.dp, Color.hsl(199f, 0.33f, 0.20f)),
                    shape = RoundedCornerShape(30.dp)
                ) {  }

                // Texto "E-MAIL"
                Text(
                    text = "E-MAIL",
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(end = 220.dp), // Padding individual para o texto
                    fontSize = 18.sp,
                    letterSpacing = 2.sp,
                    textAlign = TextAlign.Center,
                    color = Color.hsl(199f, 0.33f, 0.20f)
                )
                OutlinedCard(
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 20.dp)
                        .size(width = 338.dp, height = 44.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.hsl(0f,0f,1f)),
                    border = BorderStroke(borderStrokeWidthSize.dp, Color.hsl(199f, 0.33f, 0.20f)),
                    shape = RoundedCornerShape(30.dp)
                ) {  }
                Text(
                    text = "PASSWORD",
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(end = 190.dp), // Padding individual para o texto
                    fontSize = 18.sp,
                    letterSpacing = 2.sp,
                    textAlign = TextAlign.Center,
                    color = Color.hsl(199f, 0.33f, 0.20f)
                )
                OutlinedCard(
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 20.dp)
                        .size(width = 338.dp, height = 44.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.hsl(0f,0f,1f)),
                    border = BorderStroke(borderStrokeWidthSize.dp, Color.hsl(199f, 0.33f, 0.20f)),
                    shape = RoundedCornerShape(30.dp)
                ){}

                // Espaço entre o texto e o botão
                Spacer(modifier = Modifier.height(0.dp))
                // Botão Criar Conta
                CriarContaButton1("Criar Conta")

                Spacer(modifier = Modifier.height(120.dp))
                JaTenhoContaButton("Já tenho uma conta.", Color.hsl(172f,0.23f,0.46f))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable

fun CriarContaMenuPreview(){
    CriarContaMenu()
}