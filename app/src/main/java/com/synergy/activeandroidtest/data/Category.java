package com.synergy.activeandroidtest.data;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.List;

/**
 * Created by daniel on 8/05/15.
 */
@Table(name = "Categories")
public class Category extends Model {
    @Column(name = "Name")
    private String name;

    public Category() {
        super();
    }

    public Category(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category["+name+"]";
    }

    // This method is optional, does not affect the foreign key creation.
    public List<Item> items() {
        return getMany(Item.class, "Category");
    }

}
