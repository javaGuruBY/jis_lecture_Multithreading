package by.jrr.basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataRacesVolotileTest {

    @Test//not proving colotile
    void perform() throws InterruptedException {
        var dataRaces = new DataRacesVolotile();
        dataRaces.perform();
        Assertions.assertThat(dataRaces.perform())
                .isEqualTo(0);
    }
}
