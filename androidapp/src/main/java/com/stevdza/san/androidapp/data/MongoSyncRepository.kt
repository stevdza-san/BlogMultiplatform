package com.stevdza.san.androidapp.data

import com.stevdza.san.androidapp.models.PostSync
import com.stevdza.san.androidapp.util.RequestState
import kotlinx.coroutines.flow.Flow

interface MongoSyncRepository {
    fun configureTheRealm()
    fun readAllPosts(): Flow<RequestState<List<PostSync>>>
}