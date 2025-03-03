package com.developersuraj.mongoquary.model;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
public class ItemsData {

    @Id
    private ObjectId id;
    @NonNull
    private String itemName;
    @NonNull
    private String category;
    @NonNull
    private int price;
    @NonNull
    private String dateOfExpiring;
    @NonNull
    private String sale;
}
