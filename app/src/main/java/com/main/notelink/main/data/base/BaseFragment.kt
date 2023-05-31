package com.main.notelink.main.data.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.main.notelink.main.sl.ProvideViewModel

abstract class BaseFragment<T: ViewModel> : Fragment() {

    protected lateinit var viewModel: T
    protected abstract val viewModelClass: Class<T>
    protected abstract val binding: ViewBinding
    protected lateinit var activity: FragmentActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = (requireActivity() as ProvideViewModel).provideViewModel(viewModelClass, this)
        activity = requireActivity()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root
}