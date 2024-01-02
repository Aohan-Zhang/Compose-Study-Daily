package site.aohan.compose_study_daily.innerapps.gmailclone.component

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.VideoCall
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import site.aohan.compose_study_daily.innerapps.gmailclone.model.BottomMenuItem

@Composable
fun GmailAppBottomBar() {

    val itemList = listOf(
        BottomMenuItem("Mail", Icons.Outlined.Mail),
        BottomMenuItem("Meet", Icons.Outlined.VideoCall),
    )
    BottomNavigation(
        contentColor = MaterialTheme.colorScheme.onBackground,
        backgroundColor = MaterialTheme.colorScheme.background
    ) {
        itemList.forEach { item ->
            BottomNavigationItem(
                alwaysShowLabel = true,
                label = { Text(text = item.title) },
                selected = false,
                onClick = { /*TODO*/ },
                icon = { Icon(imageVector = item.icon, contentDescription = item.title) }
            )
        }
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    GmailAppBottomBar()
}