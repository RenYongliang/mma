package com.ryl.ssm.service;

import com.ryl.ssm.po.Items;

import java.util.List;

public interface ItemService {
    List<Items> getItemList(Items items);
    Items getItemById(int id);
    void updateItem(Items items);
}
