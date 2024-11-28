package pt.iade.ei.sharebill.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
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
fun CriarContaButton(name: String) {
    val borderStrokeWidthSize = 3.0f
    LocalContext.current
    OutlinedCard(
        modifier = Modifier
            .padding(bottom = 15.dp, end = 8.dp , start = 8.dp)
            .size(width = 338.dp, height = 44.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.hsl(0f,0f,1f)),
        border = BorderStroke(borderStrokeWidthSize.dp, Color.hsl(199f, 0.33f, 0.20f)),
        shape = RoundedCornerShape(30.dp)
    ){

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                // Texto principal
                Text(
                    text = name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    letterSpacing = 2.sp,
                    textAlign = TextAlign.Center,
                    color = Color.hsl(199f, 0.33f, 0.20f),
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CriarContaButtonPreview(){
    CriarContaButton("CRIAR CONTA")

}