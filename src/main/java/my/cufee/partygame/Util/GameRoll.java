package my.cufee.partygame.Util;

import my.cufee.partygame.Games.DigOrDie.DigOrDieGame;
import org.bukkit.Bukkit;

import java.util.Random;

import static my.cufee.partygame.Util.TimerUtil.timeStartgr;

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
            case 1:
                TimerUtil.timeStartParkour();
                break;
            //case 1:
                //timeStartgr();
                //break;
            //case 2: DigOrDieGame.startDigOrDie();break;
        }
    }
}
