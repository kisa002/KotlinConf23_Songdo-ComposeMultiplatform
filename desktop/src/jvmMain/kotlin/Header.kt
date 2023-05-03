import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header(isExpanded: Boolean, onCollapsed: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().heightIn(min = 64.dp).padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AnimatedVisibility(visible = !isExpanded) {
            IconButton(onClick = onCollapsed) {
                Icon(
                    if (isExpanded) Icons.Filled.ArrowBack else Icons.Filled.ArrowForward,
                    contentDescription = if (isExpanded) "Collapse" else "Expand"
                )
            }
        }

        Text(
            text = "Stopwatch",
            modifier = Modifier.padding(start = 8.dp),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
