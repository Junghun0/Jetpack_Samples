package junghoon.jetpack.sample.data_transfer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.*
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment(R.layout.fragment_first) {
//onCreateView 메서드 오버라이드 안하고 위처럼 생성자로 뷰 넘겨줘도됨


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {

            //데이터를 보낼때
            setFragmentResult("firstToSecond", bundleOf("data" to "전달하는 데이터 "))

            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        
    }

}