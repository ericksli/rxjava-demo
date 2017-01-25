package com.example.rxjavademo.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.rxjavademo.R;


public class InstructorViewHolder extends RecyclerView.ViewHolder {
    private TextView mText1;

    public InstructorViewHolder(View itemView) {
        super(itemView);
        mText1 = (TextView) itemView.findViewById(R.id.text1);
    }

    public void bind(String instructor) {
        mText1.setText(instructor);
    }
}
