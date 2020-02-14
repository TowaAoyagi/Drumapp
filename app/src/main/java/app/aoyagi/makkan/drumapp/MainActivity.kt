package app.aoyagi.makkan.drumapp

import android.media.AudioAttributes
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var mSoundPool: SoundPool
    private lateinit var mSoundId: Array<Int?>
    private val mSoundResource = arrayOf(
        R.raw.cymbal1,
        R.raw.cymbal2,
        R.raw.cymbal3,
        R.raw.tom1,
        R.raw.tom2,
        R.raw.tom3,
        R.raw.hihat,
        R.raw.snare,
        R.raw.bass
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_MEDIA)
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .build()
        mSoundPool = SoundPool.Builder()
            .setAudioAttributes(audioAttributes)
            .setMaxStreams(mSoundResource.size)
            .build()

        mSoundId = arrayOfNulls(mSoundResource.size)

        for (i in 0 until (mSoundResource.size - 1)) {
            mSoundId[i] = mSoundPool.load(applicationContext, mSoundResource[i], 0)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mSoundPool.release()
    }

    fun cymbal1(v:View){
        play_music(0)
    }

    fun cymbal2(v:View){
        play_music(1)
    }

    fun cymbal3(v:View){
        play_music(2)
    }

    fun tom1(v:View){
        play_music(3)
    }

    fun tom2(v:View){
        play_music(4)
    }

    fun tom3(v:View){
        play_music(5)
    }

    fun hihat(v:View){
        play_music(6)
    }

    fun snare(v:View){
        play_music(7)
    }

    fun bass(v:View){
        play_music(8)
    }


    fun play_music(num:Int){
        if (mSoundId[num] != null){
            mSoundPool.play(mSoundId[num] as Int, 1.0F,1.0F,0,0,1.0F)
        }
    }
}
