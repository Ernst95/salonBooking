package com.salonbooking.repositories.Impl;

import com.salonbooking.domain.Receipt;
import com.salonbooking.repositories.ReceiptRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ernst on 2017/07/14.
 */
public class ReceiptRepositoryImpl implements ReceiptRepository{

    private static ReceiptRepositoryImpl respository = null;

    private Map<String, Receipt> receiptTable;

    private ReceiptRepositoryImpl() {

        receiptTable = new HashMap<String, Receipt>();
    }

    public static ReceiptRepositoryImpl getInstance(){
        if(respository==null)
            respository = new ReceiptRepositoryImpl();
        return respository;
    }

    public Receipt create(Receipt receipt) {
        receiptTable.put(receipt.getId(),receipt);
        Receipt savedReceipt = receiptTable.get(receipt.getId());
        return savedReceipt;
    }

    public Receipt read(String id) {
        Receipt receipt = receiptTable.get(id);
        return receipt;
    }

    public Receipt update(Receipt receipt) {
        receiptTable.put(receipt.getId(),receipt);
        Receipt savedReceipt = receiptTable.get(receipt.getId());
        return savedReceipt;
    }

    public void delete(String id) {
        receiptTable.remove(id);

    }
}
