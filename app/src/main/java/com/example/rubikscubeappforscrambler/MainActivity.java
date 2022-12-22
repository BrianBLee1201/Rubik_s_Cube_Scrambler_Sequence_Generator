package com.example.rubikscubeappforscrambler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //public ArrayList<String> choices_of_difficulty = new ArrayList<String>();
    final private String[] CUBE_FACES = {"U","D","L","R","F","B"};
    final private String[] ROTATION_TYPES = {"", "'", "2"};
    final private String[] LAYER_TYPES = {"","2","3","4","5","6","7","8"};
    final private ArrayList<String> LIST_OF_MODE_TYPES = new ArrayList<String>();

    final int FACTOR = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LIST_OF_MODE_TYPES.add("2x2");
        LIST_OF_MODE_TYPES.add("3x3");
        LIST_OF_MODE_TYPES.add("4x4");
        LIST_OF_MODE_TYPES.add("5x5");
        LIST_OF_MODE_TYPES.add("6x6");
        LIST_OF_MODE_TYPES.add("7x7");
        LIST_OF_MODE_TYPES.add("8x8");
        LIST_OF_MODE_TYPES.add("9x9");
        LIST_OF_MODE_TYPES.add("10x10");
        LIST_OF_MODE_TYPES.add("11x11");
        LIST_OF_MODE_TYPES.add("12x12");
        LIST_OF_MODE_TYPES.add("13x13");
        LIST_OF_MODE_TYPES.add("14x14");
        LIST_OF_MODE_TYPES.add("15x15");
        LIST_OF_MODE_TYPES.add("16x16");
        LIST_OF_MODE_TYPES.add("17x17");
    }
    public void generate(View view){
        Spinner choose_difficulty = findViewById(R.id.Difficulty);
        String difficulty_selection = choose_difficulty.getSelectedItem().toString();
        Spinner choose_mode = findViewById(R.id.mode);
        int mode_id = LIST_OF_MODE_TYPES.indexOf(choose_mode.getSelectedItem().toString());

        if (difficulty_selection.equals("easy")){
            output_message(view, 1, mode_id);
        }
        else if (difficulty_selection.equals("normal")){
            output_message(view, 2, mode_id);
        }
        else{
            output_message(view, 4, mode_id);
        }
    }

    private void output_message(View view, int difficulty_type, int mode_id){

        TextView message = (TextView) findViewById(R.id.scramble_pattern);
        //sequence of moves
        mode_id++;

        ArrayList<String> sequence_of_moves = new ArrayList<String>();
        Random rand = new Random();
        int first_move_index = rand.nextInt(6);
        sequence_of_moves.add(CUBE_FACES[first_move_index]);
        for (int i = 1; i < (difficulty_type * FACTOR * mode_id); i++){
            int next_move_index = rand.nextInt(6);
            while (next_move_index == first_move_index){
                next_move_index = rand.nextInt(6);
            }
            first_move_index = next_move_index;
            sequence_of_moves.add(CUBE_FACES[first_move_index]);
        }
        Random rand2 = new Random();
        Random rand3 = new Random();

        String dummy_message = "";
        mode_id--;
        int layer_type = mode_id / 2 + 1;
        for (String itr: sequence_of_moves){
            dummy_message = dummy_message + LAYER_TYPES[rand3.nextInt(layer_type)] + itr + ROTATION_TYPES[rand2.nextInt(3)] + " ";
        }
        message.setText(dummy_message);
    }
}