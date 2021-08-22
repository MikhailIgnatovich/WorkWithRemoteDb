package com.bulich.misha.workwithremotedb.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bulich.misha.workwithremotedb.R
import com.bulich.misha.workwithremotedb.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    val filmsViewModel: FilmsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.content, Home()).commit()

        binding?.bottomNav?.selectedItemId = R.id.homeItemBottomNav

        binding?.bottomNav?.setOnItemSelectedListener { item ->

            when(item.itemId) {
                R.id.homeItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, Home()).commit()
                R.id.filmsItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, Films()).commit()
            }

            return@setOnItemSelectedListener true
        }

        filmsViewModel.migration(this)
    }
}