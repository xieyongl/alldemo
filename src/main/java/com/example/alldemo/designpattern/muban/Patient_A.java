package com.example.alldemo.designpattern.muban;

public class Patient_A extends AbstractHospital{
    @Override
    public String treat() {
        String treat = "胃病";
        System.out.println("你的病为"+treat);
        return treat;
    }
    @Override
    public String recipe() {
        String recipe = "健胃消食片";
        System.out.println("药单："+recipe);
        return recipe;
    }

    //重写钩子方法
    @Override
    boolean isRecipe() {
        return false;
    }
}
