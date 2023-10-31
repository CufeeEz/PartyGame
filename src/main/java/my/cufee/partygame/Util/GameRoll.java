package my.cufee.partygame.Util;

import my.cufee.partygame.Games.BedrockBox.BedrockGame;
import my.cufee.partygame.Games.DigOrDie.DigOrDieGame;
import my.cufee.partygame.Games.PlayersScore;

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
        PlayersScore.CountPoint = 5;
        int num = rollGame();
        switch (num){
            //case 1: LabyrinthGame.startLabyrinth(); break;
            //case 1: TimerUtil.timeStartParkour();break;
            //case 1: timeStartgr();break;
            //case 1: DigOrDieGame.startDigOrDie();break;
            //case 1: startParkour(); break;
            case 1: BedrockGame.startGame();break;
        }
    }
}
