package liziqiang.bawei.com.zhoukao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BoLangview boLangview = findViewById(R.id.bolangs);
        final ImageView imageView = findViewById(R.id.bolang);
        final RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        boLangview.animation(new BoLangview.AnimationListener() {
            @Override
            public void animation(float y) {
                params.setMargins(0,0,0, (int) y-50);
                imageView.setLayoutParams(params);

            }
        });
    }
}

