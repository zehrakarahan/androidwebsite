package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DetailsActivity extends AppCompatActivity {
    TextView nameDetailTextView,descriptionDetailTextView,dateDetailTextView,categoryDetailTextView;
    ImageView teacherDetailImageView;
    private void initializeWidgets()
    {
        nameDetailTextView=(TextView) findViewById(R.id.nameDetailTextView);
        descriptionDetailTextView=(TextView) findViewById(R.id.descriptionDetailTextView);
        dateDetailTextView= (TextView) findViewById(R.id.dateDetailTextView);
        categoryDetailTextView=(TextView) findViewById(R.id.categoryDetailTextView);
        teacherDetailImageView=(ImageView) findViewById(R.id.teacherDetailImageView);
    }
    private String getDateToday()
    {
        DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd");
        Date date=new Date();
        String today=dateFormat.format(date);
        return today;
    }
    private String getRandomCategory()
    {
        String[] categories={"ZEN","BUDHIST","TOGA"};
        Random random=new Random();
        int index=random.nextInt(categories.length-1);
        return categories[index];
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initializeWidgets();
        Intent i=this.getIntent();
        String name=i.getExtras().getString("NAME_KEY");
        String description=i.getExtras().getString("DESCRIPTION_KEY");
        String imageURL=i.getExtras().getString("IMAGE_KEY");
        nameDetailTextView.setText(name);
        descriptionDetailTextView.setText(description);
        dateDetailTextView.setText("DATE: "+getDateToday());
        categoryDetailTextView.setText("CATEGORY: "+getRandomCategory());

        Picasso.with(this)
                .load(imageURL)
                .fit()
                .centerCrop()
                .into(teacherDetailImageView);
    }
}
