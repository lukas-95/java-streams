package com.amigoscode.examples;

import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GettingStarted {

    @Test
    public void imperativeApproach() throws IOException {
        // 1. Find people aged less or equal 18
        // 2. Then change implementation to find first 10 people
        List<Person> people = MockData.getPeople();
        List<Person> youngers = new ArrayList<>();
        int total = 10;
        int count = 0;
        for (Person person : people) {
            if (person.getAge() <= 18) {
                youngers.add(person);
                count++;
                if (count == total) {
                    break;
                }
            }
        }
        for (Person person : youngers) {
            System.out.println(person);
        }
    }

    @Test
    public void declarativeApproachUsingStreams() throws Exception {
        List<Person> people = MockData.getPeople();
        List<Person> collected = people.stream().filter(person -> person.getAge() <= 18).limit(10).toList();
        collected.forEach(System.out::println);
    }
}
