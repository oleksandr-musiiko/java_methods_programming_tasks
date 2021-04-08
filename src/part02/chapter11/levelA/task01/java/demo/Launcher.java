package part02.chapter11.levelA.task01.java.demo;

import part02.chapter11.levelA.task01.java.model.Port;
import part02.chapter11.levelA.task01.java.model.Ship;

import java.util.ArrayList;
import java.util.List;

public class Launcher {

    public static void main(String[] args) {
        Port port = new Port(5, 40000);
        port.start();
        int countOfShips = 0;
        while (true) {
            List<Ship> shipsForAdd = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                shipsForAdd.add(new Ship("UA" + countOfShips++));
            }
            port.addShipsToQueue(shipsForAdd);
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
