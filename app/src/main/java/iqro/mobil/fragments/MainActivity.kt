package iqro.mobil.fragments

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toDrawable
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import iqro.mobil.fragments.R.drawable.baseline_accessibility_new_24
import iqro.mobil.fragments.R.drawable.baseline_adb_24
import iqro.mobil.fragments.R.drawable.ic_launcher_foreground
import iqro.mobil.fragments.R.drawable.rectangle_style
import iqro.mobil.fragments.R.drawable.style_1
import iqro.mobil.fragments.databinding.ActivityMainBinding
import iqro.mobil.fragments.databinding.DrawBinding
import iqro.mobil.fragments.databinding.WinBinding

class MainActivity : AppCompatActivity(), ButtonClicked {
    private lateinit var binding: ActivityMainBinding
    private var player = "p1"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val startFragment = StartFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container, startFragment).commit()

        binding.view.startAnimation(AnimationUtils.loadAnimation(this,R.anim.trans_top_to_bottom))
        binding.textView.startAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_500))

    }

    override fun oButtonClick() {
        val gameFragment = GameFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container, gameFragment).commit()
    }

    override fun xButtonClick() {
        val gameFragment = GameFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container, gameFragment).commit()
    }

    override fun win(text: String) {
        val winBinding = WinBinding.inflate(layoutInflater)
        val dialog = AlertDialog.Builder(this)
            .setView(winBinding.root)
            .setCancelable(false)
            .create()

        winBinding.cup.startAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_500))
        winBinding.winTv.startAnimation(AnimationUtils.loadAnimation(this,R.anim.scale))
        winBinding.textView6.startAnimation(AnimationUtils.loadAnimation(this,R.anim.scale))
        winBinding.restartBtn.startAnimation(AnimationUtils.loadAnimation(this,R.anim.trans_bottom_to_top))

        winBinding.winTv.text = text
        winBinding.restartBtn.setOnClickListener {
            val gameFragment = GameFragment()
            supportFragmentManager.beginTransaction().replace(R.id.container, gameFragment).commit()
            dialog.dismiss()
        }
        dialog.show()

    }

    override fun draw() {
val drawBinding=DrawBinding.inflate(layoutInflater)
        val dialog=AlertDialog.Builder(this)
            .setView(drawBinding.root)
            .setCancelable(false)
            .create()

drawBinding.image.startAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_500))
        drawBinding.text.startAnimation(AnimationUtils.loadAnimation(this,R.anim.scale))
        drawBinding.text2.startAnimation(AnimationUtils.loadAnimation(this,R.anim.scale))
        drawBinding.replayBtn.startAnimation(AnimationUtils.loadAnimation(this,R.anim.trans_bottom_to_top))

        drawBinding.replayBtn.setOnClickListener {
            val gameFragment = GameFragment()
            supportFragmentManager.beginTransaction().replace(R.id.container, gameFragment).commit()
            dialog.dismiss()
        }
        dialog.show()
    }


}