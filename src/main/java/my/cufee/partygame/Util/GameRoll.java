package my.cufee.partygame.Util;

import my.cufee.partygame.Games.DigOrDie.DigOrDieGame;

import java.util.Random;

public class GameRoll {
    //1 - GoldRush
    //2 - DigOrDie
    Random random = new Random();
    public static int rollGame(){
        Random random = new Random();
        int randomNumber = random.nextInt(1) + 1;
        return randomNumber;
    }
    public static void beginGame(){
        int num = rollGame();
        switch (num){
            case 1: TimerUtil.timeStartGame();break;
            //case 2: DigOrDieGame.startDigOrDie();break;
        }
    }
}
