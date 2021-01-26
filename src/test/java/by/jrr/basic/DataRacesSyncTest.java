package by.jrr.basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataRacesSyncTest {

    @Test
    void perform() throws InterruptedException {
        var dataRaces = new DataRacesSync();
        dataRaces.perform();
        Assertions.assertThat(dataRaces.perform())
                .isEqualTo(0);
    }
}
