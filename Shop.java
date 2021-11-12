package space.kubik.quizbelarus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsParams;
import com.android.billingclient.api.SkuDetailsResponseListener;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop extends AppCompatActivity {
    SharedPreferences preferences;
    GameLevels gm=new GameLevels();
    private TextView money1;
    private Button buy,buy3;
    private ImageButton but30;
    private RewardedAd rewardedAd;
    private Map<String, SkuDetails> mSkuDetailsMap = new HashMap<>();
    private String mSkuId = "moneygame";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.un_shop);

        loadMani();
        ads();

        but30=(ImageButton)findViewById( R.id.But40);
        buy=(Button)findViewById(R.id.but100);
        buy3=(Button)findViewById(R.id.but3);


        but30.setOnClickListener(new View.OnClickListener() {//       просмотр рекламы за монетки
            @Override
            public void onClick(View v) {
                if (rewardedAd.isLoaded()) {
                    Activity activityContext = Shop.this;
                    RewardedAdCallback adCallback = new RewardedAdCallback() {
                        @Override
                        public void onRewardedAdOpened() {
                            // Ad opened.
                        }

                        @Override
                        public void onRewardedAdClosed() {
                            // Ad closed.
                        }

                        @Override
                        public void onUserEarnedReward(@NonNull RewardItem reward) {
                            // User earned reward.
                            gm.countmoney+=gm.countads;
                            saveMani();
                        }

                        @Override
                        public void onRewardedAdFailedToShow(AdError adError) {
                            // Ad failed to display.
                        }
                    };
                    rewardedAd.show(activityContext, adCallback);
                    ads();
                } else {
                    Log.d("TAG", "The rewarded ad wasn't loaded yet.");
                }
            }
        });

        buy.setOnClickListener(new View.OnClickListener() {//             пропуск уровней
            @Override
            public void onClick(View v) {
                SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                final int level = save.getInt("Level", 1);

                if(gm.countmoney>=100){
                    if(level < gm.levelSkipStop) {
                        gm.countmoney -= 100;
                        saveMani();

                        SharedPreferences.Editor editor = save.edit();
                        editor.putInt("Level", level + 1);
                        editor.commit();
                    }else {
                        Toast backToast = Toast.makeText(getBaseContext(), "Вы открыли все уровни", Toast.LENGTH_SHORT);
                        backToast.show();
                    }
                }else {
                    Toast backToast = Toast.makeText(getBaseContext(), "Не хватает монет", Toast.LENGTH_SHORT);
                    backToast.show();
                }
            }
        });


        Button bt=(Button)findViewById(R.id.button999);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent=new Intent(Shop.this,GameLevels.class);
                    startActivity(intent);finish();
                }catch (Exception e){}
            }
        });

    }


    public void saveMani() {
        preferences=getSharedPreferences("mani",MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putInt("money",gm.countmoney);
        editor.commit();
        loadMani();
    }
    public void loadMani(){
        preferences=getSharedPreferences("mani",MODE_PRIVATE);
        gm.countmoney=preferences.getInt("money",0);
        money1=(TextView)findViewById(R.id.countMoney4);
        money1.setText(gm.countmoney+"");
    }

    @Override
    public void onBackPressed(){
        Intent intent=new Intent(Shop.this,GameLevels.class);
        startActivity(intent); finish();
    }
    private void ads() {
        rewardedAd = new RewardedAd(this,
                "ca-app-pub-1454009650773931/1782487782");
        RewardedAdLoadCallback adLoadCallback = new RewardedAdLoadCallback() {
            @Override
            public void onRewardedAdLoaded() {
                // Ad successfully loaded.
            }


            @Override
            public void onRewardedAdFailedToLoad(LoadAdError adError) {
                // Ad failed to load.
            }
        };
        rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);
    }

    public void bunmoney(){

    }

}
