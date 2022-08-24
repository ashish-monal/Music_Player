package com.example.ashish1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ashish1.databinding.ActivityDeveloperBinding

class DeveloperActivity : AppCompatActivity() {
    lateinit var binding : ActivityDeveloperBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.coolPinkNav)
        binding= ActivityDeveloperBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title= "Developer"
    }
}