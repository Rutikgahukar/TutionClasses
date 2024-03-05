package com.example.abhayclasses;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class CurrentAffairsFragment extends Fragment {

    public CurrentAffairsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_current_affairs, container, false);
        LinearLayout shipCurrentAphaireLayout = rootView.findViewById(R.id.ShipCurrentAphaire);
        shipCurrentAphaireLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFullScreenActivity();
            }
        });
        return rootView;
    }

    private void openFullScreenActivity() {
        Intent intent = new Intent(getActivity(), FullScreenActivity.class);
        startActivity(intent);
    }

}
