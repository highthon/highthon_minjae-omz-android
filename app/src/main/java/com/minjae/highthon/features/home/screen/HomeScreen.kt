package com.minjae.highthon.features.home.screen

import android.nfc.Tag
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import com.minjae.highthon.R
import com.minjae.highthon.core.component.Banner
import com.minjae.highthon.core.modifier.omzClickable
import com.minjae.highthon.core.theme.Headline1
import com.minjae.highthon.core.theme.Headline2
import com.minjae.highthon.core.theme.OmzColor
import com.minjae.highthon.core.theme.Option
import com.minjae.highthon.core.theme.Tag1
import com.minjae.highthon.core.theme.Tag2
import com.minjae.highthon.root.NavGroup

private val feed: List<FeedItem> = (1..10).map {
    FeedItem(
        number = 1,
        title = "게시글 $1",
        writer = Writer(
            name = "user",
            type = MZType.M,
            rank = Rank.Bronze,
        ),
        commentNum = 10,
        seeNum = 10,
        goodNum = 10,
    )
}.toList()

@Composable
fun HomeScreen(
//    homeVM: HomeVM,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomEnd,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(OmzColor.BackgroundColor)
                .verticalScroll(rememberScrollState())
        ) {
            TopLogo()

            Banner(image = painterResource(id = R.drawable.main_banner))

            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                painter = painterResource(id = R.drawable.fake_home),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .background(OmzColor.DIVIDER)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp)
                    .padding(
                        horizontal = 20.dp,
                        vertical = 12.dp,
                    ),
            ) {
                Headline1(text = "최신 게시글")
            }

            Divider()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp)
                    .padding(
                        horizontal = 20.dp,
                        vertical = 12.dp,
                    ),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_btn_all),
                    contentDescription = null,
                    modifier = Modifier.size(60.dp, 30.dp),
                    contentScale = ContentScale.FillWidth,
                )

                Spacer(modifier = Modifier.width(16.dp))

                Headline2(text = "Z세대", color = OmzColor.Gray80)

                Spacer(modifier = Modifier.width(16.dp))

                Headline2(text = "M세대", color = OmzColor.Gray80)
            }

            Divider()

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clickable {
                        navController.navigate(NavGroup.Home.HOME_DETAIL)
                    },
                painter = painterResource(id = R.drawable.ic_detail_a),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
            )
        }

        Image(
            painter = painterResource(id = R.drawable.ic_button2),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .size(48.dp)
                .offset(x = -32.dp, y = -32.dp)
                .clickable {
                    navController.navigate(NavGroup.Home.WRITE)
                }
        )
    }
}

enum class MZType(
    val text: String,
) {
    M("M세대"),
    Z("Z세대"),
}

enum class Rank {
    Iron,
    Bronze,
    Silver,
    Gold,
    Platinum,
    Diamond,
    Master,
}

data class Writer(
    val name: String = "민재",
    val type: MZType = MZType.M,
    val rank: Rank,
)

data class FeedItem(
    val number: Int,
    val title: String,
    val writer: Writer,
    val commentNum: Int,
    val seeNum: Int,
    val goodNum: Int,
)

@Composable
private fun HomeFeedLayout(
    feed: FeedItem,
    onClicked: (Int) -> Unit,
) {
    Row(
        modifier = Modifier
            .omzClickable {
                onClicked(feed.number)
            }
            .fillMaxWidth()
            .padding(
                horizontal = 20.dp,
                vertical = 16.dp,
            )
    ) {
        Box(
            modifier = Modifier.fillMaxHeight(),
            contentAlignment = Alignment.TopCenter,
        ) {
            Option(text = "${feed.number}")
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Headline2(text = feed.title)

            Spacer(modifier = Modifier.height(4.dp))

            Row {
                Tag1(text = feed.writer.name + " · ")

                Tag1(
                    text = feed.writer.type.text,
                    color = OmzColor.DarkOrange,
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                HomeIconText(
                    painter = painterResource(id = R.drawable.ic_comment),
                    text = feed.commentNum.toString(),
                )
                HomeIconText(
                    painter = painterResource(id = R.drawable.ic_see),
                    text = feed.seeNum.toString(),
                )
                HomeIconText(
                    painter = painterResource(id = R.drawable.ic_good),
                    text = feed.goodNum.toString(),
                )
            }
        }
    }
}

@Composable
fun HomeFeedDetailLayout(
    feed: FeedItem,
    detail: String,
    onClicked: (Int) -> Unit,
    onGoodClicked: () -> Unit,
    onWriteClicked: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 20.dp,
            )
            .padding(
                top = 16.dp
            ),
    ) {
        Headline2(text = feed.title)

        Spacer(modifier = Modifier.height(4.dp))

        Row {
            Tag1(text = feed.writer.name + " · ")

            Tag1(
                text = feed.writer.type.text,
                color = OmzColor.DarkOrange,
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Tag1(
            text = detail,
            color = OmzColor.Gray60,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            HomeIconText(
                painter = painterResource(id = R.drawable.ic_comment),
                text = feed.commentNum.toString(),
            )
            HomeIconText(
                painter = painterResource(id = R.drawable.ic_see),
                text = feed.seeNum.toString(),
            )
            HomeIconText(
                painter = painterResource(id = R.drawable.ic_good),
                text = feed.goodNum.toString(),
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Divider()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(38.dp),
        ) {
            HomeIconText(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight(),
                painter = painterResource(id = R.drawable.ic_heart),
                text = "좋아요",
                onClicked = {},
            )
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
                    .padding(vertical = 12.dp)
                    .background(color = OmzColor.DIVIDER),
            )
            HomeIconText(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.ic_comment),
                text = "댓글 적기",
                onClicked = {},
            )
        }
    }
}

@Composable
fun HomeIconText(
    modifier: Modifier = Modifier,
    onClicked: () -> Unit = {},
    painter: Painter,
    text: String,
) {
    Row(
        modifier = modifier
            .omzClickable {
                onClicked()
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Image(
            modifier = Modifier
                .size(12.dp),
            painter = painter,
            contentDescription = null,
        )

        Spacer(modifier = Modifier.width(2.dp))

        Tag2(
            text = text,
            color = OmzColor.Gray40,
        )
    }
}

@Composable
private fun TopLogo() {
    Box(
        modifier = Modifier
            .background(color = OmzColor.MainColor)
    ) {
        Image(
            painter = painterResource(id = R.drawable.omz_header),
            contentDescription = null,
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun TopLogoPreview() {
    TopLogo()
}

@Preview
@Composable
fun HomePreview() {
//    HomeScreen()
}