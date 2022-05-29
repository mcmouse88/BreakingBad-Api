package com.mcmouse88.breakingbad_api.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mcmouse88.breakingbad_api.domain.models.Character
import com.mcmouse88.breakingbad_api.presentation.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ApiRepository) : ViewModel() {

    private val _allCharactersList = MutableLiveData<List<Character>>()
    val allCharactersList: LiveData<List<Character>>
        get() = _allCharactersList

    fun getAllCharacter() {
        viewModelScope.launch {
            repository.getAllCharacters().let {
                if (it.isSuccessful) {
                    _allCharactersList.postValue(it.body())
                }
                else {
                    Log.d("checkData", "Failed to load data ${it.errorBody()}")
                }
            }
        }
    }
}