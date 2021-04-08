package part02.chapter11.levelA.task01.java.model;

public class Pier {

    private volatile Port port;
    private final int pierNumber;
    private volatile Ship ship = null;

    public Pier(Port port, int pierNumber) {
        this.port = port;
        this.pierNumber = pierNumber;
    }

    public void startTransactionWithShip(int countForLoad, int countForUnload) {
        final Pier PIER = this;
        new Thread(new Runnable() {
            int tempCountForLoad = countForLoad;
            int tempCountForUnload = countForUnload;

            @Override
            public void run() {
                while (tempCountForLoad > 0 || tempCountForUnload > 0) {
                    if (tempCountForLoad > 0 && ship.isOpenToLoad() && port.isOpenToUnload()) {
                        port.getContainer();
                        ship.addContainer();
                        tempCountForLoad--;
                        System.out.println(PIER + "\n" + ship + "\n" + port + "\nloaded one container, forLoad = " + tempCountForLoad + ", forUnload = " + tempCountForUnload +
                                "\n_____________________");
                    }
                    if (tempCountForUnload > 0 && ship.isOpenToUnload() && port.isOpenToLoad()) {
                        ship.getContainer();
                        port.addContainer();
                        tempCountForUnload--;
                        System.out.println(PIER + "\n" + ship + "\n" + port + "\nunloaded one container, forLoad = " + tempCountForLoad + ", forUnload = " + tempCountForUnload +
                                "\n_____________________");
                    }
                }
                vacate();
            }
        }).start();
    }

    public void acceptShip(Ship ship) {
        if (isEmpty()) {
            this.ship = ship;
            port.fillOnePier();
            System.out.println(ship + " arrived to the pier #" + pierNumber + "\n" + port + "\n_____________________");
        }
    }

    public void vacate() {
        String result = this.ship.toString();
        if (!isEmpty()) {
            this.ship = null;
        }
        port.addEmptyPier();
        System.out.println(result + " left from the pier #" + pierNumber + "\n" + port + "\n_____________________");
    }

    public boolean isEmpty() {
        return ship == null;
    }

    @Override
    public String toString() {
        return "Pier#" +
                pierNumber;
    }
}