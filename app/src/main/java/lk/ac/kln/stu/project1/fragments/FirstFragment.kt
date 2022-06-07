package lk.ac.kln.stu.project1.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import lk.ac.kln.stu.project1.R
import lk.ac.kln.stu.project1.adapters.CarAdapter
import lk.ac.kln.stu.project1.api.RetrofitApi
import lk.ac.kln.stu.project1.database.car.CarResponseData
import lk.ac.kln.stu.project1.databinding.FragmentFirstBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    companion object {
        val TAG = FirstFragment::class.java.simpleName
    }

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getCarsFromApi()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getCarsFromApi() {
        val call = RetrofitApi.retofitService.getCars()
        call.enqueue(object: Callback<CarResponseData> {
            override fun onResponse(
                call: Call<CarResponseData>,
                response: Response<CarResponseData>
            ) {
                val cars = response.body()?.cars
                binding.recyclerviewCars.adapter = cars?.let { CarAdapter(it) }
            }

            override fun onFailure(call: Call<CarResponseData>, t: Throwable) {
                Log.e(TAG, "Error: " + t.message)
            }

        })
    }
}