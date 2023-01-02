package com.example.sushi.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.sushi.R
import com.example.sushi.databinding.HomeFragmentBinding
import com.example.sushi.model.CardRoomData
import com.example.sushi.ui.Adapter.RoomCardAdaptor
import com.example.sushi.ui.custom_view.CreateRoomDialog

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: HomeFragmentBinding
    private val adaptor = RoomCardAdaptor()

    private var data: MutableList<CardRoomData> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = HomeFragmentBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        binding.cardRoomRecycler.adapter = adaptor
        val cardData = CardRoomData(roomId = 1, roomName = "ห้อง 1")
        data.add(cardData)
        adaptor.submitList(data)

        binding.buttonCreateRoom.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_pokerRoomFragment)
        }

        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        return binding.root
    }
}