package swu.lwh.newtest

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.IllegalStateException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toggle_group.addOnButtonCheckedListener{group,checkedId,isChecked->
            val childCount=group.childCount
            var selectIndex=0
            for (index in 0 until childCount){
                val childAt=group.getChildAt(index) as MaterialButton
                if(childAt.id==checkedId){//选中
                    selectIndex=index
                    childAt.setTextColor(Color.GREEN)
                }else {
                    childAt.setTextColor(Color.BLACK)
                }
            }
            switchFragment(selectIndex)
        }
        toggle_group.check(R.id.tab1)//先选中一个按钮
    }
    private  var tab1Fragment:FirstFragment?=null
    private var tab2Fragment:FirstFragment?=null
    private var tab3Fragment:FirstFragment?=null
    private var tab4Fragment:FirstFragment?=null
    private var showFragment: Fragment?=null
    private fun switchFragment(selectIndex: Int) {
        val fragment=when(selectIndex){
            0->{
                if(tab1Fragment==null)
                {
                    tab1Fragment= FirstFragment()
                    val bundle=Bundle()
                    bundle.putString("key_String","微信界面")
                    tab1Fragment!!.setArguments(bundle)
                    //tab1Fragment!!.arguments==bundle
                }
                tab1Fragment
            }
            1->{
                if(tab2Fragment==null)
                {
                    tab2Fragment=FirstFragment()
                    val bundle=Bundle()
                    bundle.putString("key_String","通讯录界面")
                    tab2Fragment!!.arguments = bundle
                    //tab2Fragment!!.arguments==bundle//救命！这里怎么会写成判断啊！
                }
                tab2Fragment
            }
            2->{
                if(tab3Fragment==null)
                {
                    tab3Fragment=FirstFragment()
                    val bundle=Bundle()
                    bundle.putString("key_String","发现界面")
                    tab3Fragment!!.setArguments(bundle)
                    //tab3Fragment!!.arguments==bundle
                }
                tab3Fragment
            }
            3->{
                if(tab4Fragment==null)
                {
                    tab4Fragment=FirstFragment()
                    val bundle=Bundle()
                    bundle.putString("key_String","我的界面")
                    tab4Fragment!!.setArguments(bundle)
                    //tab3Fragment!!.arguments==bundle
                }
                tab4Fragment
            }
            else -> {throw  IllegalStateException("下标错误")}
        }?:return
        val ft=supportFragmentManager.beginTransaction()
        if(!fragment.isAdded)
        {
            ft.add(R.id.container,fragment)
        }

        if(showFragment!=null)
        {
            ft.hide(showFragment!!)
        }
        ft.show(fragment)
        ft.commitAllowingStateLoss()

        showFragment=fragment
    }
}