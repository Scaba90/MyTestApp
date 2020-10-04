package com.example.mytestapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {
        TextView showCountTextView;

    private void countMe(View view){
        // Get the value of the text veiw
        String countString = showCountTextView.getText().toString();
        //Convert the value to a number and increment it
        Integer count = Integer.parseInt(countString);
        count++;
        //Display the new value in the text view
        showCountTextView.setText(count.toString());}

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState

    ) {
        View fragmetFirstLayout = inflater.inflate(R.layout.fragment_first, container, false);

        // Get the count text view
        showCountTextView = fragmetFirstLayout.findViewById(R.id.textview_first);
        return fragmetFirstLayout;
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.random_button).setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view){
               int currentCount = Integer.parseInt(showCountTextView.getText().toString());
               FirstFragmentDirections.ActionFirstFragmentToSecondFragment action= FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount);
               NavHostFragment.findNavController(FirstFragment.this).navigate(action);
           }
        });
            int currentCount =Integer.parseInt(showCountTextView.getText().toString());
        view.findViewById(R.id.toast_button).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
               /* NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);*/
                Toast myToast = Toast.makeText(getActivity(), "Hello Toast", Toast.LENGTH_SHORT);
                myToast.show();
            }

            });
            view.findViewById(R.id.count_button_text).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    countMe(view);
                }
            });


        };
    }
