package com.company.strategy;

public class Silver extends ProductStrategy{

    @Override
    public String makeCode(String input) {
        return super.makeCode("Silver-" + input);
    }
}
