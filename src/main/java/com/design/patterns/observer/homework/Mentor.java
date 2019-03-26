package com.design.patterns.observer.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Mentor implements ObserverQueue {

    private final String name;
    private int excercisesToCheck;
    private HashMap<Queue, List<String>> board = new HashMap<>();

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void update(Queue queue, String exercise) {
         System.out.println(queue.getName() + " - send exercise to check - [" + exercise + "].");
         if (board.containsKey(queue)) {
             board.get(queue).add(exercise);
         } else {
             board.put(queue, new ArrayList<>());
             board.get(queue).add(exercise);
         }
    }

    public int howManyExerciseFromUser(Queue queue) {
        return board.get(queue).size();
    }
}
