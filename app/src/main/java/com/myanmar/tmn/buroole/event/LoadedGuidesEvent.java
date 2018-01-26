package com.myanmar.tmn.buroole.event;

import com.myanmar.tmn.buroole.data.vo.GuidesVO;
import com.myanmar.tmn.buroole.data.vo.PromotionsVO;

import java.util.List;

/**
 * Created by msi on 1/13/2018.
 */

public class LoadedGuidesEvent {

    private List<GuidesVO> guidesList;

    public LoadedGuidesEvent(List<GuidesVO> guidesList) {
        this.guidesList = guidesList;
    }

    public List<GuidesVO> getGuidesList() {
        return guidesList;
    }
}
