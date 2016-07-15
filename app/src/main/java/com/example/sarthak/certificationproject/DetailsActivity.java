package com.example.sarthak.certificationproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.sarthak.certificationproject.Model.MovieData;


public class DetailsActivity extends AppCompatActivity {

    TextView txtTitle,txtLang,txtReleaseDate,txtGenre1,txtGenre2,txtTime;
    RatingBar rb;
    MovieData movieData;
    ImageView ivPlay;


    void initViews(){
        txtTitle=(TextView)findViewById(R.id.textViewTitle);
        txtLang=(TextView)findViewById(R.id.textViewLang);
        txtReleaseDate=(TextView)findViewById(R.id.textViewDate);
        txtGenre1=(TextView)findViewById(R.id.textViewG1);
        txtGenre2=(TextView)findViewById(R.id.textViewG2);
        txtTime=(TextView)findViewById(R.id.textViewTime);

        rb=(RatingBar)findViewById(R.id.ratingBar);
        ivPlay=(ImageView)findViewById(R.id.ImageView);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initViews();

        Intent i=getIntent();
        movieData=(MovieData)i.getSerializableExtra("movie");

        updateViews();

    }

    private void updateViews(){
        txtTitle.setText(movieData.title);
        txtLang.setText(movieData.language);
        txtReleaseDate.setText(movieData.released);
        if(movieData.genres.length > 1) {
            txtGenre1.setText(movieData.genres[0]);
            txtGenre2.setText(movieData.genres[1]);
        }
        txtTime.setText(movieData.runtime + " mins");

        ivPlay.setImageResource(R.drawable.images);
        ivPlay.setOnTouchListener(videoTouchListener);

        rb.setRating((float) movieData.rating);
    }

    View.OnTouchListener videoTouchListener=new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            Intent youtubeIntent = new Intent(Intent.ACTION_VIEW);
            youtubeIntent.setData(Uri.parse(movieData.trailer));
            DetailsActivity.this.startActivity(youtubeIntent);
            return true;
        }
    };

}
