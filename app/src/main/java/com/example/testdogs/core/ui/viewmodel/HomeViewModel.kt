package com.example.testdogs.core.ui.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.testdogs.domain.model.DogList
import com.example.testdogs.usecases.GetDogsByBreedUseCase
import com.example.testdogs.utils.DEFAULT_BREED
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getDogUseCase: GetDogsByBreedUseCase
) : ViewModel() {

    val dogList = MutableLiveData<DogList?>()
    val dogForAdapter: LiveData<DogList> =
        Transformations.map(dogList){ dogList.value }

    val isLoading = MutableLiveData<Boolean>()

//    init {
//        viewModelScope.launch { getDogList() }
//    }

    suspend fun getDogList() {
        isLoading.postValue(true)
        Log.i("HomeViewModel@getDogLis", "${DEFAULT_BREED}")
        viewModelScope.launch {
            val result = getDogUseCase.getDogListByBreed(DEFAULT_BREED)
            if (result.dogs.isNotEmpty()){
                dogList.postValue(result)
            }
            Log.i("HomeViewModel@getdoglis", "despues del post value:\n${result.toString()}")
        }
    }
}