package library.saurabh.com.horizontalscale;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import library.saurabh.com.horizontalscale.widget.spinnerWheel.adapters.NumericWheelAdapter;
import library.saurabh.com.horizontalscale.widget.spinnerWheel.spinnerwheel.AbstractWheel;
import library.saurabh.com.horizontalscale.widget.spinnerWheel.spinnerwheel.OnWheelChangedListener;

public class HomeActivity extends AppCompatActivity {

    public AbstractWheel bgWheel;
    NumericWheelAdapter bgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bgWheel = (AbstractWheel) findViewById(R.id.mins);
        bgAdapter = new NumericWheelAdapter(HomeActivity.this, 0, 600, "%02d");
        bgAdapter.setItemResource(R.layout.wheel_text_centered_dark_back);
        bgAdapter.setItemTextResource(R.id.text);
        bgWheel.setViewAdapter(bgAdapter);
    }
}
