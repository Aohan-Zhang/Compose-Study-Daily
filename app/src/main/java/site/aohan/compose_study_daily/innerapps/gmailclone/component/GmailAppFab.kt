package site.aohan.compose_study_daily.innerapps.gmailclone.component

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun GmailFab(lazyListState: LazyListState) {
//    var previousOffset by remember { mutableStateOf(0f) }
//    val firstOffset = remember { derivedStateOf { lazyListState.firstVisibleItemScrollOffset } }
//    if (previousOffset < firstOffset.value) {
    ExtendedFloatingActionButton(
        containerColor = MaterialTheme.colorScheme.surface,
        text = { Text(text = "Compose") },
        icon = {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = null,
            )
        },
        onClick = { /*TODO*/ })
//    } else {
//        FloatingActionButton(
//            onClick = { /*TODO*/ },
//            modifier = Modifier.background(MaterialTheme.colorScheme.surface)
//        ) {
//            Icon(imageVector = Icons.Default.Edit, contentDescription = null)
//        }
//    }
//    previousOffset = firstOffset.value.toFloat()
}

@Preview(showBackground = true)
@Composable
private fun PreviewGmailFabWithText() {
    val state = rememberLazyListState()
    GmailFab(state)
}

@Preview(showBackground = true)
@Composable
private fun PreviewGmailFabSingle() {
    val state = rememberLazyListState()
    GmailFab(state)
}