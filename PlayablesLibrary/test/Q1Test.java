import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;


class Q1Test {


    @BeforeEach
    void resetLibrary() throws NoSuchFieldException, IllegalAccessException {
        Field instance = Library.class.getDeclaredField("INSTANCE");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    @Test
    void testDefaultPlayableSongWithDescription() throws NoSuchFieldException {
        Song song1 = new Song("A Team", "Ed Sheeran");
        Library.createLibrary("My Library ", " English", song1);
        Library myLib = Library.getLibrary();

        Playable defaultPlayable =  myLib.getDefaultPlayable();
        Field libDefault = myLib.getClass().getDeclaredField("aDefaultPlayable");
        libDefault.setAccessible(true);
        assertEquals(defaultPlayable, myLib.aDefaultPlayable);
        assertEquals(song1, myLib.aDefaultPlayable);
    }

    @Test
    void testDefaultPlayableSongWithOutDescription() throws NoSuchFieldException {
        Song song1 = new Song("A Team", "Ed Sheeran");
        Library.createLibrary("My Library", song1);
        Library myLib = Library.getLibrary();

        Playable defaultPlayable =  myLib.getDefaultPlayable();
        Field libDefault = myLib.getClass().getDeclaredField("aDefaultPlayable");
        libDefault.setAccessible(true);
        assertEquals(defaultPlayable, myLib.aDefaultPlayable);
        assertEquals(song1, myLib.aDefaultPlayable);
    }

    @Test
    void testDefaultPlayablePlayListWithDescription() throws NoSuchFieldException {
        PlayList playlist1 = new PlayList("playlist1");
        Library.createLibrary("My Library", "English", playlist1);
        Library myLib = Library.getLibrary();

        Playable defaultPlayable =  myLib.getDefaultPlayable();
        Field libDefault = myLib.getClass().getDeclaredField("aDefaultPlayable");
        libDefault.setAccessible(true);
        assertEquals(defaultPlayable, myLib.aDefaultPlayable);
        assertEquals(playlist1, myLib.aDefaultPlayable);
    }

    @Test
    void testDefaultPlayablePlayListWithOutDescription() throws NoSuchFieldException {
        PlayList playlist1 = new PlayList("playlist1");
        Library.createLibrary("My Library", playlist1);
        Library myLib = Library.getLibrary();

        Playable defaultPlayable = myLib.getDefaultPlayable();
        Field libDefault = myLib.getClass().getDeclaredField("aDefaultPlayable");
        libDefault.setAccessible(true);
        assertEquals(defaultPlayable, myLib.aDefaultPlayable);
        assertEquals(playlist1, myLib.aDefaultPlayable);
    }

    @Test
    void testDefaultPlayableEpisodeWithDescription() throws NoSuchFieldException {
        Podcast myPodcast = new Podcast("NPR", "host");
        Podcast.Episode e1  = myPodcast.createAndAddEpisode("pilot");
        Library.createLibrary("My Library", "English", e1);
        Library myLib = Library.getLibrary();

        Playable defaultPlayable =  myLib.getDefaultPlayable();
        Field libDefault = myLib.getClass().getDeclaredField("aDefaultPlayable");
        libDefault.setAccessible(true);
        assertEquals(defaultPlayable, myLib.aDefaultPlayable);
        assertEquals(e1, myLib.aDefaultPlayable);
    }

    @Test
    void testDefaultPlayableEpisodeWithOutDescription() throws NoSuchFieldException {
        Podcast myPodcast = new Podcast("NPR", "host");
        Podcast.Episode e1  = myPodcast.createAndAddEpisode("pilot");
        Library.createLibrary("My Library",  e1);
        Library myLib = Library.getLibrary();

        Playable defaultPlayable =  myLib.getDefaultPlayable();
        Field libDefault = myLib.getClass().getDeclaredField("aDefaultPlayable");
        libDefault.setAccessible(true);
        assertEquals(defaultPlayable, myLib.aDefaultPlayable);
        assertEquals(e1, myLib.aDefaultPlayable);
    }

    @Test
    void testDefaultPlayableDefaultUnspecifiedWithDescription() throws NoSuchFieldException {
        Library.createLibrary("My Library", "English");
        Library myLib = Library.getLibrary();

        Playable defaultPlayable =  myLib.getDefaultPlayable();
        Field libDefault = myLib.getClass().getDeclaredField("aDefaultPlayable");
        libDefault.setAccessible(true);
        assertEquals(defaultPlayable, myLib.aDefaultPlayable);
    }

    @Test
    void testDefaultPlayableDefaultUnspecifiedWithOutDescription() throws NoSuchFieldException {
        Library.createLibrary("My Library");
        Library myLib = Library.getLibrary();

        Playable defaultPlayable =  myLib.getDefaultPlayable();
        Field libDefault = myLib.getClass().getDeclaredField("aDefaultPlayable");
        libDefault.setAccessible(true);
        assertEquals(defaultPlayable, myLib.aDefaultPlayable);
    }
}