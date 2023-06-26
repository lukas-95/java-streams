package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.beans.PersonDTO;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class TransformationsMapAndReduce {

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();
        List<PersonDTO> dtos = people.stream()
                .filter(person -> person.getAge() > 63)
                .map(person -> new PersonDTO(
                        person.getId(),
                        person.getFirstName(),
                        person.getAge()))
                .collect(Collectors.toList());
        //assertThat(people.size()).isEqualTo(dtos.size());
        dtos.forEach(System.out::println);
    }

    @Test
    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();

        double average = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);
        System.out.println(average);

    }

    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
    }
}

