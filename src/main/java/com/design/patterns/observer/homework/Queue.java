package com.design.patterns.observer.homework;


import java.util.ArrayList;
import java.util.List;

public class Queue implements ObservableQueue {

    private final String name;
    private List<ObserverQueue> mentors;
    private List<String> exercises;

    public Queue(String name) {
        this.name = name;
        this.mentors = new ArrayList<>();
        this.exercises = new ArrayList<>();
    }

    public void addExercise(String exercise) {
        exercises.add(exercise);
        notifyObservers(exercise);
    }

    @Override
    public void registerObserver(ObserverQueue mentor) {
        mentors.add(mentor);
    }

    @Override
    public void notifyObservers(String exercise) {
        for(ObserverQueue mentor: mentors) {
            mentor.update(this, exercise);
        }
    }

    @Override
    public void removeObserver(ObserverQueue mentor) {
        mentors.remove(mentor);
    }

    public String getName() {
        return name;
    }

    public List<ObserverQueue> getMentors() {
        return mentors;
    }
}
