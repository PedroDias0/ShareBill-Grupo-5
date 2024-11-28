package pt.iade.ei.sharebill.ui.components

import android.content.Intent
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
import pt.iade.ei.sharebill.AmigosActivity

@Composable
fun LoginButton(name: String,  activityClass: Class<*>) {
    val borderStrokeWidthSize = 3.0f
    val context = LocalContext.current
    OutlinedCard(
        modifier = Modifier
            .padding(vertical = 15.dp, horizontal = 8.dp)
            .size(width = 338.dp, height = 44.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.hsl(172f,0.23f,0.46f)),
        border = BorderStroke(borderStrokeWidthSize.dp, Color.hsl(199f, 0.33f, 0.20f)),
        shape = RoundedCornerShape(30.dp),
        onClick = {
            val intent = Intent(context, activityClass)
            context.startActivity(intent)
        }
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
                        color = Color.White,
                    )
                }
            }
        }
}


@Preview(showBackground = true)
@Composable
fun LoginButtonPreview(){
    LoginButton("LOGIN",
        AmigosActivity::class.java)

}