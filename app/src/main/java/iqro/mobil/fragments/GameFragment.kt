package iqro.mobil.fragments

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import iqro.mobil.fragments.databinding.FragmentGameBinding

class GameFragment : Fragment() {
private var nullableBinding:FragmentGameBinding?=null
    private val binding get() = nullableBinding!!
    private var player = "p1"
    private lateinit var inter:ButtonClicked
    override fun onAttach(context: Context) {
        super.onAttach(context)
        inter=activity as MainActivity
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        nullableBinding= FragmentGameBinding.inflate(layoutInflater,container,false)
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textView3.startAnimation(AnimationUtils.loadAnimation(context,R.anim.scale))
        binding.v1.startAnimation(AnimationUtils.loadAnimation(context,R.anim.scale_500))
        binding.v2.startAnimation(AnimationUtils.loadAnimation(context,R.anim.scale_500))
        binding.v3.startAnimation(AnimationUtils.loadAnimation(context,R.anim.scale_500))
        binding.v4.startAnimation(AnimationUtils.loadAnimation(context,R.anim.scale_500))
        binding.v5.startAnimation(AnimationUtils.loadAnimation(context,R.anim.scale_500))
        binding.v6.startAnimation(AnimationUtils.loadAnimation(context,R.anim.scale_500))
        binding.v7.startAnimation(AnimationUtils.loadAnimation(context,R.anim.scale_500))
        binding.v8.startAnimation(AnimationUtils.loadAnimation(context,R.anim.scale_500))
        binding.v9.startAnimation(AnimationUtils.loadAnimation(context,R.anim.scale_500))
        binding.textView2.startAnimation(AnimationUtils.loadAnimation(context,R.anim.trans_bottom_to_top))

        binding.v1.setOnClickListener {
            binding.v1.startAnimation(AnimationUtils.loadAnimation(context,R.anim.scale))
            buttonClick(binding.v1)
            win()
        }
        binding.v2.setOnClickListener {
            binding.v2.startAnimation(AnimationUtils.loadAnimation(context,R.anim.scale))
            buttonClick(binding.v2)
            win()
        }
        binding.v3.setOnClickListener {
            binding.v3.startAnimation(AnimationUtils.loadAnimation(context,R.anim.scale))
            buttonClick(binding.v3)
            win()
        }
        binding.v4.setOnClickListener {
            binding.v4.startAnimation(AnimationUtils.loadAnimation(context,R.anim.scale))
            buttonClick(binding.v4)
            win()
        }
        binding.v5.setOnClickListener {
            binding.v5.startAnimation(AnimationUtils.loadAnimation(context,R.anim.scale))
            buttonClick(binding.v5)
            win()
        }
        binding.v6.setOnClickListener {
            binding.v6.startAnimation(AnimationUtils.loadAnimation(context,R.anim.scale))
            buttonClick(binding.v6)
            win()
        }
        binding.v7.setOnClickListener {
            binding.v7.startAnimation(AnimationUtils.loadAnimation(context,R.anim.scale))
            buttonClick(binding.v7)
            win()
        }
        binding.v8.setOnClickListener {
            binding.v8.startAnimation(AnimationUtils.loadAnimation(context,R.anim.scale))
            buttonClick(binding.v8)
            win()
        }
        binding.v9.setOnClickListener {
            binding.v9.startAnimation(AnimationUtils.loadAnimation(context,R.anim.scale))
            buttonClick(binding.v9)
            win()
        }
    }

    private fun buttonClick(btn: Button){
        if (btn.text == "") {
            if (player == "p1") {
                btn.text = "X"
                btn.setBackgroundResource(R.drawable.x_box)
                btn.setTextColor(Color.rgb(115, 92, 0))
                player="p2"
            } else {
                btn.text = "O"
                btn.setTextColor(Color.rgb(177, 41, 60))
                btn.setBackgroundResource(R.drawable.o_box)
                player="p1"
            }
        }
    }

    fun win(){
        val v1=binding.v1.text
        val v2=binding.v2.text
        val v3=binding.v3.text
        val v4=binding.v4.text
        val v5=binding.v5.text
        val v6=binding.v6.text
        val v7=binding.v7.text
        val v8=binding.v8.text
        val v9=binding.v9.text

        // X ga tekshirish
        if ((v1=="X"&&v2=="X"&&v3=="X")||
            (v4=="X"&&v5=="X"&&v6=="X")||
            (v7=="X"&&v8=="X"&&v9=="X")||
            (v1=="X"&&v4=="X"&&v7=="X")||
            (v2=="X"&&v5=="X"&&v8=="X")||
            (v3=="X"&&v6=="X"&&v9=="X")||
            (v1=="X"&&v5=="X"&&v9=="X")||
            (v3=="X"&&v5=="X"&&v7=="X")
        ){
            printWinner("X won the Game")
            inter.win("X won the Game")
        }

//  O ga tekshirish
        else if ((v1=="O"&&v2=="O"&&v3=="O")||
            (v4=="O"&&v5=="O"&&v6=="O")||
            (v7=="O"&&v8=="O"&&v9=="O")||
            (v1=="O"&&v4=="O"&&v7=="O")||
            (v2=="O"&&v5=="O"&&v8=="O")||
            (v3=="O"&&v6=="O"&&v9=="O")||
            (v1=="O"&&v5=="O"&&v9=="O")||
            (v3=="O"&&v5=="O"&&v7=="O")
        ){
            printWinner("O won the Game")
            inter.win("O won the Game")
        }
        else{
            if (v1!=""&&v2!=""&&v3!=""&&v4!=""&&v5!=""&&v6!=""&&v7!=""&&v8!=""&&v9!=""){
                printWinner("Tie Game")
                inter.draw()
            }
        }

    }
    private fun printWinner(message:String){
        binding.textView3.text=message
    }


}