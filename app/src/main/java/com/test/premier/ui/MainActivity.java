package com.test.premier.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.test.premier.R;

public class MainActivity extends AppCompatActivity {

    private final String TOP_RATED = "https://api.themoviedb.org/3/movie/top_rated?api_key=e4f9e61f6ffd66639d33d3dde7e3159b";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
