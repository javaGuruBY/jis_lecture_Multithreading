package by.jrr;

import by.jrr.basic.DeadLock;

public class App {

    public static void main(String[] args) {

        var deadLock = new DeadLock();
        deadLock.perform();
    }
}
