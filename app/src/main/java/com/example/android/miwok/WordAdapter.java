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

    int listItemColor = 0;

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

        Word word = getItem(position);

        TextView englishTextView = (TextView) view.findViewById(R.id.english_word);
        englishTextView.setText(word.getEnglishTranslation());

        TextView miwokTextView = (TextView) view.findViewById(R.id.miwok_word);
        miwokTextView.setText(word.getMiwokTranslation());

        ImageView icon = (ImageView) view.findViewById(R.id.imageView);
        if(word.getImageResourceId() != 0){
            icon.setImageResource(word.getImageResourceId());
        }else{
            icon.setVisibility(View.GONE);
        }
        view.setBackgroundColor(ContextCompat.getColor(getContext(), listItemColor));

        return view;
    }
}
