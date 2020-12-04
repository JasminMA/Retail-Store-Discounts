package com.retail.trx.services.impl;

import com.retail.trx.models.enums.ItemTypeEnum;
import com.retail.trx.services.api.DiscountService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class DiscountServiceImplTest {


    @Autowired
    private DiscountService discountService;

    @Test
    void getUserDoesNotExist() {
    }

    @Test
    void employee_affiliate_OverTw0Years()throws Exception{
        double amountAfterApplyingDiscount = discountService.getDiscountAmount("1234567890", ItemTypeEnum.ELECTRONICS, 30);
        Assert.assertEquals(21.0,amountAfterApplyingDiscount,0.01);
    }

    @Test
    void employee_affiliate_NotOverTw0Years()throws Exception{
        double amountAfterApplyingDiscount = discountService.getDiscountAmount("1234567891", ItemTypeEnum.ELECTRONICS, 30);
        Assert.assertEquals(21.0,amountAfterApplyingDiscount,0.01);
    }

    @Test
    void employee_NotAffiliate_OverTw0Years()throws Exception{
        double amountAfterApplyingDiscount = discountService.getDiscountAmount("1234567892", ItemTypeEnum.ELECTRONICS, 30);
        Assert.assertEquals(21.0,amountAfterApplyingDiscount,0.01);
    }

    @Test
    void employee_NotAffiliate_NotOverTw0Years()throws Exception{
        double amountAfterApplyingDiscount = discountService.getDiscountAmount("1234567893", ItemTypeEnum.ELECTRONICS, 30);
        Assert.assertEquals(21.0,amountAfterApplyingDiscount,0.01);
    }

    @Test
    void NotEmployee_Affiliate_OverTw0Years()throws Exception{
        double amountAfterApplyingDiscount = discountService.getDiscountAmount("1234567894", ItemTypeEnum.ELECTRONICS, 30);
        Assert.assertEquals(27.0,amountAfterApplyingDiscount,0.01);
    }

    @Test
    void NotEmployee_Affiliate_NotOverTw0Years()throws Exception{
        double amountAfterApplyingDiscount = discountService.getDiscountAmount("1234567895", ItemTypeEnum.ELECTRONICS, 30);
        Assert.assertEquals(27.0,amountAfterApplyingDiscount,0.01);
    }

    @Test
    void NotEmployee_NotAffiliate_OverTw0Years()throws Exception{
        double amountAfterApplyingDiscount = discountService.getDiscountAmount("1234567896", ItemTypeEnum.ELECTRONICS, 30);
        Assert.assertEquals(28.5,amountAfterApplyingDiscount,0.01);
    }

    @Test
    void NotEmployee_NotAffiliate_NotOverTw0Years()throws Exception{
        double amountAfterApplyingDiscount = discountService.getDiscountAmount("1234567897", ItemTypeEnum.ELECTRONICS, 30);
        Assert.assertEquals(30.0,amountAfterApplyingDiscount,0.01);;
    }


    @Test
    void employee_affiliate_OverTw0Years_300()throws Exception{
        double amountAfterApplyingDiscount = discountService.getDiscountAmount("1234567890", ItemTypeEnum.ELECTRONICS, 300);
        Assert.assertEquals(195.0,amountAfterApplyingDiscount,0.01);
    }

    @Test
    void employee_affiliate_NotOverTw0Years_300()throws Exception{
        double amountAfterApplyingDiscount = discountService.getDiscountAmount("1234567891", ItemTypeEnum.ELECTRONICS, 300);
        Assert.assertEquals(195.0,amountAfterApplyingDiscount,0.01);
    }

    @Test
    void employee_NotAffiliate_OverTw0Years_300()throws Exception{
        double amountAfterApplyingDiscount = discountService.getDiscountAmount("1234567892", ItemTypeEnum.ELECTRONICS, 300);
        Assert.assertEquals(195.0,amountAfterApplyingDiscount,0.01);
    }

    @Test
    void employee_NotAffiliate_NotOverTw0Years_300()throws Exception{
        double amountAfterApplyingDiscount = discountService.getDiscountAmount("1234567893", ItemTypeEnum.ELECTRONICS, 300);
        Assert.assertEquals(195.0,amountAfterApplyingDiscount,0.01);
    }

    @Test
    void NotEmployee_Affiliate_OverTw0Years_300()throws Exception{
        double amountAfterApplyingDiscount = discountService.getDiscountAmount("1234567894", ItemTypeEnum.ELECTRONICS, 300);
        Assert.assertEquals(255.0,amountAfterApplyingDiscount,0.01);
    }

    @Test
    void NotEmployee_Affiliate_NotOverTw0Years_300()throws Exception{
        double amountAfterApplyingDiscount = discountService.getDiscountAmount("1234567895", ItemTypeEnum.ELECTRONICS, 300);
        Assert.assertEquals(255.0,amountAfterApplyingDiscount,0.01);
    }

    @Test
    void NotEmployee_NotAffiliate_OverTw0Years_300()throws Exception{
        double amountAfterApplyingDiscount = discountService.getDiscountAmount("1234567896", ItemTypeEnum.ELECTRONICS, 300);
        Assert.assertEquals(270,amountAfterApplyingDiscount,0.01);
    }

    @Test
    void NotEmployee_NotAffiliate_NotOverTw0Years_300()throws Exception{
        double amountAfterApplyingDiscount = discountService.getDiscountAmount("1234567897", ItemTypeEnum.ELECTRONICS, 300);
        Assert.assertEquals(285,amountAfterApplyingDiscount,0.01);;
    }

    @Test
    void groceries_300()throws Exception{
        double amountAfterApplyingDiscount = discountService.getDiscountAmount("1234567890", ItemTypeEnum.GROCERIES, 300);
        Assert.assertEquals(285.0,amountAfterApplyingDiscount,0.01);
    }

}