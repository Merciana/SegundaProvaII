package com.example.segundaprovaii

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment

class FragmentHome : Fragment() {

    lateinit var binding: HomefragmentBinding
    lateinit var viewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
// Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

}


