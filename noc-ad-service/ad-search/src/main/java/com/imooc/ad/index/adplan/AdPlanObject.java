package com.imooc.ad.index.adplan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 索引对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdPlanObject {

    private Long planId;
    private Long userId;
    private Integer planStatus;
    private Date startDate;
    private Date endDate;

    public void update(AdPlanObject newObject) {
        if (newObject.planId != null) {
            this.planId = newObject.planId;
        }
        if (newObject.userId != null) {
            this.userId = newObject.userId;
        }
        if (newObject.planStatus != null) {
            this.planStatus = newObject.planStatus;
        }
        if (newObject.startDate != null) {
            this.startDate = newObject.startDate;
        }
        if (newObject.endDate != null) {
            this.endDate = newObject.endDate;
        }
    }
}
