package com.mcmouse88.breakingbad_api.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.mcmouse88.breakingbad_api.data.navigation.Screens
import com.mcmouse88.breakingbad_api.domain.models.Character
import com.mcmouse88.breakingbad_api.presentation.viewmodel.MainViewModel

@Composable
fun MainScreen(navController: NavHostController, viewModel: MainViewModel) {
    val allCharacters = viewModel.allCharactersList.observeAsState(listOf()).value
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.padding(20.dp)
        ) {
            items(allCharacters) { item ->
                CharacterItem(item = item, navController = navController)
            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CharacterItem(item: Character, navController: NavHostController) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(top = 8.dp)
            .clickable {
                navController.navigate(Screens.Detail.route + "/${item.char_id}")
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Image(
                painter = rememberImagePainter(item.img),
                contentDescription = null,
                modifier = Modifier.size(128.dp),
                contentScale = ContentScale.Inside
            )
            Column(
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(
                    text = item.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Row {
                    Text(
                        text = "Nickname: ",
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = item.nickname)
                }
                Row {
                    Text(
                        text = "Birthday: ",
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = item.birthday.replace('-', '.'))
                }
                Row {
                    Text(
                        text = "Status: ",
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = item.status)
                }
            }
        }
    }
}