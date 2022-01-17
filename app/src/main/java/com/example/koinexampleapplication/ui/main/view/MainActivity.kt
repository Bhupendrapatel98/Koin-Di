package com.example.koinexampleapplication.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.koinexampleapplication.R
import com.example.koinexampleapplication.databinding.ActivityMainBinding
import com.example.koinexampleapplication.ui.main.viewModel.MainViewModel
import com.example.koinexampleapplication.utills.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //mainViewModel.getUsers()

        mainViewModel.users.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    // progressBar.visibility = View.GONE
                    binding.data = it.data
                }
                Status.LOADING -> {
                    //  progressBar.visibility = View.VISIBLE
                    Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show()
                }
                Status.ERROR -> {
                    // progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }

            }
        })
    }
}