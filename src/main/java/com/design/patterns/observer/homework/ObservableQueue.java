package com.design.patterns.observer.homework;

public interface ObservableQueue {
    void registerObserver(ObserverQueue observer);
    void notifyObservers(String excercises);
    void removeObserver(ObserverQueue observer);
}
