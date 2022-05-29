package com.mcmouse88.breakingbad_api.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.mcmouse88.breakingbad_api.presentation.viewmodel.MainViewModel

@OptIn(ExperimentalCoilApi::class)
@Composable
fun DetailScreen(viewModel: MainViewModel, itemId: String) {
    val currentItem = viewModel.allCharactersList
        .observeAsState(listOf()).value
        .firstOrNull { it.char_id == itemId.toInt() }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 24.dp, horizontal = 8.dp)
    ) {
        LazyColumn {
            item {
                Image(
                    painter = rememberImagePainter(currentItem?.img),
                    contentDescription = null,
                    modifier = Modifier.size(420.dp)
                )
                Text(
                    text = currentItem?.name ?: "",
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    textAlign = TextAlign.Center
                )
                Row(
                    modifier = Modifier.padding(8.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Nickname: ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = currentItem?.nickname ?: "",
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(
                    modifier = Modifier.padding(8.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Birthday: ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = currentItem?.birthday?.replace('-', '.') ?: "",
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(
                    modifier = Modifier.padding(8.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Category: ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = currentItem?.category ?: "",
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(
                    modifier = Modifier.padding(8.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Status: ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = currentItem?.status ?: "",
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(
                    modifier = Modifier.padding(8.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Occupation: ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(text = modify(currentItem?.occupation), fontWeight = FontWeight.Bold)
                }
            }

        }
    }
}

fun modify(list: List<String>?): String {
    var result: String? = null
    list?.let {
        val builder = StringBuilder()
        it.forEach { item -> builder.append(item).append(", ") }
        result = builder.toString().trim().substring(0, builder.lastIndex - 1)
    }
    return result ?: ""
}