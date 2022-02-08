package com.example.testdogs.core.ui.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.testdogs.R
import com.example.testdogs.core.ui.viewmodel.PerfilViewModel
import com.example.testdogs.databinding.PerfilFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PerfilFragment : Fragment() {
//    private val perfilViewModel: HomeViewModel by activityViewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val binding = PerfilFragmentBinding.inflate(inflater, container, false)
        val perfilViewModel = ViewModelProvider(this).get(PerfilViewModel::class.java)

        binding.lifecycleOwner = this
        val spinner = binding.profileSpinner
        ArrayAdapter.createFromResource(context!!,R.array.breeds,android.R.layout.simple_spinner_item)
            .also { adapter->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter=adapter
            }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                perfilViewModel.itemSelected.value = parent?.selectedItem.toString().lowercase()
                Log.i("PerfilFragment","se clickeado en un item: ${parent?.selectedItem}")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        binding.profileBreedButton.setOnClickListener {
            perfilViewModel.setBreedConstant()
//            findNavController().navigate(PerfilFragmentDirections.actionPerfilFragmentToHomeFragment())
//            findNavController().navigate(R.id.perfilFragment)
        }

        return binding.root
    }
}