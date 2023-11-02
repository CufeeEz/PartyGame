package my.cufee.partygame.Util;

import my.cufee.partygame.Games.BedrockBox.BedrockGame;
import my.cufee.partygame.Games.BowBattle.BowBattleGame;
import my.cufee.partygame.Games.BowBattle.BowBattleLocation;
import my.cufee.partygame.Games.DigOrDie.DigOrDieGame;
import my.cufee.partygame.Games.PlayersScore;

import java.util.Random;

import static my.cufee.partygame.Games.Parkour.ParkourGame.startParkour;
import static my.cufee.partygame.Util.TimerUtil.timeStartgr;


public class GameRoll {
    public static int rollGame(){
        Random random = new Random();
        int randomNumber = random.nextInt(4) + 1;
        return randomNumber;
    }
    public static void beginGame(){
        PlayersScore.CountPoint = 5;
        int num = rollGame();
        switch (num){
            case 1: BowBattleGame.bowBattleStart();
            //case 1: LabyrinthGame.startLabyrinth(); break;
            //case 1: timeStartgr();break;
            //case 2: DigOrDieGame.startDigOrDie();break;
            //case 3: startParkour(); break;
            //case 4: BedrockGame.startGame();break;
        }
    }
}
