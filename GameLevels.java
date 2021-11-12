package space.kubik.quizbelarus;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class GameLevels extends AppCompatActivity {
    private Button onBack;
    private TextView backLevel1,backLevel2,backLevel3,backLevel4,backLevel5,backLevel6,backLevel7,backLevel8,backLevel9,backLevel10;
    private TextView backLevel11,backLevel12,backLevel13,backLevel14,backLevel15,backLevel16,backLevel17,backLevel18,backLevel19,backLevel20;
    private TextView backLevel21,backLevel22,backLevel23,backLevel24,backLevel25,backLevel26,backLevel27,backLevel28,backLevel29,backLevel30;
    private TextView backLevel31;
    private TextView money;
    private AdView adView;
    private ImageView shop;
    public int countmoney;
    public final int coutLevel=20;//монетки за уровень
    public final int countads=40;//монетки за рекламу
    public final int levelSkipStop=31;//просто количество уровней
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_levels);

        MobileAds.initialize(this, "ca-app-pub-1454009650773931~3001729363");
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
        final int level = save.getInt("Level", 1);

        loadMani();


        onBack = (Button) findViewById(R.id.button4);
        shop = (ImageView) findViewById(R.id.shop);
        backLevel1 = (TextView) findViewById(R.id.TextView1);
        backLevel2 = (TextView) findViewById(R.id.TextView2);
        backLevel3 = (TextView) findViewById(R.id.TextView3);
        backLevel4 = (TextView) findViewById(R.id.TextView4);
        backLevel5 = (TextView) findViewById(R.id.TextView5);
        backLevel6 = (TextView) findViewById(R.id.TextView6);
        backLevel7 = (TextView) findViewById(R.id.TextView7);
        backLevel8 = (TextView) findViewById(R.id.TextView8);
        backLevel9 = (TextView) findViewById(R.id.TextView9);
        backLevel10 = (TextView) findViewById(R.id.TextView10);
        backLevel11 = (TextView) findViewById(R.id.TextView11);
        backLevel12 = (TextView) findViewById(R.id.TextView12);
        backLevel13 = (TextView) findViewById(R.id.TextView13);
        backLevel14 = (TextView) findViewById(R.id.TextView14);
        backLevel15 = (TextView) findViewById(R.id.TextView15);
        backLevel16 = (TextView) findViewById(R.id.TextView16);
        backLevel17 = (TextView) findViewById(R.id.TextView17);
        backLevel18 = (TextView) findViewById(R.id.TextView18);
        backLevel19 = (TextView) findViewById(R.id.TextView19);
        backLevel20 = (TextView) findViewById(R.id.TextView20);
        backLevel21 = (TextView) findViewById(R.id.TextView21);
        backLevel22 = (TextView) findViewById(R.id.TextView22);
        backLevel23 = (TextView) findViewById(R.id.TextView23);
        backLevel24 = (TextView) findViewById(R.id.TextView24);
        backLevel25 = (TextView) findViewById(R.id.TextView25);
        backLevel26 = (TextView) findViewById(R.id.TextView26);
        backLevel27 = (TextView) findViewById(R.id.TextView27);
        backLevel28 = (TextView) findViewById(R.id.TextView28);
        backLevel29 = (TextView) findViewById(R.id.TextView29);
        backLevel30 = (TextView) findViewById(R.id.TextView30);
        backLevel31 = (TextView) findViewById(R.id.TextView31);

        //Window w=getParent().getWindow();
        //w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        backLevel1.setOnClickListener(new View.OnClickListener() {//1111111111111111111111111111111111
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 1) {
                        Intent intent = new Intent(GameLevels.this, Level9L1.class);//Level1L1
                        startActivity(intent);
                        finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });    //11111111111
        backLevel2.setOnClickListener(new View.OnClickListener() {//2222222222222222222222222222222222
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 2) {
                        Intent intent = new Intent(GameLevels.this, Level2.class);//Level2L1
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });    //22222222222
        backLevel3.setOnClickListener(new View.OnClickListener() {//333333333333333333333333333333333
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 3) {
                        Intent intent = new Intent(GameLevels.this, Level10L1.class);// Level3L1
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });    //33333333333
        backLevel4.setOnClickListener(new View.OnClickListener() {//44444444444444444444444444444444
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 4) {
                        Intent intent = new Intent(GameLevels.this, Level1L1.class);// Level4L1
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });    //44444444444
        backLevel5.setOnClickListener(new View.OnClickListener() {//555555555555555555555555555555555
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 5) {
                        Intent intent = new Intent(GameLevels.this, Level2L1.class);// Level5L1
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });    //55555555555
        backLevel6.setOnClickListener(new View.OnClickListener() {//666666666666666666666666666666666
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 6) {
                        Intent intent = new Intent(GameLevels.this, Level3L1.class);// Level6L1
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });    //66666666666
        backLevel7.setOnClickListener(new View.OnClickListener() {//777777777777777777777777777777777
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 7) {
                        Intent intent = new Intent(GameLevels.this, Level4L1.class);// Level1
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });    //77777777777
        backLevel8.setOnClickListener(new View.OnClickListener() {//888888888888888888888888888888888
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 8) {
                        Intent intent = new Intent(GameLevels.this, Level5L1.class);// Level2
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });    //88888888888
        backLevel9.setOnClickListener(new View.OnClickListener() {//999999999999999999999999999999999   'fon1' restart
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 9) {
                        Intent intent = new Intent(GameLevels.this, Level6L1.class);// level9l1
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });    //99999999999
        backLevel10.setOnClickListener(new View.OnClickListener() {//10101010101010101010101010101010
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 10) {
                        Intent intent = new Intent(GameLevels.this, Level1.class);// level10l1
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });    //10-10-10-10-10
        backLevel11.setOnClickListener(new View.OnClickListener() {//11-11-11-11-11-11-11-11-11-11-11
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 11) {
                        Intent intent = new Intent(GameLevels.this, Level11.class);//level11
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });    //11-11-11-11-11
        backLevel12.setOnClickListener(new View.OnClickListener() {//12-12-12-12-12-12-12-12-12-12-12
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 12) {
                        Intent intent = new Intent(GameLevels.this, Level12.class);//level12
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });    //12-12-12-12-12
        backLevel13.setOnClickListener(new View.OnClickListener() {//13-13-13-13-13-13-13-13-13-13-13
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 13) {
                        Intent intent = new Intent(GameLevels.this, Level13.class);//level13
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });    //13-13-13-13-13
        backLevel14.setOnClickListener(new View.OnClickListener() {//14-14-14-14-14-14-14-14-14-14-14
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 14) {
                        Intent intent = new Intent(GameLevels.this, Level14.class);//level14
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });    //14-14-14-14-14
        backLevel15.setOnClickListener(new View.OnClickListener() {//15-15-15-15-15-15-15-15-15-15-15
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 15) {
                        Intent intent = new Intent(GameLevels.this, Level15.class);//level15
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });    //15-15-15-15-15
        backLevel16.setOnClickListener(new View.OnClickListener() {//16-16-16-16-16-16-16-16-16-16-16
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 16) {
                        Intent intent = new Intent(GameLevels.this, Level16.class);//level16
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });    //16-16-16-16-16
        backLevel17.setOnClickListener(new View.OnClickListener() {//17-17-17-17-17-17-17-17-17-17-17
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 17) {
                        Intent intent = new Intent(GameLevels.this, Level17.class);//level17
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });    //17-17-17-17-17
        backLevel18.setOnClickListener(new View.OnClickListener() {//18-18-18-18-18-18-18-18-18-18-18
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 18) {
                        Intent intent = new Intent(GameLevels.this, Level18.class);//level18
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });    //18-18-18-18-18
        backLevel19.setOnClickListener(new View.OnClickListener() {//19-19-19-19-19-19-19-19-19-19-19
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 19) {
                        Intent intent = new Intent(GameLevels.this, Level19.class);//level19
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });    //19-19-19-19-19
        backLevel20.setOnClickListener(new View.OnClickListener() {//20-20-20-20-20-20-20-20-20-20-20
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 20) {
                        Intent intent = new Intent(GameLevels.this, Level20.class);//level20
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });    //20-20-20-20-20
        backLevel21.setOnClickListener(new View.OnClickListener() {//21-21-21-21-21-21-21-21-21-21-21
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 21) {
                        Intent intent = new Intent(GameLevels.this, Level21.class);//level21
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });
        backLevel22.setOnClickListener(new View.OnClickListener() {//22-22-22-22-22-22-22-22-22-22-22
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 22) {
                        Intent intent = new Intent(GameLevels.this, Level22.class);//level22
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });
        backLevel23.setOnClickListener(new View.OnClickListener() {//23-23-23-23-23-23-23-23-23-23-23
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 23) {
                        Intent intent = new Intent(GameLevels.this, Level23.class);//level23
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });
        backLevel24.setOnClickListener(new View.OnClickListener() {//24-24-24-24-24-24-24-24-24-24-24
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 24) {
                        Intent intent = new Intent(GameLevels.this, Level24.class);//level24
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });
        backLevel25.setOnClickListener(new View.OnClickListener() {//25-25-25-25-25-25-25-25-25-25-25
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 25) {
                        Intent intent = new Intent(GameLevels.this, Level25.class);//level25
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });
        backLevel26.setOnClickListener(new View.OnClickListener() {//26-26-26-26-26-26-26-26-26-26-26
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 26) {
                        Intent intent = new Intent(GameLevels.this, Level26.class);//level26
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });
        backLevel27.setOnClickListener(new View.OnClickListener() {//27-27-27-27-27-27-27-27-27-27-27
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 27) {
                        Intent intent = new Intent(GameLevels.this, Level27.class);//level27
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });
        backLevel28.setOnClickListener(new View.OnClickListener() {//28-28-28-28-28-28-28-28-28-28-28
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 28) {
                        Intent intent = new Intent(GameLevels.this, Level28.class);//level28
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });
        backLevel29.setOnClickListener(new View.OnClickListener() {//29-29-29-29-29-29-29-29-29-29-29
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 29) {
                        Intent intent = new Intent(GameLevels.this, Level29.class);//level29
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });
        backLevel30.setOnClickListener(new View.OnClickListener() {//30-30-30-30-30-30-30-30-30-30-30
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 30) {
                        Intent intent = new Intent(GameLevels.this, Level30.class);
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });
        backLevel31.setOnClickListener(new View.OnClickListener() {//31-31-31-31-31-31-31-31-31-31-31
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 31) {
                        Intent intent = new Intent(GameLevels.this, Mail.class);
                        startActivity(intent);
                        //finish();
                    } else {
                    }
                } catch (Exception e) {
                }
            }
        });

        final int[] x = {R.id.TextView1, R.id.TextView2, R.id.TextView3, R.id.TextView4, R.id.TextView5,//изменять при добавлении уровней
                R.id.TextView6, R.id.TextView7, R.id.TextView8, R.id.TextView9, R.id.TextView10,
                R.id.TextView11, R.id.TextView12, R.id.TextView13, R.id.TextView14, R.id.TextView15,
                R.id.TextView16, R.id.TextView17, R.id.TextView18, R.id.TextView19, R.id.TextView20,
                R.id.TextView21, R.id.TextView22, R.id.TextView23, R.id.TextView24, R.id.TextView25,
                R.id.TextView26, R.id.TextView27, R.id.TextView28, R.id.TextView29, R.id.TextView30,
                R.id.TextView31};
        for (int i = 1; i < level; i++) {//можно try catch поставить
            TextView tv = findViewById(x[i]);
            if(i==30){
                tv.setText("(-_-)");
            }else{
            tv.setText("" + (i + 1));
            }
        }

        onBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sm.saveMani(this);
                Intent intent = new Intent(GameLevels.this, MainActivity.class);
                startActivity(intent); finish();
                finish();
            }
        });

            shop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent intent=new Intent(GameLevels.this,Shop.class);
                        startActivity(intent);
                    }catch (Exception e){}
                }
            });
    }
    public void saveMani() {
        preferences=getSharedPreferences("mani",MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putInt("money",countmoney);
        editor.commit();
        loadMani();
    }
    public void loadMani(){
        preferences=getSharedPreferences("mani",MODE_PRIVATE);//TODO: выдает ошибку
        countmoney=preferences.getInt("money",0);
        money=(TextView)findViewById(R.id.countMoney);
        money.setText(countmoney+"");
    }


    @Override
    public void onBackPressed() {
        saveMani();
        Intent intent=new Intent(GameLevels.this, MainActivity.class);
        startActivity(intent); finish();
    }
}
