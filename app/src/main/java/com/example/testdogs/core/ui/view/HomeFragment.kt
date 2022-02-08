package com.example.testdogs.core.ui.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import com.example.testdogs.core.ui.viewmodel.HomeViewModel
import com.example.testdogs.utils.DEFAULT_BREED
import com.example.testdogs.databinding.HomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = HomeFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        Log.i("HomeFragment", "TEST INICIO HOMEFRAGMENT")
        val viewPager = binding.vpDog
        viewPager.setOffscreenPageLimit(10)
        val pageAdapter = HomeAdapter()

        homeViewModel.viewModelScope.launch {
            Log.i("HomeFragment", "Esto deberia iniciarse antes de caerse la app")
            homeViewModel.getDogList()
        }

        homeViewModel.isLoading.observe(this, Observer {
            if(it) binding.progressBar.visibility = View.VISIBLE
            else binding.progressBar.visibility = View.GONE
        })

        homeViewModel.dogForAdapter.observe(this, Observer {
            Log.i("HomeFragment","CAMBIO EL DOGFORADAPTER DEBERIA TENER EL RESULTADO:\n${it.toString()}")
            homeViewModel.isLoading.postValue(false)
            pageAdapter.setDogList(it)
            pageAdapter.notifyDataSetChanged()
        })

        viewPager.adapter = pageAdapter
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("HomeFragment", "onAttach")
    }
}