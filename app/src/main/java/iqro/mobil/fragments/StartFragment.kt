package iqro.mobil.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import iqro.mobil.fragments.databinding.FragmentGameBinding
import iqro.mobil.fragments.databinding.FragmentStartBinding

class StartFragment : Fragment() {
    private lateinit var nullbleBinding:FragmentStartBinding
    private val binding get() = nullbleBinding!!
    private lateinit var inter: ButtonClicked
    override fun onAttach(context: Context) {
        super.onAttach(context)
        inter = activity as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        nullbleBinding=FragmentStartBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.oBtn.startAnimation(AnimationUtils.loadAnimation(context,R.anim.trans_bottom_to_top))
        binding.xBtn.startAnimation(AnimationUtils.loadAnimation(context,R.anim.trans_bottom_to_top))
        binding.textView4.startAnimation(AnimationUtils.loadAnimation(context,R.anim.scale_500))
        binding.imageView.startAnimation(AnimationUtils.loadAnimation(context,R.anim.scale_500))

        binding.oBtn.setOnClickListener {
            inter.oButtonClick()
        }
        binding.xBtn.setOnClickListener {
            inter.xButtonClick()
        }
    }

}