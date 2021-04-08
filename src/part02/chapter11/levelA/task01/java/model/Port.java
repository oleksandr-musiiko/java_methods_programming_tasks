package part02.chapter11.levelA.task01.java.model;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Port extends Thread implements ContainerTransactional {

    private final int maxContainersCapacity;
    private final AtomicInteger currentCountOfContainers;
    private final List<Pier> piers;
    private final AtomicInteger countOfEmptyPiers;
    private volatile Queue<Ship> shipsQueue;
    private final Random random;
    private final ReentrantLock reentrantLock;

    public Port(int countOfPiers, int maxContainersCapacity) {
        random = new Random();
        shipsQueue = new LinkedList<>();
        this.maxContainersCapacity = maxContainersCapacity;
        currentCountOfContainers = new AtomicInteger(random.nextInt(maxContainersCapacity + 1));
        piers = generatePiers(countOfPiers);
        countOfEmptyPiers = new AtomicInteger(piers.size());
        reentrantLock = new ReentrantLock();
    }

    @Override
    public void run() {
        while (true) {
            if (isInterrupted()) {
                return;
            }
            if (!shipsQueue.isEmpty() && countOfEmptyPiers.get() > 0) {
                serviceShip(shipsQueue.poll());
                printStatus();
            }
        }
    }

    @Override
    public void addContainer() {
        if (isOpenToLoad()) {
            currentCountOfContainers.getAndIncrement();
        }
    }

    @Override
    public void getContainer() {
        if (isOpenToUnload()) {
            currentCountOfContainers.getAndDecrement();
        }
    }

    @Override
    public boolean isOpenToLoad() {
        return maxContainersCapacity - currentCountOfContainers.get() > 0;
    }

    @Override
    public boolean isOpenToUnload() {
        return currentCountOfContainers.get() > 0;
    }

    public void addShipsToQueue(List<Ship> shipsForAdd) {
        shipsQueue.addAll(shipsForAdd);
    }

    public void addEmptyPier() {
        countOfEmptyPiers.getAndIncrement();
    }

    public void fillOnePier() {
        countOfEmptyPiers.getAndDecrement();
    }

    private List<Pier> generatePiers(int countOfPiers) {
        List<Pier> result = new ArrayList<>();
        for (int i = 0; i < countOfPiers; i++) {
            result.add(new Pier(this, i));
        }
        return Collections.unmodifiableList(result);
    }

    private void serviceShip(Ship ship) {
        reentrantLock.lock();
        Pier pier = getFirstEmptyPier();
        performActionForShip(pier, ship);
        reentrantLock.unlock();
    }

    private Pier getFirstEmptyPier() {
        for (Pier pier : piers) {
            if (pier.isEmpty()) {
                return pier;
            }
        }
        return null;
    }

    private void performActionForShip(Pier pier, Ship ship) {
        switch (generateActionForShip()) {
            case LOAD: {
                int forLoad = random.nextInt(ship.getCapacityContainers() - ship.getLoadStateOfContainers() + 1);
                pier.acceptShip(ship);
                pier.startTransactionWithShip(forLoad, 0);
                break;
            }
            case UNLOAD: {
                int forUnload = random.nextInt(1 + ship.getLoadStateOfContainers());
                pier.acceptShip(ship);
                pier.startTransactionWithShip(0, forUnload);
                break;
            }
            case LOAD_AND_UNLOAD: {
                int forUnLoad = random.nextInt(1 + ship.getLoadStateOfContainers());
                int forLoad = random.nextInt(1 + ship.getCapacityContainers() - (ship.getLoadStateOfContainers() - forUnLoad));
                pier.acceptShip(ship);
                pier.startTransactionWithShip(forLoad, forUnLoad);
                break;
            }
        }
    }

    private ActionsWithShip generateActionForShip() {
        switch (random.nextInt(3)) {
            case 0: {
                return ActionsWithShip.LOAD;
            }
            case 1: {
                return ActionsWithShip.UNLOAD;
            }
            case 2: {
                return ActionsWithShip.LOAD_AND_UNLOAD;
            }
            default: {
                throw new IllegalStateException();
            }
        }
    }

    private void printStatus() {
        System.out.println("\n_____________________\n" + this + "\n_____________________");
    }

    @Override
    public String toString() {
        return "Port{" +
                "mC=" + maxContainersCapacity +
                ", curC=" + currentCountOfContainers +
                ", emptyPiers=" + countOfEmptyPiers +
                '}';
    }
}