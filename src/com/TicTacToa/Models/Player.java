package com.TicTacToa.Models;

public class Player {

    private String name;
    private Character symbol;

    public Player(String name, Character symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public Character getSymbol() {
        return symbol;
    }

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
