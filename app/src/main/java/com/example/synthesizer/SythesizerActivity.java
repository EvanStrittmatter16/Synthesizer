package com.example.synthesizer;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SythesizerActivity extends AppCompatActivity implements View.OnClickListener {

    private final int WHOLE_NOTE = 1500;
    private int repeat = 3;
    private int ChTwoNote = 0;

    private Button buttonA;
    private Button buttonBb;
    private Button buttonB;
    private Button buttonC;
    private Button buttonCs;
    private Button buttonD;
    private Button buttonDs;
    private Button buttonE;
    private Button buttonF;
    private Button buttonFs;
    private Button buttonG;
    private Button buttonGs;
    private Button buttonHd;
    private Button buttonHb;
    private Button buttonHa;
    private Button buttonHc;
    private SoundPool soundpool;
    private int noteA;
    private int noteB;
    private int noteBb;
    private int noteC;
    private int noteCs;
    private int noteD;
    private int noteDs;
    private int noteE;
    private int noteF;
    private int noteFs;
    private int noteG;
    private int noteGs;
    private int noteHa;
    private int noteHd;
    private int noteHb;
    private int noteHc;

    private Map<Integer, Integer> noteMap;

    public static final float DEFAULT_VOLUME = 1.0f;
    public static final float DEFAULT_RATE = 1.0f;
    public static final int DEFAULT_PRIORITY = 1;

    private Button buttonAllNotes;
    private Button buttonChTwo;
    private Button buttonlowEtohighE;
    private Button buttontwinkle;
    private Button buttontwinkletwo;
    private Button buttonHappyBirthday;
    private Button buttonDespacito;
    private Button buttonFortnite;

    private NumberPicker numberPickerchtwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sythesizer);

        wireWidgets();
        setListeners();
        initializeSoundPool();
        initializeNoteMap();
        initializeNumberPickers();
    }

    private void initializeNumberPickers() {
        numberPickerchtwo.setMaxValue(10);
        numberPickerchtwo.setMinValue(1);

    }

    private void initializeNoteMap() {
        noteMap = new HashMap<>();
        noteMap.put(R.id.button_synth_a, noteA);
        noteMap.put(R.id.button_synth_bb, noteBb);
        noteMap.put(R.id.button_synth_b, noteB);
        noteMap.put(R.id.button_synth_c, noteC);
        noteMap.put(R.id.button_synth_cs, noteCs);
        noteMap.put(R.id.button_synth_d, noteD);
        noteMap.put(R.id.button_synth_ds, noteDs);
        noteMap.put(R.id.button_synth_e, noteE);
        noteMap.put(R.id.button_synth_f, noteF);
        noteMap.put(R.id.button_synth_fs, noteFs);
        noteMap.put(R.id.button_synth_g, noteG);
        noteMap.put(R.id.button_synth_gs, noteGs);
        noteMap.put(R.id.button_synth_ha, noteHa);
        noteMap.put(R.id.button_synth_hb, noteHb);
        noteMap.put(R.id.button_synth_hd, noteHd);
        noteMap.put(R.id.button_synth_hc, noteHc);
    }

    private void initializeSoundPool() {
        soundpool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        noteA = soundpool.load(this, R.raw.scalea, 1);
        noteB = soundpool.load(this, R.raw.scaleb, 1);
        noteBb = soundpool.load(this, R.raw.scalebb, 1);
        noteC = soundpool.load(this, R.raw.scalec, 1);
        noteCs = soundpool.load(this, R.raw.scalecs, 1);
        noteD = soundpool.load(this, R.raw.scaled, 1);
        noteDs = soundpool.load(this, R.raw.scaleds, 1);
        noteE = soundpool.load(this, R.raw.scalee, 1);
        noteF = soundpool.load(this, R.raw.scalef, 1);
        noteFs = soundpool.load(this, R.raw.scalefs, 1);
        noteG = soundpool.load(this, R.raw.scaleg, 1);
        noteGs = soundpool.load(this, R.raw.scalegs, 1);
        noteHa = soundpool.load(this, R.raw.scalehigha, 1);
        noteHb = soundpool.load(this, R.raw.scalehighb, 1);
        noteHd = soundpool.load(this, R.raw.scalehighd, 1);
        noteHc = soundpool.load(this, R.raw.scalehighc, 1);
    }

    private void setListeners() {
        keyboardNoteListener noteListener = new keyboardNoteListener();

        buttonA.setOnClickListener(this);
        buttonBb.setOnClickListener(this);
        buttonB.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonCs.setOnClickListener(this);
        buttonD.setOnClickListener(this);
        buttonDs.setOnClickListener(this);
        buttonE.setOnClickListener(this);
        buttonF.setOnClickListener(this);
        buttonFs.setOnClickListener(this);
        buttonGs.setOnClickListener(this);
        buttonG.setOnClickListener(this);
        buttonHa.setOnClickListener(this);
        buttonHd.setOnClickListener(this);
        buttonHd.setOnClickListener(this);
        buttonHc.setOnClickListener(this);

        buttonAllNotes.setOnClickListener(this);
        buttonlowEtohighE.setOnClickListener(this);
        buttontwinkle.setOnClickListener(this);
        buttontwinkletwo.setOnClickListener(this);
        buttonHappyBirthday.setOnClickListener(this);
        buttonChTwo.setOnClickListener(this);
        buttonDespacito.setOnClickListener(this);
        buttonFortnite.setOnClickListener(this);

        numberPickerchtwo.setOnClickListener(this);
    }

    private void wireWidgets() {
        buttonA = findViewById(R.id.button_synth_a);
        buttonB = findViewById(R.id.button_synth_b);
        buttonBb = findViewById(R.id.button_synth_bb);
        buttonC = findViewById(R.id.button_synth_c);
        buttonCs = findViewById(R.id.button_synth_cs);
        buttonD = findViewById(R.id.button_synth_d);
        buttonDs = findViewById(R.id.button_synth_ds);
        buttonE = findViewById(R.id.button_synth_e);
        buttonF = findViewById(R.id.button_synth_f);
        buttonFs = findViewById(R.id.button_synth_fs);
        buttonG = findViewById(R.id.button_synth_g);
        buttonGs = findViewById(R.id.button_synth_gs);
        buttonHa = findViewById(R.id.button_synth_ha);
        buttonHb = findViewById(R.id.button_synth_hb);
        buttonHd = findViewById(R.id.button_synth_hd);
        buttonHc = findViewById(R.id.button_synth_hc);

        buttonAllNotes = findViewById(R.id.button_synth_all_notes);
        buttonlowEtohighE = findViewById(R.id.button_synth_letohe);
        buttontwinkle = findViewById(R.id.button_synth_twinkle);
        buttontwinkletwo = findViewById(R.id.button_synth_twinkletwo);
        buttonHappyBirthday = findViewById(R.id.button_synth_hb);
        buttonChTwo = findViewById(R.id.button_synth_chtwo);
        buttonDespacito = findViewById(R.id.button_synth_despacito);
        buttonFortnite = findViewById(R.id.button_synth_fortnite);

        numberPickerchtwo = findViewById(R.id.numberpicker_synth_chtwo);
    }


    @Override
    public void onClick(View v) {
        //on method for all button clicks
        switch (v.getId()) {

            case R.id.button_synth_all_notes:
                playAllNotes();
                break;

            case R.id.numberpicker_synth_chtwo:
                updateRepeat();
                break;

            case R.id.button_synth_chtwo:
                updateRepeat();
                updateNote();
                playChallengeTwo(repeat, ChTwoNote);
                break;

            case R.id.button_synth_letohe:
                playLowEToHighE();
                break;

            case R.id.button_synth_twinkle:
                playTwinkle();
                break;
            case R.id.button_synth_twinkletwo:
                playTwinkleTwo();
                break;
            case R.id.button_synth_hb:
                playHappyBirthday();
                break;
            case R.id.button_synth_despacito:
                playDespacito();
                break;
            case R.id.button_synth_fortnite:
                playFortnite();
                break;
        }
    }

    private void updateNote() {
        Toast.makeText(this, "What note Do you want to play?", Toast.LENGTH_SHORT).show();
        //listen for note

        ChTwoNote = noteG;

    }

    private void playFortnite() {
        int beats = 2583; //this is as the song has a weired bpm so I can't use Whole_note
        song dance = new song();

        dance.add(new Note(noteF, beats/4));
        dance.add(new Note(noteF, beats/16));
        dance.add(new Note(noteGs, beats/16));
        dance.add(new Note(noteBb, beats/16));
        dance.add(new Note(noteBb, beats/8 + beats/16));
        dance.add(new Note(noteGs, 2*(beats/8 + beats/16)));

        dance.add(new Note(noteF, beats/4));
        dance.add(new Note(noteF, beats/16));
        dance.add(new Note(noteGs, beats/16));
        dance.add(new Note(noteBb, beats/16));
        dance.add(new Note(noteBb, beats/8));
        dance.add(new Note(noteGs, beats/8));
        dance.add(new Note(noteF, beats/8));
        dance.add(new Note(noteDs, beats/16));
        dance.add(new Note(noteF, beats/8+beats/8));

        dance.add(new Note(noteBb, beats/16));
        dance.add(new Note(noteGs, beats/16));
        dance.add(new Note(noteF, beats/16));
        dance.add(new Note(noteDs, beats/16));
        dance.add(new Note(noteF));

        playSong(dance);
        playSong(dance);
        //the actual song plays twice
    }

    private void playDespacito() {
//        int [] song = {noteFs, noteB, noteCs, noteD, noteE, noteD, noteCs, noteB, noteA, noteG, noteD, noteD, noteD, noteD, noteD, noteA, noteD, noteA, noteD, noteE, noteCs, noteCs};
//        for(int note: song){
//            soundpool.play(note, 1f, 1f,1,0,1f);
//            try {
//                Thread.sleep(WHOLE_NOTE/5);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        song scale = new song();

        scale.add(new Note(noteD, 800));
        scale.add(new Note(noteFs, 800));
        scale.add(new Note(noteB, 400));
        scale.add(new Note(noteD, 400));
        scale.add(new Note(noteCs));
        scale.add(new Note(noteB));
        scale.add(new Note(noteA));
        scale.add(new Note(noteB));
        scale.add(new Note(noteB));
        scale.add(new Note(noteCs));
        scale.add(new Note(noteD));
        scale.add(new Note(noteE));
        scale.add(new Note(noteFs));
        scale.add(new Note(noteD));
        scale.add(new Note(noteFs));
        scale.add(new Note(noteD));
        scale.add(new Note(noteFs));
        scale.add(new Note(noteFs));
        scale.add(new Note(noteD));
        scale.add(new Note(noteE));
        scale.add(new Note(noteCs));
        scale.add(new Note(noteD));
        scale.add(new Note(noteB));
        scale.add(new Note(noteD));
        scale.add(new Note(noteFs));
        scale.add(new Note(noteB));
        scale.add(new Note(noteD));
        scale.add(new Note(noteB));
        scale.add(new Note(noteD));
        scale.add(new Note(noteFs));
        scale.add(new Note(noteD));
        scale.add(new Note(noteCs));
        scale.add(new Note(noteB));
        scale.add(new Note(noteA));
        scale.add(new Note(noteB));
        scale.add(new Note(noteD));
        scale.add(new Note(noteCs));
        scale.add(new Note(noteB));
        scale.add(new Note(noteA));
        scale.add(new Note(noteD));
        scale.add(new Note(noteFs));
        scale.add(new Note(noteA));
        scale.add(new Note(noteD));
        scale.add(new Note(noteFs));
        scale.add(new Note(noteD));
        scale.add(new Note(noteFs));
        scale.add(new Note(noteA));
        scale.add(new Note(noteD));
        scale.add(new Note(noteCs));
        scale.add(new Note(noteB));
        scale.add(new Note(noteA));
        scale.add(new Note(noteE));
        scale.add(new Note(noteFs));
        scale.add(new Note(noteD));
        scale.add(new Note(noteE));
        scale.add(new Note(noteCs));
        scale.add(new Note(noteD));
        scale.add(new Note(noteB));



//This song is to long for android studio to handle; It starts repeating a single note and then crashes.
//
//        scale.add(new Note(noteFs, 400));
//        scale.add(new Note(noteB, 400));
//        scale.add(new Note(noteCs, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteE, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteCs, 400));
//        scale.add(new Note(noteB, 400));
//        scale.add(new Note(noteA, 400));
//        scale.add(new Note(noteG, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteA, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteA, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteE, 400));
//        scale.add(new Note(noteCs, 400));
//        scale.add(new Note(noteCs, 400));
//        scale.add(new Note(noteB, 400));
//        scale.add(new Note(noteB, 400));
//        scale.add(new Note(noteFs, 400));
//        scale.add(new Note(noteB, 400));
//        scale.add(new Note(noteCs, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteE, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteCs, 400));
//        scale.add(new Note(noteB, 400));
//        scale.add(new Note(noteA, 400));
//        scale.add(new Note(noteG, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteA, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteA, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteA, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteE, 400));
//        scale.add(new Note(noteCs, 400));
//        scale.add(new Note(noteCs, 400));
//        scale.add(new Note(noteFs, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteE, 400));
//        scale.add(new Note(noteCs, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteB, 400));
//        scale.add(new Note(noteFs, 400));
//        scale.add(new Note(noteFs, 400));
//        scale.add(new Note(noteB, 400));
//        scale.add(new Note(noteCs, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteCs, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteCs, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteCs, 400));
//        scale.add(new Note(noteB, 400));
//        scale.add(new Note(noteB, 400));
//        scale.add(new Note(noteB, 400));
//        scale.add(new Note(noteB, 400));
//        scale.add(new Note(noteCs, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteCs, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteCs, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteE, 400));
//        scale.add(new Note(noteA, 400));
//        scale.add(new Note(noteA, 400));
//        scale.add(new Note(noteA, 400));
//        scale.add(new Note(noteA, 400));
//        scale.add(new Note(noteA, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteA, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteA, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteE, 400));
//        scale.add(new Note(noteE, 400));
//        scale.add(new Note(noteE, 400));
//        scale.add(new Note(noteCs, 400));
//        scale.add(new Note(noteCs, 400));
//        scale.add(new Note(noteB, 400));
//        scale.add(new Note(noteB, 400));
//        scale.add(new Note(noteFs, 400));
//        scale.add(new Note(noteB, 400));
//        scale.add(new Note(noteCs, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteCs, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteCs, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteCs, 400));
//        scale.add(new Note(noteB, 400));
//        scale.add(new Note(noteB, 400));
//        scale.add(new Note(noteB, 400));
//        scale.add(new Note(noteB, 400));
//        scale.add(new Note(noteCs, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteCs, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteCs, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteE, 400));
//        scale.add(new Note(noteA, 400));
//        scale.add(new Note(noteA, 400));
//        scale.add(new Note(noteA, 400));
//        scale.add(new Note(noteA, 400));
//        scale.add(new Note(noteA, 400));
//        scale.add(new Note(noteA, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteCs, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteCs, 400));
//        scale.add(new Note(noteD, 400));
//        scale.add(new Note(noteE, 400));
//        scale.add(new Note(noteE, 400));
//        scale.add(new Note(noteE, 400));
//        scale.add(new Note(noteCs, 400));
//        scale.add(new Note(noteCs, 400));


        playSong(scale);
    }

    private void playSong(song scale) {
        for (Note note : scale.getNotes()) {
            playNote(note.getNoteID());
            delay(note.getDelay());
        }
    }

    private void delay(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void updateRepeat() {
        repeat = numberPickerchtwo.getValue();
    }

    private void playChallengeTwo(int n, int noteID) {
        int i = 0;
        while (i <= n) {
            soundpool.play(noteID, 1f, 1f, 1, 0, 1f);
            try {
                Thread.sleep(WHOLE_NOTE / 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;

        }
    }

    private void playHappyBirthday() {

        song happy = new song();


        happy.add(new Note(noteD, WHOLE_NOTE/8 + WHOLE_NOTE/16));
        happy.add(new Note(noteD, WHOLE_NOTE/16));
        happy.add(new Note(noteE, WHOLE_NOTE/4));
        happy.add(new Note(noteD, WHOLE_NOTE/4));
        happy.add(new Note(noteG, WHOLE_NOTE/4));
        happy.add(new Note(noteFs, WHOLE_NOTE/2));
        happy.add(new Note(noteD, WHOLE_NOTE/8+WHOLE_NOTE/16));
        happy.add(new Note(noteD, WHOLE_NOTE/16));

        happy.add(new Note(noteE, WHOLE_NOTE/4));
        happy.add(new Note(noteD, WHOLE_NOTE/4));
        happy.add(new Note(noteHa, WHOLE_NOTE/4));
        happy.add(new Note(noteG, WHOLE_NOTE/2));
        happy.add(new Note(noteD, WHOLE_NOTE/8 + WHOLE_NOTE/16));
        happy.add(new Note(noteD, WHOLE_NOTE/16));
        happy.add(new Note(noteHd, WHOLE_NOTE/4));
        happy.add(new Note(noteHb, WHOLE_NOTE/4));
        happy.add(new Note(noteG, WHOLE_NOTE/4));
        happy.add(new Note(noteFs, WHOLE_NOTE/4));
        happy.add(new Note(noteE, WHOLE_NOTE/4));
        happy.add(new Note(noteHc, WHOLE_NOTE/4)); //maby hc
        happy.add(new Note(noteHc, WHOLE_NOTE/4)); //maby hc
        happy.add(new Note(noteHb, WHOLE_NOTE/4));
        happy.add(new Note(noteG, WHOLE_NOTE/4));
        happy.add(new Note(noteHa, WHOLE_NOTE/4)); //maybe not h
        happy.add(new Note(noteG, WHOLE_NOTE/4));

        playSong(happy);
    }

    private void playNote(int note, int loop) {
        soundpool.play(note, DEFAULT_VOLUME, DEFAULT_VOLUME, DEFAULT_PRIORITY,
                loop, DEFAULT_RATE);
    }

    private void playNote(int note) {
        playNote(note, 0);
    }

    private void playTwinkleTwo() {
        int[] twinkle = {noteE, noteE, noteD, noteD, noteCs, noteC, noteB};
        for (int note : twinkle) {
            soundpool.play(note, 1f, 1f, 1, 0, 1f);
            try {
                Thread.sleep(WHOLE_NOTE / 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void playTwinkle() {
        int[] twinkle = {noteA, noteA, noteE, noteE, noteFs, noteFs, noteE, noteD, noteD, noteCs, noteCs, noteB, noteB, noteA};
        for (int note : twinkle) {
            soundpool.play(note, 1f, 1f, 1, 0, 1f);
            try {
                Thread.sleep(WHOLE_NOTE / 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void playLowEToHighE() {
        int[] theEs = {noteE, noteFs, noteG, noteA, noteB, noteCs, noteD, noteE};
        for (int note : theEs) {
            soundpool.play(note, 1f, 1f, 1, 0, 1f);
            try {
                Thread.sleep(WHOLE_NOTE / 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void playAllNotes() {
        int[] allNotes = {noteA, noteBb, noteB, noteC, noteCs, noteD, noteDs, noteE, noteF, noteFs, noteG, noteGs};
        for (int note : allNotes) {
            soundpool.play(note, 1f, 1f, 1, 0, 1f);
            try {
                Thread.sleep(WHOLE_NOTE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class keyboardNoteListener implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            int id = v.getId();
            int note = noteMap.get(id);
            playNote(note);
        }
    }
}
