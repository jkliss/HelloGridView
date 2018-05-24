package com.example.julius.hellogridview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.concurrent.Semaphore;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private Semaphore semaphore = new Semaphore(1);

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            //imageView.setPadding(4, 4, 4, 4);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }


    public Integer[] createGO(int dims){
        Boolean offset = true;
        if(dims % 2 == 0){
            offset = false;
        }
        Integer bsize = dims*dims;
        Integer[] checkboard = new Integer[bsize];
        int change_sep = 0;
        for(int i = 0; i < bsize; i++){
            if(i % dims == 0 && !offset){
                if(change_sep == 0){
                    change_sep = 1;
                } else {
                    change_sep = 0;
                }
            }
            if((i+change_sep) % 2 == 0){
                checkboard[i] = R.drawable.white_box;
            } else {
                checkboard[i] = R.drawable.white_box;
            }
        }
        return checkboard;
    }

    void changeColor(int ID, int current_color){
        if(current_color == 2) {
            mThumbIds[ID] = R.drawable.red_box;
        } else if(current_color == 1){
            mThumbIds[ID] = R.drawable.blue_box;
        } else {
            mThumbIds[ID] = R.drawable.white_box;
        }
    }

    // references to our images
    public Integer[] mThumbIds = createGO(20);

    public Semaphore getSemaphore() {
        return semaphore;
    }
}