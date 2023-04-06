package edu.temple.viewpagerinclasssctivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private var numberofPages = 0

    val viewPager: ViewPager2 by lazy{
        findViewById(R.id.viewPager)
    }

    val button: Button by lazy{
        findViewById(R.id.button)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            numberofPages++
            viewPager.adapter?.notifyItemInserted(numberofPages -1)
            viewPager.setCurrentItem(numberofPages) //jumps to newly created page
        }

        viewPager.adapter = object: FragmentStateAdapter(this){
            override fun getItemCount() = numberofPages


            override fun createFragment(position: Int) = TextFragment.newInstance((position+1).toString())
        }


    }
}