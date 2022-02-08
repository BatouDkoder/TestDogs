package com.example.testdogs.core.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testdogs.utils.DEFAULT_BREED

class PerfilViewModel : ViewModel() {
    /**
     * Este view model debe mandar a llamar a un caso de uso que obtenga una lista de dogs por breed,
     * luego setear la constante de breed_default a la brees escogida
     * Por ultimo navegar al fragment de home (el cual pedira la lista con el default breed y la mostrara)
     */

    val itemSelected = MutableLiveData<String>()


    fun setBreedConstant(){
        DEFAULT_BREED = itemSelected.value!!
        Log.i("HomeViewModel@setBreed", "Se ha guardado $DEFAULT_BREED")
    }
}