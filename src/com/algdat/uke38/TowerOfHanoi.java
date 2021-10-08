package com.algdat.uke38;

public class TowerOfHanoi {
    public static void main(String[] args){
        towerOfHanoi(1);
    }
    public static void towerOfHanoi(int antallPieces){
        hanoiMove(antallPieces, 'A', 'C', 'B');
    }
    public static void hanoiMove(int piece_nummer, char fra, char til, char hjelp){
        if(piece_nummer <= 0){
            return;
        }
        hanoiMove(piece_nummer - 1, fra, hjelp, til);
        System.out.println(piece_nummer + " " + fra + "-" + til);
        hanoiMove(piece_nummer - 1, hjelp, til, fra);
    }
}
