package com.example.netflix.base.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.netflix.R

@Composable
fun PagerIndicator(
    modifier: Modifier = Modifier,
    pageCount: Int,
    selectedPage: Int,
    indicatorSize: Dp? = null
) {
    Row (
        modifier = modifier,
    ) {
        for(i in 0 until pageCount)
            PagerIndicatorItem(
                selected = selectedPage - i == 0,
                size = indicatorSize
            )
    }
}

@Composable
fun PagerIndicatorItem(
    selected: Boolean = false,
    size: Dp? = null,
) {
    Box (
        modifier = Modifier
            .padding(8.dp)
            .size(size ?: 11.dp)
            .clip(CircleShape)
            .background(
                if (selected)
                    colorResource(id = R.color.default_selected_pager_indicator)
                else
                    colorResource(id = R.color.default_pager_indicator)
            )
    )
}
