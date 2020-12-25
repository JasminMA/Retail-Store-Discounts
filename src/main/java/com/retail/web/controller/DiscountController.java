package com.retail.web.controller;

import com.retail.exceptions.DiscountException;
import com.retail.trx.services.api.DiscountService;
import com.retail.web.models.BillRequestTransaction;
import com.retail.web.models.BillResponseTransaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/discount")
public class DiscountController {
    private static final Logger logger = LogManager.getLogger(DiscountController.class);
    @Autowired
    private DiscountService discountService;

    @PostMapping(value = "/getdiscount", consumes = "application/json")
    public ResponseEntity<BillResponseTransaction> getDiscount(@RequestBody BillRequestTransaction billRequestTransaction) {
        BillResponseTransaction billResponseTransaction;
        try {
            if (billRequestTransaction == null) {
                throw new DiscountException("Invalid request");
            }
            double totalDiscount = discountService.getDiscountAmount(billRequestTransaction.getUserNationalID(),
                    billRequestTransaction.getBillItemsType(), billRequestTransaction.getTotalAmount());
            billResponseTransaction = BillResponseTransaction.buildSuccessResponse(totalDiscount);
        } catch (Exception exception) {
            billResponseTransaction = BillResponseTransaction.buildFailedResponse(exception);
        }
        return new ResponseEntity<>(billResponseTransaction, HttpStatus.OK);
    }
}
