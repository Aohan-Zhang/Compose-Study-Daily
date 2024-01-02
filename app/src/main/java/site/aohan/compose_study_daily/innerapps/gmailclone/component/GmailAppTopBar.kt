package site.aohan.compose_study_daily.innerapps.gmailclone.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import site.aohan.compose_study_daily.R

@Composable
fun GmailAppTopBar(
    drawerState: DrawerState,
    coroutineScope: CoroutineScope
) {

    val openDialog = remember { mutableStateOf(false) }

    Box(modifier = Modifier.padding(10.dp)) {
        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.requiredHeight(50.dp),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    coroutineScope.launch {
                        drawerState.open()
                    }
                }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Search in emails...", modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.head),
                    contentDescription = "avatar",
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .border(width = 0.5.dp, shape = CircleShape, color = Color.Gray)
                        .clickable { openDialog.value = true },
                    contentScale = ContentScale.Crop
                )
            }

            if (openDialog.value) {
                AccountsDialog(openDialog = openDialog)
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun DefaultPreview() {
    GmailAppTopBar(
        drawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
        coroutineScope = rememberCoroutineScope(),
    )
}