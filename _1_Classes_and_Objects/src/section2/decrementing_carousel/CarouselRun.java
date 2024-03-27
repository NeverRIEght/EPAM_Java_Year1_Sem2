package com.epam.rd.autotasks;

import java.util.ArrayList;

public class CarouselRun {
    private final ArrayList<Integer> elements;
    private int currIndex;

    public CarouselRun(ArrayList<Integer> elements) {
        this.elements = elements;
        currIndex = 0;
    }

    public int next() {
        for (int i = 0; i < elements.size(); i++) {
            int roundedIndex = (i + currIndex) % elements.size();
            int currentElem = elements.get(roundedIndex);

            if(currentElem != 0) {
                currIndex = roundedIndex;
                elements.set(currIndex, currentElem - 1);
                currIndex = getNextIndex();

                return currentElem;
            }
        }

        return -1;
    }

    private int getNextIndex() {
        int index = currIndex;

        if (index + 1 < elements.size()) {
            index++;
        } else {
            index = 0;
        }

        return index;
    }

    public boolean isFinished() {
        for (Integer elem : elements) {
            if (elem != 0) {
                return false;
            }
        }

        return true;
    }

}
