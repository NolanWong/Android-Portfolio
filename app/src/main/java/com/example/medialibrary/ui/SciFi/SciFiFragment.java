package com.example.medialibrary.ui.SciFi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.medialibrary.databinding.FragmentScifiBinding;


public class SciFiFragment extends Fragment {

    private FragmentScifiBinding binding;
    // 1. Declare your ViewModel
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentScifiBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.generateBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView firstTXT = binding.first;
                String first = String.valueOf(firstTXT.getText());
                TextView lastTXT = binding.last;
                String last = String.valueOf(lastTXT.getText());
                TextView cityTXT = binding.city;
                String city = String.valueOf(cityTXT.getText());
                TextView schoolTXT = binding.school;
                String school = String.valueOf(schoolTXT.getText());
                TextView petAppTXT = binding.petApp;
                String petApp = String.valueOf(petAppTXT.getText());
                TextView sibMythTXT = binding.sibMyth;
                String sibMyth = String.valueOf(sibMythTXT.getText());
                String SciFiFirstName = first.substring(0, 2) + last.substring(last.length() - 2);
                String SciFiLastName = city.substring(0, 4) + school.substring(school.length() - 3);
                String SciFiOrigin = petApp.substring(0, 3) + sibMyth.substring(sibMyth.length() - 2);
                TextView output = binding.output;
                String text = "Howdy " + SciFiFirstName + " " + SciFiLastName + " from " + SciFiOrigin + "!";
                output.setText(text);
            }
        });
        return root;
    }
}
