package de.davidbilge.jukebox.player.command;

import java.net.URI;

public interface UriPlayCommand extends PlayCommand {
    URI getUri();
}
