package com.example.mapview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mapview.databinding.FragmentHomeBinding
import com.example.mapview.models.Place
import com.example.mapview.models.UserMaps

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val TAG = "HomeFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userMaps =  generateSampleData()

        binding.rvMaps.layoutManager = LinearLayoutManager(activity)
        binding.rvMaps.adapter = MapsAdapter(userMaps, object :MapsAdapter.OnCLickListener{
            override fun onItemClick(position: Int) {
                Log.e(TAG, "onItemClick $position")
                Navigation.findNavController(view).navigate(R.id.displayMapFragment)
            }
        })
    }

    /* https://gist.github.com/rpandey1234/19d9be3f6436080763e2eaf4adbf0b16*/
    private fun generateSampleData(): List<UserMaps> {
        return listOf(
            UserMaps(
                "Memories from University",
                listOf(
                    Place("Branner Hall", "Best dorm at Stanford", 37.426, -122.163),
                    Place("Gates CS building", "Many long nights in this basement", 37.430, -122.173),
                    Place("Pinkberry", "First date with my wife", 37.444, -122.170)
                )
            ),
            UserMaps("January vacation planning!",
                listOf(
                    Place("Tokyo", "Overnight layover", 35.67, 139.65),
                    Place("Ranchi", "Family visit + wedding!", 23.34, 85.31),
                    Place("Singapore", "Inspired by \"Crazy Rich Asians\"", 1.35, 103.82)
                )
            ),
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}