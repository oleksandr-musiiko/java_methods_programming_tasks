package part02.chapter11.levelA.task01.java.model;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Ship implements ContainerTransactional {

    private final String name;
    private final int capacityContainers;
    private final AtomicInteger loadStateOfContainers;

    public Ship(String name) {
        this.name = name;
        Random random = new Random();
        capacityContainers = 20 + random.nextInt(50);
        loadStateOfContainers = new AtomicInteger(random.nextInt(capacityContainers));
    }

    @Override
    public void addContainer() {
        if (isOpenToLoad()) {
            loadStateOfContainers.getAndIncrement();
        }
    }

    @Override
    public void getContainer() {
        if (isOpenToUnload()) {
            loadStateOfContainers.getAndDecrement();
        }
    }

    @Override
    public boolean isOpenToLoad() {
        return capacityContainers - loadStateOfContainers.get() > 0;
    }

    @Override
    public boolean isOpenToUnload() {
        return loadStateOfContainers.get() > 0;
    }

    public int getCapacityContainers() {
        return capacityContainers;
    }

    public int getLoadStateOfContainers() {
        return loadStateOfContainers.get();
    }

    @Override
    public String toString() {
        return "Ship-" +
                name + ", c=" + capacityContainers +
                ", l=" + loadStateOfContainers;
    }
}