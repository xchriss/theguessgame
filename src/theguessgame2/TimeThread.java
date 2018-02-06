/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theguessgame2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sütikutya
 */
public class TimeThread extends Thread {

    private int second;
    private boolean exit;
    
    public void exit() {
        this.exit = true;
    }
    
    public synchronized int getSecond() {
        return second;
    }
    
    @Override
    public void run() {
        synchronized(this) {
            second = 60;
        }
        try {
            do {
                Thread.sleep(1000);
                synchronized(this) {
                    second--;
                }
            } while (!exit);
        } catch (InterruptedException ex) {
        }
    }
    
}
