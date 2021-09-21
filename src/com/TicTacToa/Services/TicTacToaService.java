package com.TicTacToa.Services;

import com.TicTacToa.Models.Player;

import java.util.*;

public class TicTacToaService {

    private Queue<Player>players;
    List<List<Character>>grid;


    public TicTacToaService() {

    }

    //initialize the grid
    public  void initializegrid(){
        this.grid = new ArrayList<>();
        for(int i =0;i<3;i++){
            this.grid.add(new ArrayList<Character>(3));
        }
        for(int i =0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                this.grid.get(i).add('-');
            }
        }
    }

    //set the players
    public void setPlayers(List<Player>playerList){
        this.players = new LinkedList<Player>();
        for(Player player :playerList){
            this.players.add(player);
        }
    }

    //print the grid
    public void printgrid(){
        for(int i =0;i<3;i++){
            for(int j =0;j<3;j++){
                System.out.print(this.grid.get(i).get(j) +" ");
            }
            System.out.println();
        }
    }

    //check valid move of player
    public boolean checkvalidity( int row, int col){
        row = row -1;
        col = col -1;
        if(this.grid.get(row).get(col) == '-'){
            return true;
        }
        return false;
    }

    //player move
    public boolean playermove(Player player, int row, int col){
          if(checkvalidity(row,col )){
              this.grid.get(row-1).set(col-1, player.getSymbol());
              return true;
          }else{
              return false;
          }
    }
    //check player won in the given row
    public boolean checkrowWise(Player player, int row){
        boolean similiarsimpbol  = true;
        for(int i = 0;i<3;i++){
            if(this.grid.get(row-1).get(i) != player.getSymbol()){
                similiarsimpbol = false;
                break;
            }
        }
        return similiarsimpbol;
    }

    //check player won in the given col
    public boolean checkcolWise(Player player, int col){
        boolean similiarsimpbol  = true;
        for(int i = 0;i<3;i++){
            if(this.grid.get(i).get(col-1) != player.getSymbol()){
                similiarsimpbol = false;
                break;
            }
        }
        return similiarsimpbol;
    }

    //check diagnonally
    public boolean checkdiagonal(Player player, int row, int col){
        //check in fist diagnoal
        if(row != 1 && col != 1){
            return  false;
        }
        boolean firstdiagonalcheck = true;
        for(int i =0;i<3;i++){
            if(this.grid.get(i).get(i) != player.getSymbol()){
                firstdiagonalcheck = false;
            }
        }

        boolean seconddiagonalcheck = true;
        for(int i =0;i<3;i++){
            if(this.grid.get(i).get(2-i) != player.getSymbol()){
                seconddiagonalcheck = false;
            }
        }

        return firstdiagonalcheck || seconddiagonalcheck;
    }


    //check player won
    boolean checkplayerwon(Player player, int row, int col){

        return checkrowWise(player,row) || checkcolWise(player,col) || checkdiagonal(player,row,col);
    }

    //start the game

    public void startgame(Scanner sc){
        int initalcount = 1;

        while(initalcount <= 9){
            Player currentPlayer = this.players.peek();
            System.out.println(currentPlayer.getName() + " Enter the cell position");
            int row = sc.nextInt();
            int col = sc.nextInt();
            if(this.playermove(currentPlayer,row,col)){
                printgrid();
                if(checkplayerwon(currentPlayer,row,col)){
                    System.out.println(currentPlayer.getName() +" won the game");
                    return;
                }
                this.players.poll();
                this.players.add(currentPlayer);
                initalcount++;
            }else{
                System.out.println("Invalid Move");
            }
        }
        System.out.println("Match draw");
        return;
    }
}
