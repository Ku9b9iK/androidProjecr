package space.kubik.quizbelarus;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Mail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mail_infa);
        Button bt=(Button)findViewById(R.id.button4);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Mail.this, GameLevels.class);
                startActivity(intent); finish();
            }
        });
    }
    @Override
    public void onBackPressed(){
        Intent intent=new Intent(Mail.this,GameLevels.class);
        startActivity(intent); finish();
    }
}
