package com.example.testdogs.core.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.testdogs.core.ui.viewmodel.TendenciasViewModel
import com.example.testdogs.databinding.TendenciasFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TendenciasFragment : Fragment(),SearchView.OnQueryTextListener {

    private lateinit var searchViewModel: TendenciasViewModel
    private lateinit var binding: TendenciasFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        binding = TendenciasFragmentBinding.inflate(inflater,container,false)
        searchViewModel = ViewModelProvider(this).get(TendenciasViewModel::class.java)
        binding.svDogs.setOnQueryTextListener(this)

        searchViewModel.existList.observe(this, Observer {
            if (it){
                searchViewModel.finishedSearch()
                findNavController().navigate(TendenciasFragmentDirections.actionTendenciasFragmentToHomeFragment())
            }
            else{
                binding.tvNotFound.visibility = View.VISIBLE
            }
        })

        searchViewModel.notFound.observe(this, Observer {
            if (searchViewModel.notFound.value!!){
                binding.tvNotFound.visibility = View.VISIBLE
            }
            else{
                binding.tvNotFound.visibility = View.GONE
            }
        })

        return binding.root
    }

    override fun onQueryTextSubmit(textToSearch: String): Boolean {
        searchViewModel.checkBreedExist(textToSearch)
        return searchViewModel.existList.value!!
    }

    override fun onQueryTextChange(letter: String?): Boolean {
        binding.tvNotFound.visibility = View.GONE
        return true
    }
}