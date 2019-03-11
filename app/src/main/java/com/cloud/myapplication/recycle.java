package com.cloud.myapplication;
 import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
 import android.view.animation.Animation;
 import android.view.animation.AnimationUtils;
 import android.widget.RelativeLayout;

 import java.util.ArrayList;
        import java.util.List;

public class recycle extends AppCompatActivity {

    //a list to store all the products
    List<Product> productList;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.item_animation);
        RelativeLayout relativeLayout = findViewById(R.id.rl);//layout name with id
        relativeLayout.startAnimation(animation);


        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new Product(
                        1,
                        "Topic 1",
                        "Subtopic 1",
                        4.3,
                        60000,
                        R.drawable.android,
                "final.pdf"
                ));

        productList.add(
                new Product(
                        1,
                        "Topic 2",
                        "Subtopic 2",
                        4.3,
                        60000,
                        R.drawable.android,                "final.pdf"
                ));

        productList.add(
                new Product(
                        1,
                        "Topic 3",
                        "Subtopic 3",
                        4.3,
                        60000,
                        R.drawable.android,                "final.pdf"
                ));

        //creating recyclerview adapter
        ProductAdapter adapter = new ProductAdapter(this, productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }
}