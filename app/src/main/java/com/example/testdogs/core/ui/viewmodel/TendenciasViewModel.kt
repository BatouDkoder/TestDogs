package com.example.testdogs.core.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testdogs.usecases.GetDogsByBreedUseCase
import com.example.testdogs.utils.DEFAULT_BREED
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TendenciasViewModel @Inject constructor(
    private val getDogUseCase: GetDogsByBreedUseCase
) : ViewModel() {

    val existList = MutableLiveData<Boolean>(false)
    val notFound = MutableLiveData<Boolean>(false)


    fun checkBreedExist(text: String) {
        val textToSearch=text.replace(" ","-")
        Log.i("TendenciasViewModel", "checkeando el breed....$textToSearch")

        viewModelScope.launch {
            val result = getDogUseCase.getDogListByBreed(textToSearch)
            if (!result.dogs.isNullOrEmpty()){
                existList.postValue(true)
                notFound.postValue(false)
                setDefaultBreed(textToSearch)
            }
            else{
                Log.i("TendenciasViewModel", "No encontrado xd")
                notFound.postValue(true)
            }
        }
    }

    private fun setDefaultBreed(breed: String) {
        DEFAULT_BREED=breed
    }

    fun finishedSearch() {
//        existList.postValue(false)
//        notFound.postValue(false)
    }
}