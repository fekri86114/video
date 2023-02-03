package info.fekri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import info.fekri.databinding.ActivityMainBinding

const val VIDEO_URL = "https://dunijet.ir/video/barname%20nevis%20ha%20az%20koja%20prozhe%20migiran.mp4"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.videoView.setVideoPath(VIDEO_URL)
        binding.videoView.setOnPreparedListener {
            binding.videoView.start()

            val mediaController = MediaController( this )
            mediaController.setMediaPlayer( binding.videoView )
            binding.videoView.setMediaController( mediaController ) // set mediaController
            mediaController.setAnchorView( binding.videoView ) // set mediaController on videView
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        // stop video
        binding.videoView.stopPlayback()
    }

}