package com.retail.trx.models;

import com.retail.trx.models.enums.ItemTypeEnum;

import javax.persistence.*;

@Entity
@Table(name = "ShopItems")
public class ShopItems {
    private long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ItemTypeEnum itemType;

    public void setId(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemTypeEnum getItemType() {
        return itemType;
    }

    public void setItemType(ItemTypeEnum itemType) {
        this.itemType = itemType;
    }
}
