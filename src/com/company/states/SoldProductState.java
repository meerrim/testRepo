package com.company.states;

import com.company.Product;

public class SoldProductState extends ProductState{

    @Override
    public void raisePrice(Product product) throws Exception {
        throw new Exception("нельзя повысить стоимость, так как товар уже продан.");
    }

    @Override
    public void startSale(Product product) throws Exception {
        throw new Exception("нельзя начать продажу, так как товар уже продан.");
    }

    @Override
    public void giveToTheWinner(Product product) throws Exception {
        throw new Exception("нельзя выдать покупателю, так как товар уже выдан.");
    }

    @Override
    public void withdraw(Product product) throws Exception {
        throw new Exception("нельзя снять с торгов, так как товар уже продан.");
    }
}

