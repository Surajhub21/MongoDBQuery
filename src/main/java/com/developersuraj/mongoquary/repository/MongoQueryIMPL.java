package com.developersuraj.mongoquary.repository;

import com.developersuraj.mongoquary.model.ItemsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MongoQueryIMPL {

    @Autowired
    private MongoTemplate mongoTemplate;

    // Advanced search with multiple criteria
    public List<ItemsData> searchItems(String itemName, String category, Integer minPrice, Integer maxPrice, String sale) {
        Query query = new Query();

        if (itemName != null && !itemName.isEmpty()) {
            query.addCriteria(Criteria.where("itemName").is(itemName));
        }
        if (category != null && !category.isEmpty()) {
            query.addCriteria(Criteria.where("category").is(category));
        }
        if (minPrice != null && maxPrice != null) {
            query.addCriteria(Criteria.where("price").gte(minPrice).lte(maxPrice));
        }
        if (sale != null && !sale.isEmpty()) {
            query.addCriteria(Criteria.where("sale").is(sale));
        }

        return mongoTemplate.find(query, ItemsData.class);
    }
}
