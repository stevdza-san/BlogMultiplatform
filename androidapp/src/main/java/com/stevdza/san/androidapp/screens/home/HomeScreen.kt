package com.stevdza.san.androidapp.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.stevdza.san.androidapp.components.PostCard
import com.stevdza.san.androidapp.models.Post
import com.stevdza.san.androidapp.util.RequestState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    posts: RequestState<List<Post>>,
    searchedPosts: RequestState<List<Post>>,
    query: String,
    searchBarOpened: Boolean,
    active: Boolean,
    onActiveChange: (Boolean) -> Unit,
    onQueryChange: (String) -> Unit,
    onSearchBarChange: (Boolean) -> Unit,
    onSearch: (String) -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Blog")
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Drawer Icon"
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            onSearchBarChange(true)
                            onActiveChange(true)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search Icon",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            )
            if (searchBarOpened) {
                SearchBar(
                    query = query,
                    onQueryChange = onQueryChange,
                    onSearch = onSearch,
                    active = active,
                    onActiveChange = onActiveChange,
                    placeholder = { Text(text = "Search here...")},
                    leadingIcon = {
                        IconButton(onClick = { onSearchBarChange(false) }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back Arrow Icon",
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    },
                    trailingIcon = {
                        IconButton(onClick = { onQueryChange("") }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Close Icon",
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                ) {
                    if (searchedPosts is RequestState.Success) {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 12.dp)
                                .padding(horizontal = 24.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            items(
                                items = searchedPosts.data,
                                key = { post -> post._id }
                            ) { post ->
                                PostCard(post = post, onPostClick = {})
                            }
                        }
                    }
                }
            }
        }
    ) {
        if (posts is RequestState.Success) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = it.calculateTopPadding())
                    .padding(horizontal = 24.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(
                    items = posts.data,
                    key = { post -> post._id }
                ) { post ->
                    PostCard(post = post, onPostClick = {})
                }
            }
        }
    }
}