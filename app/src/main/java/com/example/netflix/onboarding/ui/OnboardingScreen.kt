package com.example.netflix.onboarding.ui


import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflix.R
import com.example.netflix.base.components.PagerIndicator


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.statusBars)
            .windowInsetsPadding(WindowInsets.navigationBars)
    ) {
        val pagerState = rememberPagerState(pageCount = { 3 })
        HorizontalPager(
            state = pagerState,
        ) {
            when (it) {
                0 -> OnboardingDetails(
                    primaryText = stringResource(id = R.string.onboarding_screen_1_primary),
                    secondaryText = stringResource(id = R.string.onboarding_screen_1_secondary),
                    backgroundImage = R.drawable.onboarding_1,
                    overlay = Brush.verticalGradient(
                        0f to Color(0, 0, 0, 0xFA),
                        .1f to Color(0, 0, 0, 0xBB),
                        .4f to Color.Transparent,
                        .5f to Color(0, 0, 0, 0xBB),
                        .6f to Color(0, 0, 0, 0xEA),
                        .8f to colorResource(id = R.color.default_background),
                    )
                )

                1 -> OnboardingDetailsWithIcon(
                    primaryText = stringResource(id = R.string.onboarding_screen_2_primary),
                    secondaryText = stringResource(id = R.string.onboarding_screen_2_secondary),
                    backgroundImage = R.drawable.onboarding_2_icon,
                )

                2 -> OnboardingDetailsWithIcon(
                    primaryText = stringResource(id = R.string.onboarding_screen_3_primary),
                    secondaryText = stringResource(id = R.string.onboarding_screen_3_secondary),
                    backgroundImage = R.drawable.onboarding_3_icon,
                )
            }
        }

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsPadding(WindowInsets.navigationBars)
                .padding(horizontal = 8.dp)
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PagerIndicator(
                modifier = Modifier.padding(bottom = 14.dp),
                pageCount = 3,
                selectedPage = pagerState.currentPage
            )
            DefaultTextBtn(
                modifier = Modifier.fillMaxWidth(),
                onClick = { /*TODO*/ },
                text = stringResource(id = R.string.onboarding_main_btn),
                padding = 5.dp,
            )
        }

        TopAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
                .padding(top = 5.dp),
            title = { },
            backgroundColor = Color.Transparent,
            contentColor = Color.Transparent,
            elevation = 0.dp,
            navigationIcon = {
                Image(
                    modifier = Modifier
                        .size(width = 30.dp, height = 60.dp),
                    painter = painterResource(id = R.drawable.netflix_logo),
                    contentDescription = "App logo"
                )
            },
            actions = {
                TransparentTextBtn(
                    onClick = { /*TODO*/ },
                    text = stringResource(id = R.string.sign_in_capitalized),
                    textFont = Font(R.font.plus_jakarta_sans_bold),
                    fontSize = 16.sp,
                )
            }
        )
    }
}

@Composable
private fun OnboardingDetails(
    modifier: Modifier = Modifier,
    primaryText: String,
    primaryTextFontSize: TextUnit = 38.sp,
    secondaryText: String,
    secondaryTextFontSize: TextUnit = 18.sp,
    @DrawableRes backgroundImage: Int,
    overlay: Brush? = null,
    horizontalPadding: Dp = 60.dp,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = backgroundImage),
                contentScale = ContentScale.Crop
            )
            .background(
                brush = overlay ?: Brush.verticalGradient(
                    0f to Color.Transparent,
                    1f to Color.Transparent,
                    startY = 0f,
                    endY = 1f
                )
            ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(horizontal = horizontalPadding)
                .padding(bottom = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 50.dp),
                text = primaryText,
                fontSize = primaryTextFontSize,
                fontFamily = Font(R.font.plus_jakarta_sans_semi_bold).toFontFamily(),
                color = colorResource(id = R.color.default_text),
                textAlign = TextAlign.Center,
            )
            Text(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 50.dp),
                text = secondaryText,
                fontSize = secondaryTextFontSize,
                fontFamily = Font(R.font.plus_jakarta_sans_medium).toFontFamily(),
                color = colorResource(id = R.color.default_secondary_text),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    letterSpacing = 1.sp
                )
            )
        }
    }
}

@Composable
private fun OnboardingDetailsWithIcon(
    modifier: Modifier = Modifier,
    primaryText: String,
    primaryTextFontSize: TextUnit = 38.sp,
    secondaryText: String,
    secondaryTextFontSize: TextUnit = 18.sp,
    @DrawableRes backgroundImage: Int,
    horizontalPadding: Dp = 60.dp,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.default_background))
    ) {
        Image(
            painter = painterResource(id = backgroundImage),
            contentScale = ContentScale.Fit,
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(horizontal = horizontalPadding)
                .padding(top = 100.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(horizontal = horizontalPadding)
                .padding(bottom = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 50.dp),
                text = primaryText,
                fontSize = primaryTextFontSize,
                fontFamily = Font(R.font.plus_jakarta_sans_semi_bold).toFontFamily(),
                color = colorResource(id = R.color.default_text),
                textAlign = TextAlign.Center,
            )
            Text(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 50.dp),
                text = secondaryText,
                fontSize = secondaryTextFontSize,
                fontFamily = Font(R.font.plus_jakarta_sans_medium).toFontFamily(),
                color = colorResource(id = R.color.default_secondary_text),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    letterSpacing = 1.sp
                )
            )
        }
    }
}