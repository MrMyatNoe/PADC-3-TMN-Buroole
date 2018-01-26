package com.myanmar.tmn.buroole.data.model;

import com.myanmar.tmn.buroole.network.GuidesDataAgent;
import com.myanmar.tmn.buroole.network.RetrofitDataAgent;

/**
 * Created by msi on 1/13/2018.
 */

public class GuideModel {

    private static GuideModel mInstance;

    private GuidesDataAgent guidesDataAgent;

    public static GuideModel getInstance() {
        if (mInstance == null){
            mInstance = new GuideModel();
        }
        return mInstance;
    }

    private GuideModel() {
        //guidesDataAgent = OKHttpGuidesDataAgent.getsObjectInstance();
        guidesDataAgent = RetrofitDataAgent.getsObjectInstance();
    }

    public void loadGuides(){
        guidesDataAgent.loadGuides();
    }

}
