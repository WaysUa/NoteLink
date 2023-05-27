package com.main.notelink.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import androidx.viewbinding.ViewBinding
import com.main.core.sl.ProvideViewModel
import com.main.notelink.R
import com.main.notelink.databinding.ActivityMainBinding
import com.main.notelink.presentation.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), ProvideViewModel {
    private val binding: ViewBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val mainViewModel = provideViewModel(MainViewModel::class.java, this)

        mainViewModel.observe(this) { strategy ->
            strategy.navigate(supportFragmentManager, R.id.container)
        }
        mainViewModel.init(savedInstanceState == null)
    }

    override fun <T : ViewModel> provideViewModel(clazz: Class<T>, owner: ViewModelStoreOwner): T {
        return (application as ProvideViewModel).provideViewModel(clazz, owner)
    }
}