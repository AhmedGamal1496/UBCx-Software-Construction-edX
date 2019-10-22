package test;

import model.Animal;
import model.Zookeeper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest {
    private Animal animal1, animal2;
    private Zookeeper zookeeper1;

    @Before
    public void SetUp() {
        zookeeper1 = new Zookeeper("Jimbo", 23);

        animal1 = new Animal("Lion", "Egypt", 8, zookeeper1, 2020);
        animal2 = new Animal("Elephant", "Emirates", 2, zookeeper1, 250);
    }

    @Test
    public void testGetters() {
        assertEquals(animal1.getAge(), 8);
        assertEquals(animal1.getCountry(), "Egypt");
        assertEquals(animal1.getCareTaker(), zookeeper1);
        zookeeper1.addToList(animal1);
        assertEquals(zookeeper1.getAnimalList().size(), 1);
        zookeeper1.addToList(animal2);
        zookeeper1.setFavourite(animal2);
        assertEquals(zookeeper1.getFavourite(), animal2);
        zookeeper1.removeFromList(animal2);
        assertEquals(zookeeper1.getAnimalList().size(), 1);
    }

}
