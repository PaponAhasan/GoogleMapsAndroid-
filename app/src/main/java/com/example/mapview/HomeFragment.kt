package com.example.mapview

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        val userMaps = generateSampleData()

        binding.rvMaps.layoutManager = LinearLayoutManager(activity)
        binding.rvMaps.adapter = MapsAdapter(userMaps)
    }

    /* https://gist.github.com/rpandey1234/19d9be3f6436080763e2eaf4adbf0b16*/
    private fun generateSampleData(): List<UserMaps> {
        return listOf(
            UserMaps(
                "Memories from University",
                listOf(
                    Place("Brander Hall", "Best dorm at Stanford", 37.426, -122.163),
                    Place(
                        "Gates CS building", "Many long nights in this basement", 37.430, -122.173
                    ),
                    Place("Pink-berry", "First date with my wife", 37.444, -122.170)
                )
            ),
            UserMaps(
                "January vacation planning!",
                listOf(
                    Place("Tokyo", "Overnight layover", 35.67, 139.65),
                    Place("Ranchi", "Family visit + wedding!", 23.34, 85.31),
                    Place("Singapore", "Inspired by \"Crazy Rich Asians\"", 1.35, 103.82)
                )
            ),
            UserMaps("Singapore travel itinerary",
                listOf(
                    Place("Gardens by the Bay", "Amazing urban nature park", 1.282, 103.864),
                    Place("Jurong Bird Park", "Family-friendly park with many varieties of birds", 1.319, 103.706),
                    Place("Sentosa", "Island resort with panoramic views", 1.249, 103.830),
                    Place("Botanic Gardens", "One of the world's greatest tropical gardens", 1.3138, 103.8159)
                )
            ),
            UserMaps("My favorite places in the Midwest",
                listOf(
                    Place("Chicago", "Urban center of the midwest, the \"Windy City\"", 41.878, -87.630),
                    Place("Rochester, Michigan", "The best of Detroit suburbia", 42.681, -83.134),
                    Place("Mackinaw City", "The entrance into the Upper Peninsula", 45.777, -84.727),
                    Place("Michigan State University", "Home to the Spartans", 42.701, -84.482),
                    Place("University of Michigan", "Home to the Wolverines", 42.278, -83.738)
                )
            ),
            UserMaps("Restaurants to try",
                listOf(
                    Place("Champ's Diner", "Retro diner in Brooklyn", 40.709, -73.941),
                    Place("Althea", "Chicago upscale dining with an amazing view", 41.895, -87.625),
                    Place("Shizen", "Elegant sushi in San Francisco", 37.768, -122.422),
                    Place("Citizen Eatery", "Bright cafe in Austin with a pink rabbit", 30.322, -97.739),
                    Place("Kati Thai", "Authentic Portland Thai food, served with love", 45.505, -122.635)
                )
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}