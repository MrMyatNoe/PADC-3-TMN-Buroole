package com.myanmar.tmn.buroole.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.myanmar.tmn.buroole.BurooleApp;
import com.myanmar.tmn.buroole.R;
import com.myanmar.tmn.buroole.adapter.ImageInBurppleItemAdapter;
import com.myanmar.tmn.buroole.adapter.ItemBurppleGuidesAdapter;
import com.myanmar.tmn.buroole.adapter.ItemBurppleNewsNTrendingAdapter;
import com.myanmar.tmn.buroole.adapter.ItemBurpplePromotionsAdapter;
import com.myanmar.tmn.buroole.adapter.ItemBurppleTrendingVenuesAdapter;
import com.myanmar.tmn.buroole.data.model.GuideModel;
import com.myanmar.tmn.buroole.data.model.LoginUserModel;
import com.myanmar.tmn.buroole.data.model.PromotionModel;
import com.myanmar.tmn.buroole.delegates.BeforeLoginDelegate;
import com.myanmar.tmn.buroole.delegates.LoginUserDelegate;
import com.myanmar.tmn.buroole.event.LoadedGuidesEvent;
import com.myanmar.tmn.buroole.event.LoadedPromotionsEvent;
import com.myanmar.tmn.buroole.viewPods.AccountControlViewPod;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BeforeLoginDelegate,LoginUserDelegate{

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.vp_burpple_image_details)
    ViewPager burppleImageDetails;

    @BindView(R.id.rv_promotions_data)
    RecyclerView promotionData;

    @BindView(R.id.rv_burpple_guide_data)
    RecyclerView guideData;

    @BindView(R.id.rv_newly_opened)
    RecyclerView newlyOpenedData;

    @BindView(R.id.rv_trending_venues)
    RecyclerView trendingVenues;

    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    @BindView(R.id.navigationView)
    NavigationView navigationView;

    private ImageInBurppleItemAdapter imageInBurppleItemAdapter;

    private ItemBurpplePromotionsAdapter itemBrupplePromotionsAdapter;

    private ItemBurppleGuidesAdapter itemBruppleGuidesAdapter;

    private ItemBurppleNewsNTrendingAdapter itemBruppleNewsNTrendingAdapter;

    private ItemBurppleTrendingVenuesAdapter itemBurppleTrendingVenuesAdapter;

    private AccountControlViewPod accountControlViewPod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this,this);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_dehaze_black_24dp);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

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
                LinearLayoutManager.VERTICAL,false);
        newlyOpenedData.setLayoutManager(newManager);
        newlyOpenedData.setAdapter(itemBruppleNewsNTrendingAdapter);


        itemBurppleTrendingVenuesAdapter = new ItemBurppleTrendingVenuesAdapter();
        LinearLayoutManager venueManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL,false);
        trendingVenues.setLayoutManager(venueManager);
        trendingVenues.setAdapter(itemBurppleTrendingVenuesAdapter);

        accountControlViewPod = (AccountControlViewPod) navigationView.getHeaderView(0);
        accountControlViewPod.setDelegate((LoginUserDelegate) this);
        accountControlViewPod.setDelegate((LoginUserDelegate) this);

        PromotionModel.getInstance().loadPromotion();

        GuideModel.getInstance().loadGuides();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
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
        if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
        }

        return super.onOptionsItemSelected(item);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPromotionLoaded(LoadedPromotionsEvent event){
        Log.d(BurooleApp.LOG_CAT,"onPromotionsLoaded " + event.getPromotionList().size());
        itemBrupplePromotionsAdapter.setPromotions(event.getPromotionList());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGuidesLoaded(LoadedGuidesEvent event){
        Log.d(BurooleApp.LOG_CAT,"onGuidesLoaded " + event.getGuidesList().size());
        itemBruppleGuidesAdapter.setGuides(event.getGuidesList());
    }

    @Override
    public void onTappedLogout() {
        LoginUserModel.getOurInstance().logOut();
    }

    @Override
    public void onTapToLogin() {
        Intent intent = AccountControlActivity.newIntentLogin(getApplicationContext());
        startActivity(intent);
    }

    @Override
    public void onTapToRegister() {
        Intent intent = AccountControlActivity.newIntentRegister(getApplicationContext());
        startActivity(intent);
    }
}
