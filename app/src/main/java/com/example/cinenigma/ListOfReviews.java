package com.example.cinenigma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListOfReviews extends AppCompatActivity {
    private Button revenir;
    private Intent goBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_reviews);
       // goBack = new Intent(this, MainActivity.class);
       // revenir = (Button) findViewById(R.id.backToForm);
    }

    @Override
    protected void onResume() {
        super.onResume();
    // do the db thingz again
    }

    public void ReturnToForm(View view) {
        finish();
    }
}
