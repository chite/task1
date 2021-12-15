package com.example.demo.entity;

import java.util.List;

public class Player {
    private String name;
    private List<String> card;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCard() {
        return card;
    }

    public void setCard(List<String> card) {
        this.card = card;
    }

    public static final class Builder {
        private Player player;

        private Builder() {
            player = new Player();
        }

        public static Builder aPlayer() {
            return new Builder();
        }

        public Builder name(String name) {
            player.setName(name);
            return this;
        }

        public Builder card(List<String> card) {
            player.setCard(card);
            return this;
        }

        public Player build() {
            return player;
        }
    }
}
