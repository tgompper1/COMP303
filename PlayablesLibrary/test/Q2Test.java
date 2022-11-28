import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;
class Q2Test {


    //redo tests

    @Test
    void testSingleRedoAfterUndo(){
        Song song1 = new Song("Mountain of the Sun", "Greta Van Fleet");
        PlayList Bangers = new PlayList("Bangers");
        Bangers.addPlayable(song1);
        PlayList expected = Bangers.clone();
        Bangers = Bangers.undo();
        Bangers = (PlayList) Bangers.redo();
        assertEquals(expected, Bangers);
    }

    @Test
    void testChainRedoAfterUndo(){
        Song song1 = new Song("Mountain of the Sun", "Greta Van Fleet");
        Song song2 = new Song("Talking on the Streets", "Greta Van Fleet");
        Song song3 = new Song("Curtain Falls", "Greta Van Fleet");
        PlayList Bangers = new PlayList("Bangers");
        Bangers.addPlayable(song1); // goal
        Bangers.addPlayable(song2);
        Bangers.addPlayable(song3);
        Bangers.removePlayable(1);
        Bangers.shuffle();
        Bangers.setName("not bangers");
        PlayList expected = Bangers.clone();
        Bangers = Bangers.undo();
        Bangers = Bangers.undo();
        Bangers = Bangers.undo();
        Bangers = Bangers.undo();
        Bangers = Bangers.undo();
        Bangers = (PlayList) Bangers.redo();
        Bangers = (PlayList) Bangers.redo();
        Bangers = (PlayList) Bangers.redo();
        Bangers = (PlayList) Bangers.redo();
        Bangers = (PlayList) Bangers.redo();
        assertEquals(expected, Bangers);
    }

    @Test
    void testSingleRedoAfterAdd(){
        Song song1 = new Song("Mountain of the Sun", "Greta Van Fleet");
        PlayList Bangers = new PlayList("Bangers");
        Bangers.addPlayable(song1);
        Bangers.redo();
        PlayList Bangers2 = new PlayList("Bangers");
        Bangers2.addPlayable(song1);
        Bangers2.addPlayable(song1);
        assertEquals(Bangers2, Bangers);
    }

    @Test
    void testMultipleRedoAfterAdd(){
        Song song1 = new Song("Mountain of the Sun", "Greta Van Fleet");
        PlayList Bangers = new PlayList("Bangers");
        Bangers.addPlayable(song1);
        Bangers.redo();
        Bangers.redo();
        Bangers.redo();
        PlayList Bangers2 = new PlayList("Bangers");
        Bangers2.addPlayable(song1);
        Bangers2.addPlayable(song1);
        Bangers2.addPlayable(song1);
        Bangers2.addPlayable(song1);
        assertEquals(Bangers2, Bangers);
    }

    @Test
    void testSingleRedoAfterRemove(){
        Song song1 = new Song("Mountain of the Sun", "Greta Van Fleet");
        Song song2 = new Song("Curtain Falls", "Greta Van Fleet");
        PlayList Bangers = new PlayList("Bangers");
        Bangers.addPlayable(song1);
        Bangers.addPlayable(song2);
        Bangers.removePlayable(0);
        Bangers.redo();
        PlayList Bangers2 = new PlayList("Bangers");
        assertEquals(Bangers2, Bangers);
    }

    @Test
    void testMultipleRedoAfterRemove(){
        Song song1 = new Song("Mountain of the Sun", "Greta Van Fleet");
        Song song2 = new Song("Curtain Falls", "Greta Van Fleet");
        Song song3 = new Song("Curtain Falls", "Greta Van Fleet");
        PlayList Bangers = new PlayList("Bangers");
        Bangers.addPlayable(song1);
        Bangers.addPlayable(song2);
        Bangers.addPlayable(song3);
        Bangers.removePlayable(0);
        Bangers.redo();
        Bangers.redo();
        PlayList Bangers2 = new PlayList("Bangers");
        assertEquals(Bangers2, Bangers);
    }

    @Test
    void testSingleRedoAfterShuffle(){
        Song song1 = new Song("Mountain of the Sun", "Greta Van Fleet");
        Song song2 = new Song("Curtain Falls", "Greta Van Fleet");
        Song song3 = new Song("Curtain Falls", "Greta Van Fleet");
        PlayList Bangers = new PlayList("Bangers");
        Bangers.addPlayable(song1);
        Bangers.addPlayable(song2);
        Bangers.addPlayable(song3);
        Bangers.addPlayable(song1);
        Bangers.addPlayable(song2);
        Bangers.addPlayable(song3);
        Bangers.shuffle();
        PlayList Bangers2 = Bangers.clone();
        Bangers.redo();
        assertNotEquals(Bangers2, Bangers);
    }

    /*@Test
    void testMultipleRedoAfterShuffle(){
// not necessary?
    }*/

    @Test
    void testSingleRedoAfterSetName(){
        PlayList Bangers = new PlayList("Bangers");
        Bangers.setName("newBangers");
        PlayList expected = Bangers.clone();
        Bangers.redo();
        assertEquals(expected, Bangers);
    }

    @Test
    void testMultipleRedoAfterSetName(){
        PlayList Bangers = new PlayList("Bangers");
        Bangers.setName("newBangers");
        PlayList expected = Bangers.clone();
        Bangers.redo();
        Bangers.redo();
        Bangers.redo();
        assertEquals(expected, Bangers);
    }

    @Test
    void testRedoAfterNothing(){
        PlayList Bangers = new PlayList("Bangers");
        try{
            Bangers.redo(); // should do nothing
        }
        catch(IndexOutOfBoundsException e){
            fail();
        }
    }


    //Undo tests

    @Test
    void testChainUndo(){
        Song song1 = new Song("Mountain of the Sun", "Greta Van Fleet");
        Song song2 = new Song("Talking on the Streets", "Greta Van Fleet");
        Song song3 = new Song("Curtain Falls", "Greta Van Fleet");
        PlayList Bangers = new PlayList("Bangers");
        Bangers.addPlayable(song1); // goal
        PlayList desiredPlaylist = Bangers.clone();
        Bangers.addPlayable(song2);
        Bangers.addPlayable(song3);
        Bangers.removePlayable(1);
        Bangers.shuffle();
        Bangers.setName("not bangers");
        Bangers = Bangers.undo();
        Bangers = Bangers.undo();
        Bangers = Bangers.undo();
        Bangers = Bangers.undo();
        Bangers = Bangers.undo();
        assertEquals(desiredPlaylist, Bangers);
    }

    @Test
    void testUndoAfterAdd(){
        Song song1 = new Song("Mountain of the Sun", "Greta Van Fleet");
        PlayList Bangers = new PlayList("Bangers");
        PlayList expected = Bangers.clone();
        Bangers.addPlayable(song1);
        Bangers = Bangers.undo();
        assertEquals(expected, Bangers);
    }

    @Test
    void testUndoAfterRemove(){
        Song song1 = new Song("Mountain of the Sun", "Greta Van Fleet");
        Song song2 = new Song("Talking on the Streets", "Greta Van Fleet");
        PlayList Bangers = new PlayList("Bangers");
        Bangers.addPlayable(song1);
        Bangers.addPlayable(song2);
        PlayList prevPlaylist = Bangers.clone();
        Bangers.removePlayable(1);
        Bangers = Bangers.undo();
        assertEquals(prevPlaylist, Bangers);
    }

    @Test
    void testUndoAfterShuffle(){
        Song song1 = new Song("Mountain of the Sun", "Greta Van Fleet");
        Song song2 = new Song("Talking on the Streets", "Greta Van Fleet");
        Song song3 = new Song("Curtain Falls", "Greta Van Fleet");
        PlayList Bangers = new PlayList("Bangers");
        Bangers.addPlayable(song1);
        Bangers.addPlayable(song2);
        Bangers.addPlayable(song3);
        PlayList prevPlaylist = Bangers.clone();
        Bangers.shuffle();
        Bangers = Bangers.undo();
        assertEquals(prevPlaylist, Bangers);
    }

    @Test
    void testUndoAfterSetName(){
        Song song1 = new Song("Mountain of the Sun", "Greta Van Fleet");
        PlayList Bangers = new PlayList("Bangers");
        Bangers.addPlayable(song1);
        PlayList prevPlaylist = Bangers.clone();
        Bangers.setName("Bangers 2");
        Bangers = Bangers.undo();
        assertEquals(prevPlaylist, Bangers);
    }

    @Test
    void testUndoAfterNothing(){
        PlayList Bangers = new PlayList("Bangers");
        try{
            Bangers.undo(); // should do nothing
        }
        catch(IndexOutOfBoundsException e){
            fail();
        }
    }


    //combinations

    @Test
    void testMethodUndoRedoRedo(){
        Song song1 = new Song("Mountain of the Sun", "Greta Van Fleet");
        PlayList Bangers = new PlayList("Bangers");
        Bangers.addPlayable(song1);
        PlayList expected = Bangers.clone();
        Bangers = Bangers.undo();
        Bangers = (PlayList) Bangers.redo();
        Bangers = (PlayList) Bangers.redo();
        assertEquals(expected, Bangers);
    }

    @Test
    void testMethod1UndoMethod2redoredo(){
        Song song1 = new Song("Mountain of the Sun", "Greta Van Fleet");
        Song song2 = new Song("Talking on the Streets", "Greta Van Fleet");
        Song song3 = new Song("Curtain Falls", "Greta Van Fleet");
        PlayList Bangers = new PlayList("Bangers");
        Bangers.addPlayable(song1);
        Bangers.addPlayable(song2); // method 1
        Bangers = Bangers.undo();
        Bangers.addPlayable(song3); // method 2
        Bangers.redo();
        Bangers.redo();

        PlayList expected = new PlayList("Bangers");
        expected.addPlayable(song1);
        expected.addPlayable(song3);
        expected.addPlayable(song3);
        expected.addPlayable(song3);
        assertEquals(expected, Bangers);

    }

    @Test
    void testMethod1Method2UndoUndoRedoRedo(){
        Song song1 = new Song("Mountain of the Sun", "Greta Van Fleet");
        Song song2 = new Song("Talking on the Streets", "Greta Van Fleet");
        PlayList Bangers = new PlayList("Bangers");
        Bangers.addPlayable(song2);
        PlayList expected = Bangers.clone();
        Bangers.addPlayable(song1); // method 1
        Bangers.removePlayable(1); //method 2
        Bangers = Bangers.undo();
        Bangers = Bangers.undo();
        Bangers.redo();
        Bangers.redo();
        assertEquals(expected, Bangers);
    }

    @Test
    void testMethodRedoRedoUndoUndo(){
        Song song1 = new Song("Mountain of the Sun", "Greta Van Fleet");
        PlayList Bangers = new PlayList("Bangers");
        Bangers.addPlayable(song1);
        PlayList expected = Bangers.clone();
        Bangers = (PlayList) Bangers.redo();
        Bangers = (PlayList)Bangers.redo();
        Bangers = Bangers.undo();
        Bangers = Bangers.undo();
        assertEquals(expected, Bangers);
    }
}
