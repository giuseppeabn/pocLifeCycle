package com.example.poclifecycle

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        Log.d("LifeCycle", "onStart")
        mediaPlayer = MediaPlayer.create(this, R.raw.ai_2)
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer?.seekTo(position)
        Log.d("LifeCycle", "onResume")
        mediaPlayer?.start()
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifeCycle", "onPause")
        mediaPlayer?.pause()
        position = mediaPlayer!!.currentPosition
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycle", "onStop")
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LifeCycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifeCycle", "onStop")
    }
}