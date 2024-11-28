package pt.iade.ei.sharebill

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import pt.iade.ei.sharebill.ui.menus.AmigosMenu
import pt.iade.ei.sharebill.ui.theme.ShareBillTheme

class AmigosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShareBillTheme {
                AmigosMenu()
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun AmigosActivityPreview() {
    ShareBillTheme {
        AmigosMenu()
    }
}