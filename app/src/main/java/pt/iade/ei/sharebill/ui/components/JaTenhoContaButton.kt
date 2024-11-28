package pt.iade.ei.sharebill.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun JaTenhoContaButton(name: String, containerColor: Color) {
    LocalContext.current
    Card(
        modifier = Modifier
            .padding(vertical = 0.dp, horizontal = 0.dp)
            .size(width = 240.dp, height = 25.dp),
        colors = CardDefaults.cardColors(
            containerColor =  Color.hsl(0f, 0f, 1f)// Cor do fundo
        )
    ) {

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                // Texto principal
                Text(
                    text = name,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp,
                    letterSpacing = 0.5.sp,
                    textAlign = TextAlign.Center,
                    color = containerColor
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun JaTenhoContaButtonPreview(){
    JaTenhoContaButton("Já tenho uma conta.", Color.hsl(0f, 0f, 0f))

}
