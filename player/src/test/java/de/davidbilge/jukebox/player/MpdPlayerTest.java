package de.davidbilge.jukebox.player;

import org.junit.jupiter.api.Test;

public class MpdPlayerTest {

    @Test
    public void playFile() {
        try (MpdPlayer p = new MpdPlayer()) {
            p.play(null);
        }
    }

}
