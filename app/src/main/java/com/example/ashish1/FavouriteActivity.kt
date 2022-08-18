package com.example.ashish1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ashish1.databinding.ActivityPlaylistBinding

class FavouriteActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPlaylistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.coolPink)
        binding = ActivityPlaylistBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}