package org.xyafu.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import org.xyafu.app.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Page_Me extends Fragment {
    private Button button;
    private EditText name,number;
    private Bundle bundle;
    private String srt01,srt02;

    public Page_Me() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bundle = this.getArguments();
        srt01 = bundle.getString("stu_name");
        srt02 = bundle.getString("stu_number");
        View view=inflater.inflate(R.layout.fragment_page__me, container, false);
        button=view.findViewById(R.id.btn_in);
        name=view.findViewById(R.id.name);
        number=view.findViewById(R.id.number);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(srt01);
               name.setText(srt01);
               number.setText(srt02);
            }
        });

        return view;
    }

}
