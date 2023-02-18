package com.company;

import com.company.states.ProductState;

public class Product {
    private String id;
    private String name;
    private Long price;
    private Long startPrice;
    private String honorary_code;
    private State state;
    private ProductState stateClass;

    public Product(String id, String name, Long price, Long startPrice, String honorary_code, State state) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.startPrice = startPrice;
        this.honorary_code = honorary_code;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getStartPrice() {
        return startPrice;
    }

    public String getHonorary_code() {
        return honorary_code;
    }

    public void setHonorary_code(String honorary_code) {
        this.honorary_code = honorary_code;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public ProductState getStateClass() {
        return stateClass;
    }

    public void setStateClass(ProductState stateClass) {
        this.stateClass = stateClass;
    }

//    Методы по вызову методов состояния, мы же не будем напрямую вызывать у ProductState класса из продукта, нам же проще
//    обращаться сразу к продукту, т.к мы будем работать именно с продуктом

    public void startSale() throws Exception {
        stateClass.startSale(this);
    }

    public void raisePrice() throws Exception {
        stateClass.raisePrice(this);
    }

    public void giveToTheWinner() throws Exception {
        stateClass.giveToTheWinner(this);
    }

    public void withDraw() throws Exception {
        stateClass.withdraw(this);
    }

}

