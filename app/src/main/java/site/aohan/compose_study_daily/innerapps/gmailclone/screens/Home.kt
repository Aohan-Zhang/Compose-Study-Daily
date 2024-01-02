package site.aohan.compose_study_daily.innerapps.gmailclone.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import site.aohan.compose_study_daily.innerapps.gmailclone.component.GmailAppBottomBar
import site.aohan.compose_study_daily.innerapps.gmailclone.component.GmailAppTopBar
import site.aohan.compose_study_daily.innerapps.gmailclone.component.GmailFab
import site.aohan.compose_study_daily.innerapps.gmailclone.component.MailList

@Composable
fun HomeScreen(drawerState: DrawerState, coroutineScope: CoroutineScope) {

    val lazyListState = rememberLazyListState()
    Scaffold(
        topBar = { GmailAppTopBar(drawerState, coroutineScope) },
        bottomBar = { GmailAppBottomBar() },
        floatingActionButton = { GmailFab(lazyListState) }
    ) {
        MailList(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 10.dp),
            lazyListState = lazyListState
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHomeScreen() {
    HomeScreen(
        drawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
        coroutineScope = rememberCoroutineScope()
    )
}