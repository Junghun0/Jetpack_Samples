package junghoon.jetpack.sample.data_transfer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment(R.layout.fragment_second) {
//onCreateView 메서드 오버라이드 안하고 위처럼 생성자로 뷰 넘겨줘도됨

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button2.setOnClickListener {

            //데이터를 받을때
            setFragmentResultListener("firstToSecond") { _, bundle ->
                val data = bundle.getString("data","")
                Toast.makeText(requireContext(), data, Toast.LENGTH_SHORT).show()
            }

            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)

        }
    }
}