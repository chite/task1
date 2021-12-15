package com.example.demo.entity;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Card {

    private List<String> pattern;

    private List<String> number;

    private List<String> list;



    public void setList(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }


    public List<String> getPattern() {
        return pattern;
    }

    public void setPattern(List<String> pattern) {
        this.pattern = pattern;
    }

    public void setNumber(List<String> number) {
        this.number = number;
    }

    public List<String> getNumber() {
        return number;
    }

    public static final class Builder {
        private Card card;

        private Builder() {
            card = new Card();
        }

        public static Builder aCard() {
            return new Builder();
        }

        public Builder pattern(List<String> pattern) {
            card.setPattern(pattern);
            return this;
        }

        public Builder number(List<String> number) {
            card.setNumber(number);
            return this;
        }

        public Builder list(List<String> list) {
            card.setList(list);
            return this;
        }

        public Card build() {
            return card;
        }
    }
}

