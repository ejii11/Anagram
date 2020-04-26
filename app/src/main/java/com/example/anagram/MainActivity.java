package com.example.anagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.anagram.R;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
    Button b_dict;

    Random r;

    String currentWord;
    String hintText;

    Word[] word = new Word[1000000];

    int index = 0;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_info = (TextView) findViewById(R.id.tv_info);
        tv_word = (TextView) findViewById(R.id.tv_word);
        score = (TextView) findViewById(R.id.score);

        et_guess = (EditText) findViewById(R.id.et_guess);

        b_check = (Button) findViewById(R.id.b_check);
        b_new = (Button) findViewById(R.id.b_new);
        b_hint = (Button) findViewById(R.id.b_hint);
        b_dict = (Button) findViewById(R.id.b_dict);

        r = new Random();

        readFile();
        newGame();
        hintHelp();

        b_dict.setEnabled(true);

        Button b_dict = (Button) findViewById(R.id.b_dict);
        b_dict.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String link = "https://www.dictionary.com/";
                Uri webaddress = Uri.parse(link);

                Intent goToLink = new Intent(Intent.ACTION_VIEW, webaddress);
                if(goToLink.resolveActivity(getPackageManager()) != null){
                    startActivity(goToLink);
                }
            }
        });

        b_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_guess.getText().toString().equalsIgnoreCase(currentWord)){
                    tv_info.setText("Awesome");
                    b_check.setEnabled(false);
                    b_new.setEnabled(true);
                    realScore++;
                    score.setText("Score is: " + realScore);
                } else {
                    tv_info.setText("Git Gud. Try Again");
                    realScore--;
                    score.setText("Score is: " + realScore);
                }
            }
        });

        b_new.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                newGame();

            }
        });

        b_hint.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                hintHelp();
                tv_info.setText(hintText);
            }
        });
    }


    //shuffle algorithm
    private String shuffledWord(String word){
        List<String> letters = Arrays.asList(word.split(""));
        Collections.shuffle(letters);
        String shuffled = "";
        for(String letter : letters){
            shuffled += letter;

        }
        return shuffled;
    }

    private void newGame() {
        //get random word from the dictionary
        a = r.nextInt(index);//r.nextInt(word.length);
        currentWord = word[a].getWord();

        //show the shuffled word
        tv_word.setText(shuffledWord(currentWord));

        //clear the text field
        et_guess.setText("");


        //switch buttons
        b_new.setEnabled(false);
        b_check.setEnabled(true);

    }

    private void hintHelp(){
        hintText = word[a].getDef();


    }




    public void readFile(){

        try{
            InputStream is = getApplicationContext().getAssets().open("dictionary.txt");
            InputStreamReader isr = new InputStreamReader(is, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            Scanner sc = new Scanner (br);

            while (sc.hasNextLine()){
                String wordFromFile = sc.next();
                String definition = sc.nextLine();

                word[index++] = new Word(wordFromFile, definition);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public class Word {

        private String word;
        private String def;

        public Word(String word, String def) {
            this.word = word;
            this.def = def;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public String getDef() {
            return def;
        }

        public void setDef(String def) {
            this.def = def;
        }

        public int compareTo(String key) {
            return word.compareTo(key);
        }

        public boolean equals(String key) {
            return word.equals(key);
        }

        @Override
        public String toString() {
            return "Word [word=" + word + ", def=" + def + "]";
        }

    }
}
