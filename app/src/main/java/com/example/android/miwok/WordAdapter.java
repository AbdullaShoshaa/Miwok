package com.example.android.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Shoshaa on 8/9/16.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Context context, List<Word> objects) {
        super(context, 0, objects);
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

        return view;
    }
}
