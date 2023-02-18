package com.company;

public enum State {
    in_stock("на складе"),
    for_sale("на торгах"),
    sold("продан");

    private String description;

    State(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

