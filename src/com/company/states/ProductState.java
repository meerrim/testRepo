package com.company.states;

import com.company.Product;

public abstract class ProductState {

    public abstract void startSale(Product product) throws Exception;

    public abstract void raisePrice(Product product) throws Exception;

    public abstract void giveToTheWinner(Product product) throws Exception;

    public abstract void withdraw(Product product) throws Exception;

}

