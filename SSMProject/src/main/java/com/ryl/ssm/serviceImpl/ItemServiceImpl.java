package com.ryl.ssm.serviceImpl;

import com.ryl.ssm.mapper.ItemsMapper;
import com.ryl.ssm.po.Items;
import com.ryl.ssm.po.ItemsExample;
import com.ryl.ssm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemsMapper itemsMapper;
    @Override
    public List<Items> getItemList(Items items) {
        ItemsExample itemsExample = new ItemsExample();
        ItemsExample.Criteria criteria = itemsExample.createCriteria();
        try{
            criteria.andIdEqualTo(items.getId());
        }catch(Exception e){}
        if(items.getName()!=null && items.getName()!=""){
            criteria.andNameLike("%" + items.getName() + "%");
        }
        List<Items> list = itemsMapper.selectByExampleWithBLOBs(itemsExample);
        return list;
    }

    @Override
    public Items getItemById(int id) {
        Items items = itemsMapper.selectByPrimaryKey(id);
        return items;
    }

    @Override
    public void updateItem(Items items) {
        itemsMapper.updateByPrimaryKeySelective(items);
    }

}
