package com.ahkam.start.module.listingdetails;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahkam.start.R;
import com.ahkam.start.databinding.FragmentDetailBinding;
import com.ahkam.start.presentation.item.ItemViewModel;
import com.ahkam.start.presentation.item.ItemViewModelFactory;
import com.bumptech.glide.Glide;

import javax.inject.Inject;


public class DetailFragment extends Fragment {


    FragmentDetailBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false);


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getIntentData();
        setListeners();

    }

    private void setListeners() {
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).popBackStack();
            }
        });
    }

    private void getIntentData() {
        String name = DetailFragmentArgs.fromBundle(getArguments()).getName();
        String price = DetailFragmentArgs.fromBundle(getArguments()).getPrice();
        String image = DetailFragmentArgs.fromBundle(getArguments()).getImage();

        binding.ItemName.setText(name);
        binding.ItemPrice.setText(price);

        Glide.with(binding.ItemImage.getContext()).load(image).into(binding.ItemImage);


    }

}