package space.kubik.quizbelarus;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import space.kubik.quizbelarus.next_activity.AboutActivity;

public class MainActivity extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;
    public Button clickStart,about;
    private TextView razrab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Window w=getParent().getWindow();
        //w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        razrab=(TextView)findViewById(R.id.razrab);
        clickStart=(Button)findViewById(R.id.button2);
        about=(Button)findViewById(R.id.about);
        onClickStart();
    }
    public void onClickStart(){
        clickStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, GameLevels.class);
                startActivity(intent); finish();
            }
        });
        razrab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Razrab.class);
                startActivity(intent); finish();
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent); finish();
            }
        });

    }
    @Override
    public void onBackPressed(){
        if ( backPressedTime + 2000 > System.currentTimeMillis()){
            super.onBackPressed();
            return;
        }else{
            backToast = Toast.makeText(getBaseContext(),"нажмите еще раз чтобы выйти",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime=System.currentTimeMillis();
    }
}