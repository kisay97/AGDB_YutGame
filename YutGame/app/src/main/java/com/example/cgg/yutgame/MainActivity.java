package com.example.cgg.yutgame;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //윷을 던진 결과의 이름
    //앞면이 표시된 갯수로 yutName을 접근하기 위해서 모, 도, 개, 걸, 윷 순으로 저장한다.
    //앞면이 표시된 갯수 : 0:모, 1:도, 2:개, 3:걸, 4:윷
    String[] yutName = {"모", "도", "개", "걸", "윷"};

    //random함수를 쓰기 위한 객체
    Random rnd = new Random();

    //Image Resource
    //ImageView에 표시할 Image를 지정할 때, R.drawable에 자동으로 입력된 상수를 사용한다.
    int[] yutImg = {R.drawable.yut_1, R.drawable.yut_0};

    //ImageView
    ImageView[] imgView = new ImageView[4];

    //게임 결과 표시용
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //버튼의 Listener 셋팅
        findViewById(R.id.fab).setOnClickListener(onButtonClick);
        findViewById(R.id.button).setOnClickListener(onButtonClick);

        //ImageView 읽기
        for(int i=0; i<4; i++){
            imgView[i] = (ImageView) findViewById(R.id.imageView0 + i);
        }

        //txtResult 읽기
        txtResult = (TextView) findViewById(R.id.txtResult);
    }

    //버튼의 Listener
    Button.OnClickListener onButtonClick = new Button.OnClickListener(){
        @Override
        public void onClick(View v){
            if(v.getId() == R.id.button){
                setGameResult();
            }
        }
    };

    public void setGameResult(){
        int cHead = 0; //앞면의 갯수

        for(int i=0; i<4; i++){
            int n = rnd.nextInt(2); //0~1. 0:뒷면, 1:앞면
            cHead += n; //앞면의 갯수를 셈

            imgView[i].setImageResource(yutImg[n]); //앞뒷면 나온대로 윷가락 이미지 셋팅
        }

        txtResult.setText(yutName[cHead]); //앞뒷면 나온데로 결과 출력
    }
}