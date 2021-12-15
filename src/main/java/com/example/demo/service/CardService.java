package com.example.demo.service;

import com.example.demo.entity.Card;
import com.example.demo.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CardService {

    public List<Player> getCard(int playerNum) {
        List<String> pattern = Arrays.asList("♠", "❤", "♦", "♣");
        List<String> number = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
        Card card = Card.Builder.aCard()
                .list(switchCardOrder(getOrderCardList(pattern, number)))
                .build();
        List<Player> players = new ArrayList<>();

        int startIdx = 0;
        int space = 52 / playerNum;

        for(int i = 0; i < playerNum; i++) {
            Player player = Player.Builder.aPlayer()
                    .name(String.valueOf(i))
                    .card(card.getList().subList(startIdx, startIdx + space))
                    .build();
            players.add(player);
            startIdx += space;
        }
        return players;
    }
    public List<String> getOrderCardList(List<String> pattern, List<String> number){
            List<String> list = new ArrayList<>();
            for (String s : pattern) {
                for (String n : number) {
                    list.add(s + n);
                }
            }
            return list;
    }
    public List<String> switchCardOrder(List<String> originalCardList){
        List<String> newCardList = new ArrayList<>(originalCardList);
        for (int i = 51; i >= 0; i--) {
            int selectedIdx = (int) Math.round(Math.random() * i);
            String value = newCardList.get(selectedIdx);
            newCardList.set(selectedIdx, newCardList.get(i)); // 指定的索引位置設為倒數第 i 的值
            newCardList.set(i, value); // 倒數第 i 的索引位置設為指定的索引值
        }
        return newCardList;
    }

}
