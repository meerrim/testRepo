package com.company.strategy;

public class Gold extends ProductStrategy{

    @Override
    public String makeCode(String input) {
        return super.makeCode("Gold-" + input);
    }
}
