package space.kubik.quizbelarus;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.Random;

import static space.kubik.quizbelarus.R.color.black95;

public class Level22 extends AppCompatActivity {
    private Dialog dialog, dialogEnd;
    private Button onBack;
    private TextView button_left1;
    private TextView button_right1;
    private ImageView button_right_img;
    private TextView levltext;
    private int prow1=1000,prow2=1000;
    private int numimg,num1_2;
    private int numElement,numtown;
    public int transition =0;
    public InterstitialAd minterstitialAd;//реклама
    private int k=0;
    Array array=new Array();
    Random random=new Random();
    GameLevels gm=new GameLevels();

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal3);

        TextView money = (TextView) findViewById(R.id.textMoney3);
        SharedPreferences  preferences=getSharedPreferences("mani",MODE_PRIVATE);
        gm.countmoney=preferences.getInt("money",0);
        money.setText(gm.countmoney+"");

        //реклама н
        MobileAds.initialize(this,"ca-app-pub-1454009650773931~3001729363");
        minterstitialAd = new InterstitialAd(this);
        minterstitialAd.setAdUnitId("ca-app-pub-1454009650773931/3595791584");
        AdRequest adRequest=new AdRequest.Builder().build();
        minterstitialAd.loadAd(adRequest);
        //реклама к
        //закрытие н
        minterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                try {
                    switch (transition){
                        case 1: Intent intent = new Intent(Level22.this, GameLevels.class);
                            startActivity(intent);
                            finish(); break;
                        default:break;
                    }

                } catch (Exception e) {
                }
            }
        });
        //закрытие к

        onBack=(Button)findViewById(R.id.button_back);
        button_left1=(TextView)findViewById(R.id.textleft);
        button_right1=(TextView)findViewById(R.id.textright);
        levltext=(TextView)findViewById(R.id.levltext);
        TextView text_levels=(TextView)findViewById(R.id.text_levels);

        onBack.setTextColor(black95);

        levltext.setTextColor(black95);
        levltext.setText(R.string.viemblem);//TODO:изменять по уровням

        button_right_img=(ImageView)findViewById(R.id.imageRight);

        text_levels.setText(R.string.level22);
        text_levels.setTextColor(black95);
        //Window w=getParent().getWindow();
        //w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



        //устанавливаем фон окна - начало
        ImageView background =(ImageView)findViewById(R.id.fon_level_un1);
        background.setImageResource(R.drawable.fon_level6);
        //устанавливаем фон окна - конец

        //---------------------------------------------------------------
        dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываем загаловок
        dialog.setContentView(R.layout.previevdialog);//путь к диологовому окну
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон диалогового окна
        dialog.setCancelable(false);//окно нельзя закрыть системной кнопкой
        //устанавлеваем описание задания - начало
        TextView textdescription =(TextView)dialog.findViewById(R.id.textdescription);
        textdescription.setText(R.string.level22_1);
        //устанавлеваем описание задания - конец

        //устанавливаем картинку в диологовое окно - начало
        ImageView previewimg = (ImageView)dialog.findViewById(R.id.image4);
        previewimg.setImageResource(R.drawable.previev22_1_1);
        //устанавливаем картинку в диологовое окно - конец

        //устанавливаем фон диаоргового окна - начало
        LinearLayout dialogfon=(LinearLayout)dialog.findViewById(R.id.dialogfon);
        dialogfon.setBackgroundResource(R.drawable.fonstartdialog4_1);
        //устанавливаем фон диаоргового окна - конец

        //кнопка коорая закрывает диологовое окно - начало
        TextView btnclose =(TextView)dialog.findViewById(R.id.btnClose);
        btnclose.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //обрабатываем нажатие кнопки - начало
                        try {
                            //вернуться назад к выбору уровня - начало
                            Intent intent=new Intent(Level22.this, GameLevels.class);
                            startActivity(intent); finish();
                            //вернуться назад к выбору уровня - конец
                        }catch (Exception e){}
                        dialog.dismiss();//закрываем диологовое окно
                        //обрабатываем нажатие кнопки - конец
                    }
                }
        );//кнопка коорая закрывает диологовое окно - конец
        //кнопка "продолжить" - начало
        Button btncontinue=(Button)dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            dialog.dismiss();//закрываем диалоговое окно
                        }catch (Exception e){}
                    }
                }
        );
        //кнопка "продолжить" - конец

        dialog.show();//показать диалоговое окно
        //---------------------------------------------------------------

        //---------------------------------------------------------------
        dialogEnd=new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываем загаловок
        dialogEnd.setContentView(R.layout.dialogend);//путь к диологовому окну
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон диалогового окна
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);

        //устанавлеваем описание задания - начало
        TextView textdescriptionEnd =(TextView)dialogEnd.findViewById(R.id.textdescription);
        textdescriptionEnd.setText(R.string.level22End1);
        //устанавлеваем описание задания -конец

        //устанавливаем фон диаоргового окна - начало
        LinearLayout dialogfonEnd=(LinearLayout)dialogEnd.findViewById(R.id.dialogfon);
        dialogfonEnd.setBackgroundResource(R.drawable.fonstartdialog4_1);
        //устанавливаем фон диаоргового окна - конец

        dialogEnd.setCancelable(false);//окно нельзя закрыть системной кнопкой
        //кнопка коорая закрывает диологовое окно - начало
        TextView btncloseEnd =(TextView)dialogEnd.findViewById(R.id.btnClose);
        btncloseEnd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //обрабатываем нажатие кнопки - начало
                        try {
                            //вернуться назад к выбору уровня - начало
                            Intent intent=new Intent(Level22.this, GameLevels.class);
                            startActivity(intent);
                            finish();
                            //вернуться назад к выбору уровня - конец
                        }catch (Exception e){}
                        dialogEnd.dismiss();//закрываем диологовое окно
                        //обрабатываем нажатие кнопки - конец
                    }
                }
        );//кнопка коорая закрывает диологовое окно - конец
        //кнопка "продолжить" - начало
        Button btncontinueEnd=(Button)dialogEnd.findViewById(R.id.btncontinue);
        btncontinueEnd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            dialogEnd.dismiss();//закрываем диалоговое окно
                            Intent intent=new Intent(Level22.this,Level23.class);//TODO:level3
                            startActivity(intent);
                            finish();
                        }catch (Exception e){}
                    }
                }
        );
        //кнопка "продолжить" - конец
        //---------------------------------------------------------------

        onBackClick();
        onStartClick();
    }

    public void onStartClick(){

        randomstart();


        final int[] progress={ R.id.point1,R.id.point2,R.id.point3,R.id.point4,R.id.point5,
                R.id.point6,R.id.point7,R.id.point8,R.id.point9,R.id.point10,
        };

        //подключаем анимацию - начало
        final Animation a= AnimationUtils.loadAnimation(Level22.this, R.anim.alpha);
        //подключаем анимацию - конец

        //button_left1.setBackgroundResource(R.drawable.button_answer1_press_un1);
        //button_right1.setBackgroundResource(R.drawable.button_answer1_press_un1);

        // 1-кнопка начало-----------------------
        button_left1.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    button_right1.setEnabled(false);

                    if(num1_2==1){//TODO:изменить
                        button_left1.setBackgroundResource(R.drawable.style_btn_es_green);
                    }else {
                        button_left1.setBackgroundResource(R.drawable.style_btn_now_red);
                        button_right1.setBackgroundResource(R.drawable.style_btn_es_green);
                    }
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    if(num1_2==1){
                        if(k<10){k+=1;}

                        for(int i=0;i<10;i++){//закрашиваем прогресс в серый цвет
                            TextView tv =(TextView)findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.stule_points);
                        }

                        for(int i=0;i<k;i++){//закрашиваем прогресс в зеленый цвет
                            TextView tv =(TextView)findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.stule_points_green);
                        }
                    }else{ if(k>0){k-=1;}
                        for(int i=0;i<10;i++){//закрашиваем прогресс в серый цвет
                            TextView tv =(TextView)findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.stule_points);
                        }

                        for(int i=0;i<k;i++){//закрашиваем прогресс в зеленый цвет
                            TextView tv =(TextView)findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.stule_points_green);
                        }

                    }
                    if(k==10){
                        //выход из уровня
                        SharedPreferences save = getSharedPreferences("Save",MODE_PRIVATE);
                        final int level=save.getInt("Level",1);

                        gm.countmoney+=gm.coutLevel;
                        SharedPreferences  preferences=getSharedPreferences("mani",MODE_PRIVATE);
                        SharedPreferences.Editor edit=preferences.edit();
                        edit.putInt("money",gm.countmoney);
                        edit.commit();
                        if(level>22){//изменить-----------

                        }else{
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level",23);
                            editor.commit();
                        }
                        dialogEnd.show();
                    }else{
                        button_left1.startAnimation(a);//izm
                        button_right1.startAnimation(a);
                        randomstart();

                        button_left1.setBackgroundResource(R.drawable.button_answer1_press_un1);
                        button_right1.setBackgroundResource(R.drawable.button_answer1_press_un1);
                        button_right1.setEnabled(true);
                    }

                }



                return true;
            }
        });
        // 1-кнопка конец------------------------



        // 2-кнопка начало-----------------------
        button_right1.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    button_left1.setEnabled(false);

                    if(num1_2==2){//TODO:изменить
                        button_right1.setBackgroundResource(R.drawable.style_btn_es_green);

                    }else {
                        button_right1.setBackgroundResource(R.drawable.style_btn_now_red);
                        button_left1.setBackgroundResource(R.drawable.style_btn_es_green);

                    }
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    if(num1_2==2){
                        if(k<10){k+=1;}

                        for(int i=0;i<10;i++){//закрашиваем прогресс в серый цвет
                            TextView tv =(TextView)findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.stule_points);
                        }

                        for(int i=0;i<k;i++){//закрашиваем прогресс в зеленый цвет
                            TextView tv =(TextView)findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.stule_points_green);
                        }
                    }else{ if(k>0){k-=1;}
                        for(int i=0;i<10;i++){//закрашиваем прогресс в серый цвет
                            TextView tv =(TextView)findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.stule_points);
                        }

                        for(int i=0;i<k;i++){//закрашиваем прогресс в зеленый цвет
                            TextView tv =(TextView)findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.stule_points_green);
                        }

                    }
                    if(k==10){
                        //выход из уровня
                        SharedPreferences save = getSharedPreferences("Save",MODE_PRIVATE);
                        final int level=save.getInt("Level",1);

                        gm.countmoney+=gm.coutLevel;
                        SharedPreferences  preferences=getSharedPreferences("mani",MODE_PRIVATE);
                        SharedPreferences.Editor edit=preferences.edit();
                        edit.putInt("money",gm.countmoney);
                        edit.commit();
                        if(level>22){

                        }else{
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level",23);
                            editor.commit();
                        }
                        dialogEnd.show();
                    }else{
                        button_left1.startAnimation(a);
                        button_right1.startAnimation(a);
                        randomstart();

                        button_left1.setBackgroundResource(R.drawable.button_answer1_press_un1);
                        button_right1.setBackgroundResource(R.drawable.button_answer1_press_un1);
                        button_left1.setEnabled(true);
                    }

                }


                return true;
            }
        });
        // 2-кнопка конец------------------------
    }

    private void randomstart(){
        numimg=random.nextInt(10)+1;
        numElement=random.nextInt(10)+1;//рандом другой страны
        while(numElement==numimg){    numElement=random.nextInt(10)+1;    }
        num1_2=random.nextInt(2)+1;//выбирает какая кнопка верная

        while (prow1==numimg){numimg=random.nextInt(10)+1;}
        while (prow2==numElement || numElement==numimg){numElement=random.nextInt(10)+1;}
        prow1=numimg; prow2=numElement;

        button_right_img.setBackgroundResource(array.emblem5Vi[numimg-1]);

        if(num1_2==1){
            button_left1.setText(array.citiLevel5Vi[numimg-1]);
            button_right1.setText(array.citiLevel5Vi[numElement-1]);
        }else if(num1_2==2){
            button_right1.setText(array.citiLevel5Vi[numimg-1]);
            button_left1.setText(array.citiLevel5Vi[numElement-1]);
        }else{button_right1.setText("nonononowwwww");}
    }


    public void onBackClick(){
        onBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (minterstitialAd.isLoaded()){
                    transition=1;
                    minterstitialAd.show();
                }else {
                Intent intent=new Intent(Level22.this, GameLevels.class);
                startActivity(intent);
                finish();}
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (minterstitialAd.isLoaded()){
            transition=1;
            minterstitialAd.show();
        }else {
        Intent intent=new Intent(Level22.this, GameLevels.class);
        startActivity(intent);
        finish();}
    }
}