package com.stevdza.san.androidapp.screens.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stevdza.san.androidapp.data.MongoSync
import com.stevdza.san.androidapp.models.Post
import com.stevdza.san.androidapp.util.Constants.APP_ID
import com.stevdza.san.androidapp.util.RequestState
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.Credentials
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _allPosts: MutableState<RequestState<List<Post>>> =
        mutableStateOf(RequestState.Idle)
    val allPosts: State<RequestState<List<Post>>> = _allPosts
    private val _searchedPosts: MutableState<RequestState<List<Post>>> =
        mutableStateOf(RequestState.Idle)
    val searchedPosts: State<RequestState<List<Post>>> = _searchedPosts

    init {
        viewModelScope.launch(Dispatchers.IO) {
            App.create(APP_ID).login(Credentials.anonymous())
            fetchAllPosts()
        }
    }

    private suspend fun fetchAllPosts() {
        viewModelScope.launch {
            MongoSync.readAllPosts().collectLatest {
                _allPosts.value = it
            }
        }
    }

    fun searchPostsByTitle(query: String) {
        viewModelScope.launch {
            MongoSync.searchPostsByTitle(query = query).collectLatest {
                _searchedPosts.value = it
            }
        }
    }

    fun resetSearchedPosts() {
        _searchedPosts.value = RequestState.Idle
    }
}