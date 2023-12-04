package race;



import entity.Race;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.race.RaceDetailsInteractor;

import static org.junit.jupiter.api.Assertions.*;

class RaceDetailsInteractorTest {

    private RaceDetailsInteractor raceDetailsInteractor;

    @BeforeEach
    void setUp() {
        raceDetailsInteractor = new RaceDetailsInteractor();
    }

    @Test
    void testGetRaceDetailsSuccessful() {
        // Test with a valid race name known to return a successful response
        String validRaceName = "human"; // Assuming 'human' is a valid race in the D&D API
        Race race = raceDetailsInteractor.getRaceDetails(validRaceName);

        assertNotNull(race, "Race object should not be null for a valid race name");
        assertEquals("Human", race.getName(), "Name should match the expected race name");
        // Additional assertions for other race attributes
    }


}
