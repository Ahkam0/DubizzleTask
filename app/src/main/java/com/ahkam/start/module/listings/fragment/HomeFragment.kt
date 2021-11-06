package com.ahkam.start.module.listings.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahkam.start.ItemAdapter
import com.ahkam.start.R
import com.ahkam.start.databinding.FragmentHomeBinding
import com.ahkam.start.presentation.di.Injector
import com.ahkam.start.presentation.item.ItemViewModel
import com.ahkam.start.presentation.item.ItemViewModelFactory
import com.synnapps.carouselview.ImageListener
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject


class HomeFragment : Fragment() {
    @Inject
    lateinit var factory: ItemViewModelFactory
    private lateinit var binding: FragmentHomeBinding
    private lateinit var itemViewModel: ItemViewModel
    private lateinit var adapter: ItemAdapter

    var slideImages = intArrayOf(
            R.drawable.slideone,
            R.drawable.slidetwo,
            R.drawable.slidethree,
    )


    var imageListener =
        ImageListener { position, imageView -> imageView.setImageResource(slideImages.get(position)) }


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSliders()
        fetchData()
    }

    private fun fetchData() {
        (activity?.application as Injector).createItemSubComponent().inject(this)
        itemViewModel = ViewModelProvider(this,factory).get(ItemViewModel::class.java)
        initRecyclerView()
    }

    private fun setSliders() {
        MainScope().launch {
            binding.carouselView.setImageListener(imageListener)
            binding.carouselView.pageCount = slideImages.size}


    }

    private fun initRecyclerView(){
        binding.itemList.layoutManager = LinearLayoutManager(activity)
        adapter = ItemAdapter()
        binding.itemList.adapter = adapter
        showItem()

    }

    private fun showItem(){
        val responseLiveData = itemViewModel.getItems()
        responseLiveData.observe(viewLifecycleOwner, Observer {
            if(it!=null)
            {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            }
        })
    }
}