package swu.lwh.newtest

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FirstFragment:Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("SecondFragment","onAttach")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val StrArgument= arguments?.getString("key_String")
        println("key_string:${StrArgument}")
        val textView=TextView(context)
        textView.text="wechat:${StrArgument}"
        textView.gravity=Gravity.CENTER
        Log.e("SecondFragment","onCreateView")
        return textView
    }

    override fun onStart() {
        Log.e("SecondFragment","onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.e("SecondFragment","onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.e("SecondFragment","onPause")
        super.onPause()
    }


}