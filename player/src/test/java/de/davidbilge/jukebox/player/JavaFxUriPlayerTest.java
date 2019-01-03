package de.davidbilge.jukebox.player;

import de.davidbilge.jukebox.player.command.UriPlayCommand;
import java.net.URI;
import java.net.URISyntaxException;
import javafx.application.Platform;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaFxUriPlayerTest {

    private static final Logger LOG = LoggerFactory.getLogger(JavaFxUriPlayerTest.class);

    @Test
    public void play() throws InterruptedException {
        Platform.startup(() -> {
            LOG.info("Started JavaFX platform");
        });

        try (JavaFxUriPlayer player = new JavaFxUriPlayer()) {
            player.play(new UriPlayCommand() {
                @Override
                public URI getUri() {
                    try {
                        return JavaFxUriPlayerTest.class.getResource("demo.mp3").toURI();
                    } catch (URISyntaxException e) {
                        throw new RuntimeException("Unable to construct URI", e);
                    }
                }
            });

            LOG.info("Started playback");
            for (int i = 0; i < 5; ++i) {
                Thread.sleep(500);
                LOG.info("current status is {}", player.getStatus());
            }
        } finally {
            Platform.exit();
        }

        LOG.info("Finish");
    }

}
