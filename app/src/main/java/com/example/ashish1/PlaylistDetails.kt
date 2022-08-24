package com.example.ashish1

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.ashish1.databinding.ActivityPlaylistDetailsBinding

class PlaylistDetails : AppCompatActivity() {
    lateinit var binding: ActivityPlaylistDetailsBinding
    lateinit var adapter: MusicAdapter

    companion object {
        var currentPlaylistPos: Int = -1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.coolPink)
        binding = ActivityPlaylistDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        currentPlaylistPos = intent.extras?.get("index") as Int

//        PlaylistActivity.musicPlaylist.ref[currentPlaylistPos].playlist=
//            checkPlaylist(playlist = PlaylistActivity.musicPlaylist.ref[currentPlaylistPos].playlist)
        binding.playlistDetailsRV.setItemViewCacheSize(10)
        binding.playlistDetailsRV.setHasFixedSize(true)
        binding.playlistDetailsRV.layoutManager = LinearLayoutManager(this)
        PlaylistActivity.musicPlaylist.ref[currentPlaylistPos].playlist
        PlaylistActivity.musicPlaylist.ref[currentPlaylistPos].playlist.shuffle()
       // adapter = MusicAdapter(this)
        binding.playlistDetailsRV.adapter = adapter
    }

    @SuppressLint("SetTextI18n")
    override fun onResume() {
        super.onResume()
        binding.playlistNamePD.text = PlaylistActivity.musicPlaylist.ref[currentPlaylistPos].name
        binding.moreInfoPD.text =
            "Total ${adapter.itemCount} Songs.\n\n" + "Created On: ${PlaylistActivity.musicPlaylist.ref[currentPlaylistPos].createdOn}\n\n"+
        "-- ${PlaylistActivity.musicPlaylist.ref[currentPlaylistPos].createdBy}"


        if (adapter.itemCount > 0){
            Glide.with(this)
                .load(PlaylistActivity.musicPlaylist.ref[currentPlaylistPos].playlist[0])
                .apply(RequestOptions().placeholder(R.drawable.music).centerCrop())
                .into(binding.playlistImgPD)
            binding.shuffleBtnPD.visibility=View.VISIBLE

        }
    }
}