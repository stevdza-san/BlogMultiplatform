package com.stevdza.san.androidapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import com.stevdza.san.androidapp.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.stevdza.san.androidapp.models.Category

@Composable
fun NavigationDrawer(
    drawerState: DrawerState,
    onCategorySelect: (Category) -> Unit,
    content: @Composable () -> Unit
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                content = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 100.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = "Logo Image"
                        )
                    }
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .alpha(0.5f)
                            .padding(start = 20.dp, bottom = 12.dp),
                        text = "Categories"
                    )
                    Category.values().forEach { category ->
                        NavigationDrawerItem(
                            label = {
                                Text(
                                    modifier = Modifier.padding(horizontal = 12.dp),
                                    text = category.name,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            },
                            selected = false,
                            onClick = { onCategorySelect(category) }
                        )
                    }
                }
            )
        },
        content = { content() }
    )
}