package com.developersuraj.mongoquary.controller;

import com.developersuraj.mongoquary.model.ItemsData;
import com.developersuraj.mongoquary.service.SearchItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemSearchController {

    @Autowired
    private SearchItemService searchItemService;

    @GetMapping()
    public List<ItemsData> all(){
        return searchItemService.findAllItems();
    }

    @PostMapping
    public ItemsData saveItem(@RequestBody ItemsData itemsData){

        return searchItemService.addItems(itemsData);

    }

    // Search items with filters
    @GetMapping("/search")
    public List<ItemsData> searchByQuery(
            @RequestParam(required = false) String itemName,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Integer minPrice,
            @RequestParam(required = false) Integer maxPrice,
            @RequestParam(required = false) String sale
    ) {
        return searchItemService.searchItems(itemName, category, minPrice, maxPrice, sale);
    }
}
