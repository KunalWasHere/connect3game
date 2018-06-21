package com.kunal.connect3game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int active=0;
    int[] player={2,2,2,2,2,2,2,2,2};
    int[][] game={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean isgameactive=true;

    public void drop(View view) {
        ImageView counter = (ImageView) view;
        int check = Integer.parseInt(counter.getTag().toString());
        if (player[check] == 2&&isgameactive) {
            player[check]=active;
            counter.setTranslationY(-1000f);
            if (active == 0) {
                counter.setImageResource(R.drawable.yellow);
                active = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                active = 0;
            }

            counter.animate().translationYBy(1000f).setDuration(300);
        }
        String ans="red";

        for(int i=0;i<8;i++){
            if(player[game[i][0]]==player[game[i][1]]&&player[game[i][1]]==player[game[i][2]]&&player[game[i][0]]!=2){
                if(player[game[i][0]]==0)ans="yellow";
                LinearLayout layout=(LinearLayout)findViewById(R.id.game);
                layout.setVisibility(view.VISIBLE);
                TextView winner=(TextView)findViewById(R.id.winner);
                winner.setText(ans+" is winner!!");
                isgameactive=false;
            }
            else{
                boolean c=true;
                for(int k=0;k<9;k++){
                    if(player[k]==2)c=false;
                }
                if(c){
                    LinearLayout layout=(LinearLayout)findViewById(R.id.game);
                    layout.setVisibility(view.VISIBLE);
                    TextView winner=(TextView)findViewById(R.id.winner);
                    winner.setText("It's a draw!!");
                    isgameactive=false;


                }

            }

        }
    }
    public void fun(View view){
        LinearLayout layout=(LinearLayout)findViewById(R.id.game);
        layout.setVisibility(view.INVISIBLE);
        isgameactive=true;
        active=0;
        for(int i=0;i<9;i++)player[i]=2;
        GridLayout grid=(GridLayout)findViewById(R.id.gril);
        for(int i=0;i<grid.getChildCount();i++){
            ((ImageView)grid.getChildAt(i)).setImageResource(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
