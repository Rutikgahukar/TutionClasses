package com.example.abhayclasses;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class StudentDetailsFragment extends Fragment {

    public StudentDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_details, container, false);

        LinearLayout leatureLayout = view.findViewById(R.id.leatureLayout);
        LinearLayout testLayout = view.findViewById(R.id.TestLayout);
        LinearLayout resultLayout = view.findViewById(R.id.ResultLayout);
        LinearLayout NoticeLayout = view.findViewById(R.id.NoticeLayout);
        LinearLayout AttendanceLayout = view.findViewById(R.id.AttendanceLayout);
        LinearLayout SampleLayout = view.findViewById(R.id.SampleLayout);
        LinearLayout HomeLayout = view.findViewById(R.id.HomeLayout);
        LinearLayout FeesLayout = view.findViewById(R.id.FeesLayout);

        leatureLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Message_0.class);
                startActivity(intent);
            }
        });

        testLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Message_1.class);
                startActivity(intent);
            }
        });


        resultLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Message_2.class);
                startActivity(intent);
            }
        });
        NoticeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Message_3.class);
                startActivity(intent);
            }
        });
        AttendanceLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Message_4.class);
                startActivity(intent);
            }
        });
        SampleLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Message_5.class);
                startActivity(intent);
            }
        });
        HomeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Message_6.class);
                startActivity(intent);
            }
        });
        FeesLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Message_7.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
