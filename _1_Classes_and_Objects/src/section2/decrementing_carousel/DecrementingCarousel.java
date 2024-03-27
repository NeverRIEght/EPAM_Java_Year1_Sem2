package com.epam.rd.autotasks;

import java.util.ArrayList;

public class DecrementingCarousel {

    private ArrayList<Integer> elements;

    private int capacity;

    private boolean isRun;

    public DecrementingCarousel(int capacity) {
        this.capacity = capacity;
        this.isRun = false;
        this.elements = new ArrayList<>(capacity);
    }

    public boolean addElement(int element) {
        if (element <= 0 || elements.size() >= capacity || isRun) {
            return false;
        } else {
            elements.add(element);
            return true;
        }
    }

    public CarouselRun run() {
        if(isRun) {
            return null;
        }

        this.isRun = true;
        return new CarouselRun(this.elements);
    }
}
