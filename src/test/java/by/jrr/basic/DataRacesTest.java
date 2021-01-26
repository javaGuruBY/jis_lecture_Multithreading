package by.jrr.basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DataRacesTest {

    @Test
    void perform() throws InterruptedException {
        var dataRaces = new DataRaces();
        dataRaces.perform();
        Assertions.assertThat(dataRaces.perform())
                .isEqualTo(0);
    }
}
