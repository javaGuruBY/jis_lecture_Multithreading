package by.jrr.basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class DataRacesAtomicTest {

    @Test
    void perform() throws InterruptedException {
        var dataRaces = new DataRacesAtomic();
        dataRaces.perform();
        Assertions.assertThat(dataRaces.perform().get())
                .isEqualTo(0);
    }
}
