package com.cloud.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import android.view.MenuItem;

import com.github.barteksc.pdfviewer.PDFView;

public class pdf extends AppCompatActivity {
    String link="",productList="";
    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        productList=getIntent().getStringExtra("productList");
        link=getIntent().getStringExtra("link");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(productList);
        pdfView=findViewById(R.id.pdfv);
        pdfView.fromAsset(link).load();
    }
    @Override public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == android.R.id.home)//means home default hai kya yesok
        {
            onBackPressed();
            return true;
        }
        return false;
    }
}

