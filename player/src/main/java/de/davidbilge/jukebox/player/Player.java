package de.davidbilge.jukebox.player;

import de.davidbilge.jukebox.player.command.PlayCommand;

public interface Player<C extends PlayCommand> {

    void play(C playCommand);
}
