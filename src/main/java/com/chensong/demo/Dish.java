package com.chensong.demo;

/**
 * @ProjectName: coursepub
 * @Package: com.chensong.demo
 * @ClassName: Dish
 * @Description: java类作用描述
 * @Author: chensong
 * @CreateDate: 2019/11/26 23:05
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/26 23:05
 * @UpdateRemark: 更说明
 * @Version: 1.0
 */
public class Dish {
   private String name;
   private boolean vegetarian;
   private Integer calories;
   private  Type Type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public com.chensong.demo.Type getType() {
        return Type;
    }

    public void setType(com.chensong.demo.Type type) {
        Type = type;
    }

    public Dish(String name, boolean vegetarian, Integer calories, com.chensong.demo.Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        Type = type;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", calories=" + calories +
                ", Type=" + Type +
                '}';
    }
}
