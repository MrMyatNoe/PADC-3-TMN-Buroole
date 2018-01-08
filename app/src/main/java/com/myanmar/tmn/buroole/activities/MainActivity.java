package com.myanmar.tmn.buroole.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.myanmar.tmn.buroole.R;
import com.myanmar.tmn.buroole.adapter.ImageInBurppleItemAdapter;
import com.myanmar.tmn.buroole.adapter.ItemBurppleGuidesAdapter;
import com.myanmar.tmn.buroole.adapter.ItemBurppleNewsNTrendingAdapter;
import com.myanmar.tmn.buroole.adapter.ItemBurpplePromotionsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    /*@BindView(R.id.toolbar)
    Toolbar toolbar;*/

    @BindView(R.id.vp_burpple_image_details)
    ViewPager burppleImageDetails;

    @BindView(R.id.rv_promotions_data)
    RecyclerView promotionData;

    @BindView(R.id.rv_burpple_guide_data)
    RecyclerView guideData;

    @BindView(R.id.rv_new_trending)
    RecyclerView newsTrendingData;

    private ImageInBurppleItemAdapter imageInBurppleItemAdapter;

    private ItemBurpplePromotionsAdapter itemBrupplePromotionsAdapter;

    private ItemBurppleGuidesAdapter itemBruppleGuidesAdapter;

    private ItemBurppleNewsNTrendingAdapter itemBruppleNewsNTrendingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this,this);

        imageInBurppleItemAdapter = new ImageInBurppleItemAdapter();
        burppleImageDetails.setAdapter(imageInBurppleItemAdapter);

        itemBrupplePromotionsAdapter = new ItemBurpplePromotionsAdapter();
        LinearLayoutManager promotionManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.HORIZONTAL,false);
        promotionData.setLayoutManager(promotionManager);
        promotionData.setAdapter(itemBrupplePromotionsAdapter);

        itemBruppleGuidesAdapter= new ItemBurppleGuidesAdapter();
        LinearLayoutManager guideManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.HORIZONTAL,false);
        guideData.setLayoutManager(guideManager);
        guideData.setAdapter(itemBruppleGuidesAdapter);

        itemBruppleNewsNTrendingAdapter = new ItemBurppleNewsNTrendingAdapter();
        LinearLayoutManager newManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.HORIZONTAL,false);
        newsTrendingData.setLayoutManager(newManager);
        newsTrendingData.setAdapter(itemBruppleNewsNTrendingAdapter);
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
