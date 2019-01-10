package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer media;

    private MediaPlayer.OnCompletionListener ocl = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList();
        words.add(new Word("one", "undo", R.drawable.number_one,R.raw.number_one));
        words.add(new Word("onde", "unghbo", R.drawable.number_two,R.raw.number_three));
        words.add(new Word("onse", "unco", R.drawable.number_three,R.raw.number_three));
        words.add(new Word("ofne", "unno", R.drawable.number_four,R.raw.number_four));
        words.add(new Word("ovne", "uvno", R.drawable.number_five,R.raw.number_five));
        words.add(new Word("onse", "udno", R.drawable.number_six,R.raw.number_six));
        words.add(new Word("onne", "uhjno", R.drawable.number_seven,R.raw.number_seven));
        words.add(new Word("oane", "ukno", R.drawable.number_eight,R.raw.number_eight));
        words.add(new Word("ohne", "unpo", R.drawable.number_nine,R.raw.number_nine));
        words.add(new Word("ojne", "ulno", R.drawable.number_ten,R.raw.number_ten));


        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = words.get(position);
                releaseMediaPlayer();
                media = MediaPlayer.create(NumbersActivity.this, word.getAudioresourceid());
                media.start();

                media.setOnCompletionListener(ocl);
            }
        });



    }
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer(){
        if (media != null){
            media.release();
            media = null;
        }
    }
}
