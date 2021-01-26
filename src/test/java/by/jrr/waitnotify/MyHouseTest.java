package by.jrr.waitnotify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHouseTest {

    MyHouse myHouse;

    @BeforeEach
    public void setUp() {
        myHouse = new MyHouse();
    }

    @Test
    void nevrotic() throws InterruptedException {
        myHouse.nevrotic();
    }

    @Test
    void normal() throws InterruptedException {
        myHouse.normal();
    }
}
