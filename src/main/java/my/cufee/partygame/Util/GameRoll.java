package my.cufee.partygame.Util;

import my.cufee.partygame.Games.DigOrDie.DigOrDieGame;
import my.cufee.partygame.Games.Labyrinth.LabyrinthGame;

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
            //case 1: LabyrinthGame.startLabyrinth(); break;
            //case 1:
            //    TimerUtil.timeStartParkour();
            //    break;
            //case 1:
                //timeStartgr();
                //break;
            case 1: DigOrDieGame.startDigOrDie();break;
            //case 1:startParkour(); break;
        }
    }
}
