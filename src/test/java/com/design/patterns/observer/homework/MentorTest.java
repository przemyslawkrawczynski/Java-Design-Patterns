package com.design.patterns.observer.homework;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MentorTest {

    @Test
    public void testUpdate() {
        //Given
        Queue user1 = new UserQueue("Jan Kowalski");
        Queue user2 = new UserQueue("Hubert Klepak");
        Queue user3 = new UserQueue("Paweł Dobromilski");
        Queue user4 = new UserQueue("Piotr Lesniak");

        Mentor mentor = new Mentor("John Kodilla");
        Mentor mentor2 = new Mentor("Zofia Haerowiec");

        user1.registerObserver(mentor);
        user2.registerObserver(mentor2);
        user3.registerObserver(mentor);
        user4.registerObserver(mentor2);

        //When
        user1.addExercise("1");
        user1.addExercise("2");
        user1.addExercise("3");

        user2.addExercise("1");
        user2.addExercise("2");

        user3.addExercise("1");
        user3.addExercise("2");
        user3.addExercise("3");

        user4.addExercise("1");
        user4.addExercise("2");

        int mentorExercises = mentor.howManyExerciseFromUser(user1) + mentor.howManyExerciseFromUser(user3);
        int mentor2Exercises = mentor2.howManyExerciseFromUser(user2) + mentor2.howManyExerciseFromUser(user4);

        //Then
        Assert.assertEquals(6, mentorExercises);
        Assert.assertEquals(4, mentor2Exercises);

    }

}