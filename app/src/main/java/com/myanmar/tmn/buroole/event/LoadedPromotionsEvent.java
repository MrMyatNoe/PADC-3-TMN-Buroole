package com.myanmar.tmn.buroole.event;

import com.myanmar.tmn.buroole.data.vo.PromotionsVO;

import java.util.List;

/**
 * Created by msi on 1/13/2018.
 */

public class LoadedPromotionsEvent {

    private List<PromotionsVO> promotionList;

    public LoadedPromotionsEvent(List<PromotionsVO> promotionList) {
        this.promotionList = promotionList;
    }

    public List<PromotionsVO> getPromotionList() {
        return promotionList;
    }
}
