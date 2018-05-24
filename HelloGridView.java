package com.example.julius.hellogridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;

import java.util.concurrent.Semaphore;

public class HelloGridView extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
        final int[] current_color = {0};
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                final ImageAdapter imageAdapter = (ImageAdapter) parent.getAdapter();
                //final Semaphore semaphore = imageAdapter.getSemaphore();
                imageAdapter.changeColor(position, current_color[0]);
                imageAdapter.notifyDataSetChanged();
            }
        });
        final ImageButton[] imageButton1 = {(ImageButton) findViewById(R.id.button1)};
        imageButton1[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_color[0] = 1;
            }
        });
        ImageButton imageButton2 = (ImageButton) findViewById(R.id.button2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_color[0] = 2;
            }
        });
        ImageButton imageButton3 = (ImageButton) findViewById(R.id.button3);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_color[0] = 0;
            }
        });
    }

}
