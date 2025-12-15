package com.example.medialibrary.ui.GAN;

import static android.view.View.VISIBLE;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.medialibrary.databinding.FragmentGanBinding;

import java.util.Random;

public class GANFragment extends Fragment {

    private FragmentGanBinding binding;
    // 1. Declare your ViewModel
    int guesses = 10;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentGanBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final TextView textView=binding.textView;
        // 1. Create a Random object (ideally once per application)
        Random rand = new Random();

        // 2. Generate a random integer:
        //    a. Full range (including negative numbers):
        int hidden = rand.nextInt(1,100);
        //had to do this because Android
        //code here
        final TextView GuessTXT=binding.GuessTXT;
        binding.submitBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            String inputString = binding.inputText.getText().toString();
                int finalValue = Integer.parseInt(inputString); // Convert the string to an int
                // Use the finalValue here (e.g., for calculations, setting another TextView)
                    if (finalValue<hidden){
                        textView.setText("Too low");
                    }
                    else if(finalValue>hidden){
                        textView.setText("Too high");
                    }
                    else{
                        textView.setText("Correct!!");
                        binding.correct.setVisibility(VISIBLE);
                    }
                    //had to do this because Android

        }});


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}