package game;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;



class PlayerTest {

    Logger logger = LoggerFactory.getLogger(PlayerTest.class);

    @Test
    void doMobai() {
        logger.info("info");
        logger.debug("debug");
    }
}