package com.example.synthesizer;

public class Note {
    private int noteID;
    private int delay;
    //public static final int WHOLE_NOTE = 1000;

    public Note(int noteID) {
        this.noteID = noteID;
        delay = 1000;
    }

    public Note(int noteID, int deley) {
        this.noteID = noteID;
        this.delay = deley;
    }

    public int getNoteID() {
        return noteID;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int deley) {
        this.delay = deley;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteID=" + noteID +
                ", delay=" + delay +
                '}';
    }
}
