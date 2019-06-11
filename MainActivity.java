package com.example.cache;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;

import android.os.Bundle;
import java.util.List;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivity extends Activity {

    private SQLiteDatabaseHandler db;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView) findViewById(R.id.result);
        // create our sqlite helper class
        db = new SQLiteDatabaseHandler(this);
        // create some players
        Player player1 = new Player(1, "A", "F", 203);
        Player player2 = new Player(2, "B", "F", 208);
        Player player3 = new Player(3, "C", "C", 214);
        // add them

            db.addPlayer(player1);
            db.addPlayer(player2);
            db.addPlayer(player3);



        // list all players
        List<Player> players = db.allPlayers();

//        if (players != null) {
//            String[] itemsNames = new String[players.size()];
//
//            for (int i = 0; i < players.size(); i++) {
//                itemsNames[i] = players.get(i).toString();
//                System.out.println(itemsNames[i]);
//            }
//
//            // display like string instances
//            ListView list = (ListView) findViewById(R.id.list);
//            list.setAdapter(new ArrayAdapter<String>(this,
//                    android.R.layout.simple_list_item_1, android.R.id.text1, itemsNames));
//
//        }
        StringBuilder builder = new StringBuilder();
        for(Player player : players)
        {
            builder.append(player).append("\n");

        }
        result.setText(builder.toString());


    }
}