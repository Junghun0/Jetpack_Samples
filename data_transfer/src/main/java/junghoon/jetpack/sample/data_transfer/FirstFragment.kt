package junghoon.jetpack.sample.data_transfer

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import androidx.fragment.app.*
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment(R.layout.fragment_first) {
//onCreateView 메서드 오버라이드 안하고 위처럼 생성자로 뷰 넘겨줘도됨

    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) {
        imageView.setImageURI(it)
    }

    private val getStartActivityForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { activityResult ->
        activityResult.data?.let { intent ->
            intent.extras?.let { bundle ->
                Log.d(
                    "FirstFragment",
                    "result : ${
                        bundle.getString("data", "world")
                    }"
                )
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {

//            //데이터를 보낼때
//            setFragmentResult("firstToSecond", bundleOf("data" to "전달하는 데이터 "))
//
//            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)

            getContent.launch("image/*")
            Intent(requireContext(), ResultActivity::class.java).apply {
                getStartActivityForResult.launch(this)
            }

        }


    }

}