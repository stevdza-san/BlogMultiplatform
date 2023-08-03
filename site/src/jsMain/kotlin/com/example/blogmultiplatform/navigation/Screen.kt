package com.example.blogmultiplatform.navigation

import com.example.blogmultiplatform.util.Constants.QUERY_PARAM

sealed class Screen(val route: String) {
    object AdminHome : Screen(route = "/admin/")
    object AdminLogin : Screen(route = "/admin/login")
    object AdminCreate : Screen(route = "/admin/create")
    object AdminMyPosts : Screen(route = "/admin/myposts") {
        fun searchByTitle(query: String) = "/admin/myposts?${QUERY_PARAM}=$query"
    }

    object AdminSuccess : Screen(route = "/admin/success")
}