package com.test.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class MyFragmentDetail extends Fragment {

    private String text = "";
    private static final String KEY_CONTENT = "MyFragmentDetail:Content";

    public MyFragmentDetail(String text) {
        this.text = text;
    }

    public MyFragmentDetail() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment_detail, null);
        ((TextView) view.findViewById(R.id.textView1)).setText(text);

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_CONTENT, text);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ((savedInstanceState != null)
                && savedInstanceState.containsKey(KEY_CONTENT)) {
            text = savedInstanceState.getString(KEY_CONTENT);
        }
    }
}
