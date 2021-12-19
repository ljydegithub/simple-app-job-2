package org.xyafu.app.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import org.xyafu.app.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageHome extends Fragment {

    public PageHome() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_page_home,null );
        return view;
    }

}
