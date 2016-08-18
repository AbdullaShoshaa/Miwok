package com.example.android.miwok;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Shoshaa on 8/9/16.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int listItemColor = 0;
//    private MediaPlayer mMediaPlayer;
    private Word word;

    public WordAdapter(Context context, List<Word> objects, int color) {
        super(context, 0, objects);

        this.listItemColor = color;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        word = getItem(position);

        TextView englishTextView = (TextView) view.findViewById(R.id.english_word);
        englishTextView.setText(word.getEnglishTranslation());

        final TextView miwokTextView = (TextView) view.findViewById(R.id.miwok_word);
        miwokTextView.setText(word.getMiwokTranslation());

        ImageView icon = (ImageView) view.findViewById(R.id.imageView);
        if(word.getImageResourceId() != 0){
            icon.setImageResource(word.getImageResourceId());
        }else{
            icon.setVisibility(View.GONE);
        }
        view.setBackgroundColor(ContextCompat.getColor(getContext(), listItemColor));


//        ImageView playImageView = (ImageView) view.findViewById(R.id.play_imageview);
//        playImageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //setup audio player
//                mMediaPlayer = MediaPlayer.create(getContext(), word.getAudioResourceId());
//                mMediaPlayer.start();
//            }
//        });


        return view;
    }
}
