package com.example.medialibrary.ui.MadLib;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer; // Import this
import androidx.lifecycle.ViewModelProvider; // Import this

import com.example.medialibrary.databinding.FragmentMadlibBinding;

import java.util.ArrayList; // Import this


public class MadLibFragment extends Fragment {

    private FragmentMadlibBinding binding;
    // 1. Declare your ViewModel
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentMadlibBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button sc2=binding.screen2BTN;
        sc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.first.setVisibility(View.GONE);
                binding.second.setVisibility(View.VISIBLE);
            }
        });
        TextView escape=binding.park;
        TextView experiment=binding.magic;
        TextView talent=binding.space;
        binding.readyBTN.setOnClickListener(v -> {
            //Grabs text from inputs and resets them for later
            EditText nameTXT = binding.name;
            String name=String.valueOf(nameTXT.getText());
            nameTXT.setText("");
            EditText placeTXT = binding.place;
            String place=String.valueOf(placeTXT.getText());
            placeTXT.setText("");
            EditText pluralNounTXT = binding.pluralNoun;
            String plural=String.valueOf(pluralNounTXT.getText());
            pluralNounTXT.setText("");
            EditText adjTXT = binding.adj;
            String adj=String.valueOf(adjTXT.getText());
            adjTXT.setText("");
            EditText verbTXT = binding.verb;
            String verb=String.valueOf(verbTXT.getText());
            verbTXT.setText("");
            EditText animalTXT = binding.animal;
            String animal=String.valueOf(animalTXT.getText());
            animalTXT.setText("");
            EditText sillyTXT = binding.silly;
            String silly=String.valueOf(sillyTXT.getText());
            sillyTXT.setText("");
            EditText objectTXT = binding.object;
            String object=String.valueOf(objectTXT.getText());
            objectTXT.setText("");
            binding.second.setVisibility(View.GONE);
            binding.third.setVisibility(View.VISIBLE);
            //Sets the text of all the madlibs
            escape.setText(String.format("One day, %s went to %s to see the famous %s exhibit. Everything seemed %s at first, but then one of the %s started to %s uncontrollably!\n\nOut of nowhere, a wild %s appeared, wearing a giant %s on its head.\n“Grab the %s!” shouted %s, as chaos erupted around them.",name, place, plural, adj, plural, verb, animal, silly, object, name));
            experiment.setText(String.format("In the secret lab under %s, Dr. %s was experimenting with %s. After adding a %s chemical to the mix, the entire beaker began to %s!\n\nSuddenly, the test subject—a genetically enhanced %s—burst out of its cage and knocked over a %s.\n“Not the %s again!” cried the doctor, slipping on the spilled goo.", place, name, plural,adj,verb,animal,object,silly));
            talent.setText(String.format("It was the big night at %s, and %s was ready to perform with their trained %s. The act was meant to be %s, involving a synchronized %s routine.\n\nBut before the show could begin, a mischievous %s ran on stage carrying a %s. In the confusion, someone tripped over a %s, and the whole performance turned into a comedy sketch.",place,name,plural,adj,verb,animal,silly,object));
        });
        binding.genBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Grabs choice and displays correct option along with the back button
                EditText choiceTXT=binding.choice;
                String choice=String.valueOf(choiceTXT.getText());
                if(choice.equals("1")){
                    binding.third.setVisibility(View.GONE);
                    escape.setVisibility(View.VISIBLE);
                    binding.backBTN.setVisibility(View.VISIBLE);
                } else if(choice.equals("2")){
                    binding.third.setVisibility(View.GONE);
                    experiment.setVisibility(View.VISIBLE);
                    binding.backBTN.setVisibility(View.VISIBLE);
                } else if(choice.equals("3")){
                    binding.third.setVisibility(View.GONE);
                    talent.setVisibility(View.VISIBLE);
                    binding.backBTN.setVisibility(View.VISIBLE);
                }
                choiceTXT.setText("");
            }
        });
        binding.backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //reset
                binding.first.setVisibility(View.VISIBLE);
                escape.setVisibility(View.GONE);
                experiment.setVisibility(View.GONE);
                talent.setVisibility(View.GONE);
                binding.backBTN.setVisibility(View.GONE);
            }
        });

        // 3. Get the TextView from the binding
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
