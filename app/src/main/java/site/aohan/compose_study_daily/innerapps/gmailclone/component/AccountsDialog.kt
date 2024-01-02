package site.aohan.compose_study_daily.innerapps.gmailclone.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ManageAccounts
import androidx.compose.material.icons.filled.PersonAddAlt1
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.constraintlayout.compose.ConstraintLayout
import site.aohan.compose_study_daily.R

@Composable
fun AccountsDialog(openDialog: MutableState<Boolean>) {
    Dialog(
        onDismissRequest = { openDialog.value.not() },
        properties = DialogProperties(dismissOnClickOutside = true)
    ) {
        AccountsDialogUI(openDialog)
    }
}

@Composable
private fun AccountsDialogUI(openDialog: MutableState<Boolean>) {
    Card {
        ConstraintLayout(Modifier.fillMaxWidth()) {
            val (closeBtn, googleIcon) = createRefs()
            IconButton(
                onClick = { openDialog.value = false },
                modifier = Modifier.constrainAs(closeBtn) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                }
            ) {
                Icon(imageVector = Icons.Default.Close, contentDescription = null)
            }

            Image(
                painter = painterResource(id = R.drawable.ic_google),
                contentDescription = null,
                modifier = Modifier
                    .width(70.dp)
                    .constrainAs(googleIcon) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        centerVerticallyTo(closeBtn)
                    }
            )
        }
        Divider()
        Spacer(Modifier.height(16.dp))
        AccountItem("Aohan Zhang", "zhangaohan0905@gmail.com")
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "Google Account")
            }
        }

        Divider()

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items(allAccount()) {
                AccountItem(username = it.first, email = it.second)
            }
        }

        LabelAction(Icons.Default.PersonAddAlt1, "Add Another Account")
        LabelAction(Icons.Default.ManageAccounts, "Manage Accounts on this device")

        Divider()

        Spacer(modifier = Modifier.height(8.dp))
        Row(Modifier.padding(horizontal = 16.dp)) {
            Text(text = "Privacy Policy", style = MaterialTheme.typography.bodyMedium)
            Text(
                textAlign = TextAlign.Center,
                text = "*",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.weight(1f)
            )
            Text(text = "Teams Of Service", style = MaterialTheme.typography.bodyMedium)
        }
        Spacer(Modifier.height(16.dp))

    }
}


@Composable
private fun LabelAction(icon: ImageVector, title: String) {
    Row(
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            modifier = Modifier.weight(1f),
            text = title,
            style = MaterialTheme.typography.titleMedium
        )
    }
}

private fun allAccount() = listOf(
    "zhang3" to "zhang3@q.com",
    "li4" to "li4@q.com",
    "wang5" to "wang5@q.com",
)

@Composable
private fun AccountItem(username: String, email: String) {
    Row(Modifier.padding(horizontal = 16.dp)) {
        Image(
            painter = painterResource(id = R.drawable.head),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Column(Modifier.padding(start = 16.dp)) {
            Text(text = username, style = MaterialTheme.typography.titleMedium)
            Text(text = email, style = MaterialTheme.typography.bodyMedium)
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewAccountsDialog() {
    AccountsDialog(mutableStateOf(false))
}