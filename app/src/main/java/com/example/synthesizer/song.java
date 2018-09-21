package com.example.synthesizer;

import java.util.ArrayList;
import java.util.List;

public class song {
    private List<Note> notes;

    public song() {
        notes = new ArrayList<>();
    }

    public song(List<Note> notes) {
        this.notes = notes;
    }

    public void add(Note note){
        notes.add(note);

    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "song{" +
                "notes=" + notes +
                '}';
    }
}
