package de.davidbilge.jukebox.player;

import de.davidbilge.jukebox.player.command.UriPlayCommand;
import java.io.Closeable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class JavaFxUriPlayer implements Player<UriPlayCommand>, Closeable {

    private MediaPlayer currentPlayback;

    @Override
    public void play(UriPlayCommand playCommand) {
        Media media = new Media(playCommand.getUri().toString());
        this.currentPlayback = new MediaPlayer(media);
        currentPlayback.play();
    }

    public String getStatus() {
        if (currentPlayback == null) {
            return "Not playing";
        }

        return currentPlayback.getStatus().name();
    }

    @Override
    public void close() {
        if (currentPlayback == null) {
            return;
        }

        currentPlayback.dispose();
        currentPlayback = null;
    }
}
