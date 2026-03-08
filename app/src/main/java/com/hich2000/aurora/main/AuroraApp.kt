package com.hich2000.aurora.main

import android.widget.Toast
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.hich2000.aurora.main.navigation.LocalNavController
import com.hich2000.aurora.main.navigation.Route
import com.hich2000.aurora.music.playerScreen.queue.QueueBuilder
import com.hich2000.aurora.music.songScreen.songTagScreen.SongTagScreen
import com.hich2000.aurora.settings.folderScreen.FolderScreen
import com.hich2000.aurora.settings.generalScreen.GeneralScreen
import com.hich2000.aurora.settings.themesScreen.ThemesScreen
import com.hich2000.aurora.tagsAndCategories.tags.tagScreen.TagSongScreen
import com.hich2000.aurora.utils.ToastEventBus

@Composable
fun AuroraApp() {
    val rootNavController = rememberNavController()
    val context = LocalContext.current
    val slideSpeed = 250

    LaunchedEffect(Unit) {
        ToastEventBus.toastFlow.collect { message ->
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }

    CompositionLocalProvider(LocalNavController provides rootNavController) {
        NavHost(
            navController = rootNavController,
            route = Route.Root.route,
            startDestination = Route.Main.route,
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Up,
                    tween(slideSpeed)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Up,
                    tween(slideSpeed)
                )
            },
            popEnterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Down,
                    tween(slideSpeed)
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Down,
                    tween(slideSpeed)
                )
            }
        ) {
            //main screen with bottom nav bar
            composable(
                route = Route.Main.route
            ) {
                MainNavScaffold()
            }

            //sub screens without bottom nav bar
            composable(
                route = Route.Player.QueueBuilder.route
            ) {
                QueueBuilder()
            }
            composable(
                route = Route.Songs.Tags.route,
                arguments = listOf(
                    navArgument("songTitle") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val songTitle = backStackEntry.arguments?.getString("songTitle") ?: ""
                SongTagScreen(songTitle)
            }
            composable(
                route = Route.Tags.Songs.route,
                arguments = listOf(
                    navArgument("tagId") { type = NavType.LongType }
                )
            ) { backStackEntry ->
                val tagId = backStackEntry.arguments?.getLong("tagId") ?: 0L
                TagSongScreen(tagId)
            }
            composable(
                route = Route.Settings.General.route
            ) {
                GeneralScreen()
            }
            composable(
                route = Route.Settings.Folders.route
            ) {
                FolderScreen()
            }
            composable(
                route = Route.Settings.Themes.route
            ) {
                ThemesScreen()
            }
        }
    }
}