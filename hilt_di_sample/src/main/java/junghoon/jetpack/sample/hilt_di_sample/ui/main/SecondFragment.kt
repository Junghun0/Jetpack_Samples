package junghoon.jetpack.sample.hilt_di_sample.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import junghoon.jetpack.sample.hilt_di_sample.R
import junghoon.jetpack.sample.hilt_di_sample.data.MyRepository
import junghoon.jetpack.sample.hilt_di_sample.di.qualifier.ActivityHash
import junghoon.jetpack.sample.hilt_di_sample.di.qualifier.AppHash
import kotlinx.android.synthetic.main.fragment_second.*
import javax.inject.Inject

@AndroidEntryPoint
class SecondFragment : Fragment(R.layout.fragment_second) {

    @Inject
    lateinit var repository: MyRepository

    @AppHash
    @Inject
    lateinit var applicationHash: String

    @ActivityHash
    @Inject
    lateinit var activityHash: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("SecondFragment","repository hashcode ${repository.hashCode()}")
        Log.d("SecondFragment","@app hashcode ${applicationHash.hashCode()}")
        Log.d("SecondFragment","@activity hashcode ${activityHash.hashCode()}")

        button.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_mainFragment)
        }
    }
}