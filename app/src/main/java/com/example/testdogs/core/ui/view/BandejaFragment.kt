package com.example.testdogs.core.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testdogs.core.ui.viewmodel.BandejaViewModel
import com.example.testdogs.databinding.BandejaFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BandejaFragment : Fragment() {

    private lateinit var viewModel: BandejaViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
//        val binding: BandejaFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.bandeja_fragment,container,false)
        /**forma preferida para usar data binding en fragments**/
        val binding = BandejaFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }



}