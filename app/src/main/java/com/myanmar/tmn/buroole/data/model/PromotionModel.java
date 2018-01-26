package com.myanmar.tmn.buroole.data.model;

import com.myanmar.tmn.buroole.network.PromotionDataAgent;
import com.myanmar.tmn.buroole.network.RetrofitDataAgent;


/**
 * Created by msi on 1/13/2018.
 */

public class PromotionModel {

    private static PromotionModel mInstance;

    private PromotionDataAgent promotionDataAgent;

    public static PromotionModel getInstance() {
        if (mInstance == null){
            mInstance = new PromotionModel();
        }
        return mInstance;
    }

    private PromotionModel() {
        promotionDataAgent = RetrofitDataAgent.getsObjectInstance();
    }

    public void loadPromotion(){
        promotionDataAgent.loadPromotion();
    }
}
