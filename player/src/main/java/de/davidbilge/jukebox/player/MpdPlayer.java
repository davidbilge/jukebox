package de.davidbilge.jukebox.player;

import de.davidbilge.jukebox.player.command.UriPlayCommand;
import java.io.Closeable;
import java.util.Collection;
import org.bff.javampd.server.MPD;
import org.bff.javampd.song.MPDSong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MpdPlayer implements Player<UriPlayCommand>, Closeable {

    private static final Logger LOG = LoggerFactory.getLogger(MpdPlayer.class);

    private MPD mpd;

    @Override
    public void play(UriPlayCommand playCommand) {
        this.mpd = new MPD.Builder().server("192.168.0.38").build();

        Collection<String> playlistNames = mpd.getMusicDatabase().getPlaylistDatabase().listPlaylists();
        LOG.info("Found playlists: {}", playlistNames);

        Collection<String> allAlbumNames = mpd.getMusicDatabase().getAlbumDatabase().listAllAlbumNames();
        LOG.info("Found albums: {}", allAlbumNames);

        MPDSong song = new MPDSong("local:track:Kevin_MacLeod_-_04_-_DD_Groove.mp3", "Foobar");

        mpd.getPlaylist().clearPlaylist();
        // mpd.getPlaylist().addSong(song);
        // mpd.getPlaylist().loadPlaylist("Test");
        mpd.getPlaylist().insertAlbum("Blues Sampler");

        mpd.getPlayer().play();
    }

    @Override
    public void close() {
        if (mpd != null) {
            mpd.close();
        }
    }
}
