package com.example.ashish1

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ashish1.databinding.ActivityFavouriteBinding

class FavouriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavouriteBinding
    private lateinit var adapter: FavouriteAdapter

    companion object{
        var favouriteSongs : ArrayList<Music> = ArrayList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.coolPink)
        binding = ActivityFavouriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        favouriteSongs = checkPlaylist(favouriteSongs)

        binding.backBnFA.setOnClickListener { finish() }
        binding.favouriteRv.setHasFixedSize(true)
        binding.favouriteRv.setItemViewCacheSize(13)
        binding.favouriteRv.layoutManager = GridLayoutManager(this,4)
        adapter = FavouriteAdapter(this, favouriteSongs)
        binding.favouriteRv.adapter = adapter
        if(favouriteSongs.size <1)
        {
            binding.shuffleBtnFA.visibility = View.INVISIBLE
        }
        binding.shuffleBtnFA.setOnClickListener {
            val intent = Intent(this, PlayerActivity::class.java)
            intent.putExtra("index", 0)
            intent.putExtra("class", "FavouriteShuffle")
            startActivity(intent)
        }

    }
}