package junghoon.jetpack.sample.hilt_di_sample.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import junghoon.jetpack.sample.hilt_di_sample.R
import junghoon.jetpack.sample.hilt_di_sample.data.MyRepository
import junghoon.jetpack.sample.hilt_di_sample.di.qualifier.ActivityHash
import junghoon.jetpack.sample.hilt_di_sample.di.qualifier.AppHash
import junghoon.jetpack.sample.hilt_di_sample.ui.second.SecondActivity
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {
    private val activityViewModel by activityViewModels<MainViewModel>()
    private val viewModel by viewModels<MainViewModel>()

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

        Log.d("MainFragment","repository hashcode ${repository.hashCode()}")
        Log.d("MainFragment","@app hashcode ${applicationHash.hashCode()}")
        Log.d("MainFragment","@activity hashcode ${activityHash.hashCode()}")
        Log.d("MainFragment","viewModel hashcode ${viewModel.getRepositoryHash()}")
        Log.d("MainFragment","activityViewModel hashcode ${activityViewModel.getRepositoryHash()}")


        button_activity.setOnClickListener {
            val intent = Intent(requireContext(), SecondActivity::class.java)
            startActivity(intent)
        }

        button_fragment.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_secondFragment)
        }
    }
}