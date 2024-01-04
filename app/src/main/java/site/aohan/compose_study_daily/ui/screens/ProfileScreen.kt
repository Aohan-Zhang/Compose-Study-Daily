package site.aohan.compose_study_daily.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import site.aohan.compose_study_daily.R
import site.aohan.compose_study_daily.model.NavigationEnum

@Composable
fun ProfileScreen(navHostController: NavHostController) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {
        BoxWithConstraints(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
            val constraintSet = if (maxWidth < maxHeight) {
                getVerticalConstraint()
            } else {
                getHorizontalConstraint()
            }

            ConstraintLayout(
                constraintSet = constraintSet,
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 10.dp, vertical = 30.dp),
            ) {

                Image(
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .border(width = 2.dp, shape = CircleShape, color = Color.Red)
                        .layoutId("avatar"),
                    painter = painterResource(id = R.drawable.head),
                    contentDescription = "head",
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Aohan Zhang",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.layoutId("nameText")
                )
                Text(
                    text = "A Chinese Android Develop.",
                    modifier = Modifier.layoutId("descText")
                )

                LinkButton(
                    modifier = Modifier.layoutId("githubBtn"),
                    url = "https://github.com/Aohan-Zhang",
                    icId = R.drawable.ic_github,
                    title = "Github",
                    navHostController
                )
                LinkButton(
                    modifier = Modifier.layoutId("giteeBtn"),
                    url = "https://gitee.com/aohanaohan",
                    icId = R.drawable.ic_gitee,
                    title = "Gitee",
                    navHostController
                )
            }
        }
    }
}

/**
 * 水平布局
 */
private fun getHorizontalConstraint() = ConstraintSet {
    val horizontalCenterGuideLine = createGuidelineFromTop(0.5F)
    val verticalCenterGuideLine = createGuidelineFromStart(0.5F)
    createGuidelineFromStart(0.5F)
    val avatar = createRefFor("avatar")
    constrain(avatar) {
        top.linkTo(parent.top)
        end.linkTo(verticalCenterGuideLine)
        start.linkTo(parent.start)
    }

    val nameText = createRefFor("nameText")
    constrain(nameText) {
        top.linkTo(avatar.bottom)
        end.linkTo(verticalCenterGuideLine)
        start.linkTo(parent.start)
    }

    val descText = createRefFor("descText")
    constrain(descText) {
        top.linkTo(nameText.bottom)
        end.linkTo(verticalCenterGuideLine)
        start.linkTo(parent.start)
    }

    val githubBtn = createRefFor("githubBtn")
    constrain(githubBtn) {
        start.linkTo(verticalCenterGuideLine)
        bottom.linkTo(horizontalCenterGuideLine)
        end.linkTo(parent.end)
    }

    val giteeBtn = createRefFor("giteeBtn")
    constrain(giteeBtn) {
        top.linkTo(horizontalCenterGuideLine)
        start.linkTo(verticalCenterGuideLine)
        end.linkTo(parent.end)
    }
}


/**
 * 竖向布局
 */
private fun getVerticalConstraint() = ConstraintSet {
    val avatar = createRefFor("avatar")
    constrain(avatar) {
        top.linkTo(parent.top)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
    }

    val nameText = createRefFor("nameText")
    constrain(nameText) {
        top.linkTo(avatar.bottom)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
    }

    val descText = createRefFor("descText")
    constrain(descText) {
        top.linkTo(nameText.bottom)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
    }

    val githubBtn = createRefFor("githubBtn")
    constrain(githubBtn) {
        top.linkTo(descText.bottom)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
    }

    val giteeBtn = createRefFor("giteeBtn")
    constrain(giteeBtn) {
        top.linkTo(githubBtn.bottom)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
    }

}


@Composable
private fun LinkButton(
    modifier: Modifier = Modifier,
    url: String,
    @DrawableRes icId: Int,
    title: String,
    navHostController: NavHostController
) {
    OutlinedButton(
        modifier = modifier.width(300.dp),
        onClick = {
            navHostController.navigate(NavigationEnum.WebView.of(url))
        }) {
        Row(Modifier.align(Alignment.CenterVertically)) {
            Icon(
                painter = painterResource(id = icId),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = title,
                fontSize = 16.sp
            )
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewProfileScreen() {
    ProfileScreen(navHostController = rememberNavController())
}