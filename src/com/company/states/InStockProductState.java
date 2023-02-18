package com.company.states;

import com.company.Product;
import com.company.State;

public class InStockProductState extends ProductState{

    @Override
    public void raisePrice(Product product) throws Exception {
        throw new Exception("Нельзя поднять цену товара на складе!");
    }

    @Override
    public void startSale(Product product) throws Exception {
        product.setState(State.for_sale);
        product.setStateClass(new ForSaleProductState());
        System.out.println("Состояние успешно изменилось. Товар выставлен на торги.");
    }

    @Override
    public void giveToTheWinner(Product product) throws Exception {
        throw new Exception("Ошибка, нельзя отдать товар сразу со склада!");
    }

    @Override
    public void withdraw(Product product) throws Exception {
        throw new Exception("Ошибка, нельзя снять с торгов товар, который в них не участвует!");
    }
}


