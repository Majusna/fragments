package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int colorOfActivity;



    public WordAdapter(@NonNull Activity context, ArrayList<Word> words, int colorId) {

        super(context, 0, words);

        colorOfActivity = colorId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {



        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        final Word currentWord = getItem(position);

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslate());

        TextView miwoktextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwoktextView.setText(currentWord.getMiwokTranslate());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);

        if (currentWord.hasImage()){
            imageView.setImageResource(currentWord.getImageResourceId());

            imageView.setVisibility(View.VISIBLE);
            }else{
            imageView.setVisibility(View.GONE);
            }

            LinearLayout layout = (LinearLayout) listItemView.findViewById(R.id.layout_background);
            layout.setBackgroundResource(colorOfActivity);



           /* listItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(currentWord.hasAudio()){
                        int audio =  currentWord.getAudioresourceid();
                        MediaPlayer m = MediaPlayer.create (getContext(), audio);
                        m.start();
                    }

                }
            }); */


        return listItemView;

    }
}
