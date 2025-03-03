package com.developersuraj.mongoquary.service;

import com.developersuraj.mongoquary.model.ItemsData;
import com.developersuraj.mongoquary.repository.ItemsRepository;
import com.developersuraj.mongoquary.repository.MongoQueryIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchItemService {

    @Autowired
    private ItemsRepository itemsRepository;

    @Autowired
    private MongoQueryIMPL mongoQueryIMPL;

    public ItemsData addItems(ItemsData item){
        try {

            return itemsRepository.save(item);

        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    public List<ItemsData> findAllItems(){

        return itemsRepository.findAll();
    }


    public List<ItemsData> searchItems(String itemName, String category, Integer minPrice, Integer maxPrice, String sale) {
        return mongoQueryIMPL.searchItems(itemName, category, minPrice, maxPrice, sale);
    }

}
