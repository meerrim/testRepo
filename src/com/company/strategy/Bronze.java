package com.company.strategy;

public class Bronze extends ProductStrategy{
    @Override
    public String makeCode(String input) {
        return super.makeCode("Bronze- " + input);
    }
}
