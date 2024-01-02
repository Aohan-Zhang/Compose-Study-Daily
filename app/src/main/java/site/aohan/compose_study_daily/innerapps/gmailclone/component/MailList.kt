package site.aohan.compose_study_daily.innerapps.gmailclone.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import site.aohan.compose_study_daily.innerapps.gmailclone.data.Repository
import site.aohan.compose_study_daily.innerapps.gmailclone.model.MailItem

@Composable
fun MailList(modifier: Modifier = Modifier, lazyListState: LazyListState) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(5.dp),
        modifier = modifier,
        state = lazyListState
    ) {
        items(Repository.fakeMailDataList()) {
            MailItem(mailItem = it)
        }
    }
}

@Composable
private fun MailItem(modifier: Modifier = Modifier, mailItem: MailItem) {
    Card(modifier) {
        Row(
            modifier
                .padding(5.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            // 头像
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
            ) {
                Text(
                    text = mailItem.sender.first().uppercase(),
                    style = TextStyle(textAlign = TextAlign.Center, fontSize = 25.sp),
                )
            }

            Column(Modifier.padding(start = 5.dp)) {
                Text(text = mailItem.sender, style = MaterialTheme.typography.titleMedium)
                Text(text = mailItem.subject, style = MaterialTheme.typography.titleSmall)
                Text(text = mailItem.body, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewMailList() {
    MailList(lazyListState = rememberLazyListState())
}


@Preview(showBackground = true)
@Composable
private fun PreviewMailItem() {
    MailItem(mailItem = Repository.fakeMailDataList().first())
}
