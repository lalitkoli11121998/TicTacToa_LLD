package com.TicTacToa;

import com.TicTacToa.Models.Player;
import com.TicTacToa.Services.TicTacToaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // System.out.println("hii");
        Scanner sc = new Scanner(System.in);
        TicTacToaService ticTacToaService = new TicTacToaService();
        List<Player> playerList = new ArrayList<>();
        System.out.println("Enter first player name");
        Player player1 = new Player(sc.next(), 'X');
        playerList.add(player1);
        System.out.println("Enter second player name");
        Player player2 = new Player(sc.next(), 'O');
        playerList.add(player2);

        ticTacToaService.initializegrid();
        ticTacToaService.printgrid();
        ticTacToaService.setPlayers(playerList);
        ticTacToaService.startgame(sc);



    }
}
