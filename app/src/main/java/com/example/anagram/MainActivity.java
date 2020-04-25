package com.example.anagram;

import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.snackbar.Snackbar;
import android.os.Bundle;
import android.util.Log;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tv_info;
    TextView tv_word;
    TextView score;
    int realScore = 0;
    int a;


    EditText et_guess;

    Button b_check;
    Button b_new;
    Button b_hint;

    Random r;

    String currentWord;

    String hintText;

    String[] hintFile = {
            "The Darkin Blade",
            "The nine tailed fox",
            "Rogue Assassin",
            "The Minotaur",
            "The Sad Mummy",
            "The Cryophoenix",
            "The Dark Child",
            "Frost Archer",
            "Emperor of the Sands",
            "The Great Steam",
            "Burning Vengeance",
            "Heart of the Freljord",
            "Sheriff of Piltover",
            "Steel Shadow",
            "Terror of the Void",
            "Daring Bombardier",
            "Hand of Noxus",
            "Scorn of the Moon",
            "The Madman of Zaun",
            "Glorious Executioner",
            "Spider Queen",
            "Agony's Embrace",
            "Progical Explorer",
            "Ancient Fear",
            "Grand Duelist",
            "Tidal Trickster",
            "Colossus",
            "Saltwater Scourge",
            "Might of Demacia",
            "Missing Link",
            "Rabble Rouser",
            "The outlaw",
            "Shadow of War",
            "REvered Inventor",
            "Blade Dancer",
            "Storm's Fury",
            "The exemplar of Demacia",
            "Grandmaster at Arms",
            "Defender of Tomorrow",
            "Loose Cannon",
            "Spear of Vengeance",
            "Englightened One",
            "DeathSinger",
            "VoidWalker",
            "Sinister Blade",
            "Righteous",
            "Heart of the Tempest",
            "Voidreaver",
            "Mouth of the Abyss",
            "Deceiver",
            "Blink Monk",
            "Radiant Dawn",
            "Ice Witch",
            "Purifier",
            "Fae Sorceress",
            "Lady of Luminosity",
            "Shard of the Monolith",
            "Prophet of the Void",
            "Twisted Treant",
            "Wuju Bladesman",
            "Bounty Hunter",
            "Iron Revenant",
            "The Fallen",
            "Tidecaller",
            "Curator of the Sands",
            "Titan of the Depths",
            "Bestial Huntress",
            "Eternal Nightmare",
            "Boy and his Yeti",
            "The Berserker",
            "The Lady of Clockwork",
            "Unbreakable",
            "Keeper of the Hammer",
            "Demacia's Wings",
            "Armordillo",
            "Void Burrower",
            "Butcher of the Sands",
            "Pridestalker",
            "The Exile",
            "Mechanized Menace",
            "Rune Mage",
            "Fury of the North",
            "Demon Jester",
            "Eye of Twilight",
            "Half-dragon",
            "Mad Chemist",
            "Undead Juggernaut",
            "Battle Mistress",
            "Crystal Vanguard",
            "Maven of the Strings",
            "Starchild",
            "Noxian Grand General",
            "Unshackled",
            "Dark Sovereign",
            "Blade's Shadow",
            "Shield of Valoran",
            "Swift Scout",
            "Chain Warden",
            "Yordle Gunner",
            "Troll King",
            "Barbarian King",
            "Card Master",
            "Plague Rat",
            "Spirit Walker",
            "Dreadnought",
            "Arrow Retribution",
            "Night Hunter",
            "Tiny Master of Evil",
            "Eye of the Void",
            "Piltover Enforcer",
            "Machine Herald",
            "Crimson Reaper",
            "Thunder's Roar",
            "Uncaged Wrath of Zaun",
            "Monkey King",
            "Magus Ascendant",
            "Seneschal of Demacia",
            "The Unforgiven",
            "Sheperd of Souls",
            "Magical Cat",
            "Secret Weapon",
            "Master of Shadows",
            "Hexplosives",
            "Chronokeeper",
            "Rise of Thorns"
    };

    String[] dictionary = {
            "Aatrox",
            "Ahri",
            "Akali",
            "Alistar",
            "Amumu",
            "Anivia",
            "Annie",
            "Ashe",
            "Azir",
            "Blitzcrank",
            "Brand",
            "Braum",
            "Caitlyn",
            "Cassiopeia",
            "Cho'Gath",
            "Corki",
            "Darius",
            "Diana",
            "Dr. Mundo",
            "Draven",
            "Elise",
            "Evelynn",
            "Ezreal",
            "Fiddlesticks",
            "Fiora",
            "Fizz",
            "Galio",
            "Gangplank",
            "Garen",
            "Gnar",
            "Gragas",
            "Graves",
            "Hecarim",
            "Heimerdinger",
            "Irelia",
            "Janna",
            "Jarvan IV",
            "Jax",
            "Jayce",
            "Jinx",
            "Kalista",
            "Karma",
            "Karthus",
            "Kassadin",
            "Katarina",
            "Kayle",
            "Kennen",
            "Kha'Zix",
            "Kog'Maw",
            "LeBlanc",
            "Lee Sin",
            "Leona",
            "Lissandra",
            "Lucian",
            "Lulu",
            "Lux",
            "Malphite",
            "Malzahar",
            "Maokai",
            "Master Yi",
            "Miss Fortune",
            "Mordekaiser",
            "Morgana",
            "Nami",
            "Nasus",
            "Nautilus",
            "Nidalee",
            "Nocturne",
            "Nunu",
            "Olaf",
            "Orianna",
            "Pantheon",
            "Poppy",
            "Quinn",
            "Rammus",
            "Rek'Sai",
            "Renekton",
            "Rengar",
            "Riven",
            "Rumble",
            "Ryze",
            "Sejuani",
            "Shaco",
            "Shen",
            "Shyvana",
            "Singed",
            "Sion",
            "Sivir",
            "Skarner",
            "Sona",
            "Soraka",
            "Swain",
            "Sylas",
            "Syndra",
            "Talon",
            "Taric",
            "Teemo",
            "Thresh",
            "Tristana",
            "Trundle",
            "Tryndamere",
            "Twisted Fate",
            "Twitch",
            "Udyr",
            "Urgot",
            "Varus",
            "Vayne",
            "Veigar",
            "Vel'Koz",
            "Vi",
            "Viktor",
            "Vladimir",
            "Volibear",
            "Warwick",
            "Wukong",
            "Xerath",
            "Xin Zhao",
            "Yasuo",
            "Yorick",
            "Yuumi",
            "Zac",
            "Zed",
            "Ziggs",
            "Zilean",
            "Zyra"
    };

    /* Logic for a new game of an anagram is that upon start, the user does not have access to
     * the next champion. They must solve the anagram to unlock a new anagram. However,
     * I believe that it would be more user friendly to have it disabled for each question,
     * and after the user asks for a hint, we can reduce half a point from the 1 point they
     * would have received from getting it correct. After the hint, they can then choose to
     * click on a new anagram.
     *
     * Currently, I have it setup to create a new anagram after the user solves an anagram. I
     * will begin implementing a "disable affordance" on top of the b_new button when disbaled,
     * to notify users that they can either get a hint, or solve it.
     *
     * Disabled affordance is simply placing an active button on top of the disabled button, so
     * that when the user clicks on the "disabled button", they are really clicking on the
     * enabled button that will prompt instructions. */

    /* New concept, each solved anagram is a new hint. OnCreate, you have 3 hints. Use them all up and they're gone. Previous rules apply when numHintsLeft = 0 */

    private void newGame() {      b_new.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            newGame();
            Log.d("Mainactivity", "New Anagram Clicked");
        }
    });

        //get random word from the dictionary
        a = r.nextInt(dictionary.length);
        currentWord = dictionary[a];

        //show the shuffled word
        tv_word.setText(shuffledWord(currentWord));

        //clear the text field
        et_guess.setText("");

        //switch buttons
        b_new.setEnabled(false);
        b_check.setEnabled(true);
        Log.d("Mainactivity", "New game initiated");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_info = findViewById(R.id.tv_info);
        tv_word = findViewById(R.id.tv_word);

        et_guess = findViewById(R.id.et_guess);

        b_check = findViewById(R.id.b_check);
        b_new = findViewById(R.id.b_new);
        b_hint = findViewById(R.id.b_hint);

        score = findViewById(R.id.score);
        r = new Random();

        // Initiate a new game to disable new_b and populate tv_word
        newGame();
        hintHelp();

        b_new.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(b_new.isActivated()){
                    Log.d("Mainactivity", "User tried to click on new anagram game while not available");
                } else {
                    Log.d("Mainactivity", "User tried to click on new anagram game while not available");
                }
                newGame();
                Log.d("Mainactivity", "New Anagram Clicked");
            }
        });


        b_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_guess.getText().toString().isEmpty()){
                    Log.d("Mainactivity", "empty text box, do not decrease the number");
                    /* Catches when the user attempts to check to see if their guess is correct
                    * but the text field is still completely empty */
                    Toast.makeText(getApplicationContext(), "Text box is empty!", Toast.LENGTH_SHORT).show();
                } else if (et_guess.getText().toString().equalsIgnoreCase(currentWord)){
//                   tv_info.setText("Awesome");
                   Snackbar.make(findViewById(R.id.tv_info),"Cracked the Anagram!", Snackbar.LENGTH_SHORT).show();
                   b_check.setEnabled(false);
                   b_new.setEnabled(true);
                   realScore++;
                   score.setText("Score is: " + realScore);
                    newGame();
               } else {
                   tv_info.setText("Git Gud");
                   realScore--;
                   score.setText("Score is: " + realScore);
               }
            }
        });


        /* b_hint populates tv_info with a hint */
        b_hint.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                hintHelp();
                tv_info.setText(hintText);
                Log.d("Mainactivity", "Help Hint Clicked");
            }
        });
    }


    public void readFile(String file){
        String text = "";
    }


    /* Shuffles a given champion's name and converts it into an anagram */
    private String shuffledWord(String word){
        List<String> letters = Arrays.asList(word.split(""));
        Collections.shuffle(letters);
        String shuffled = "";
        for(String letter : letters){
            shuffled += letter;
        }
        return shuffled;
    }

    private void hintHelp(){
        hintText = hintFile[a];
    }
}
