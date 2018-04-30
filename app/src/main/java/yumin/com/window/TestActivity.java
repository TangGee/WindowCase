package yumin.com.window;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by mi on 18-4-29.
 */

public class TestActivity extends Activity {

    private int initSystemUIFlags;
    private int initWindowFlags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initWindowFlags= getWindow().getAttributes().flags;

        Intent intent = getIntent();
        int sysRstFlags = intent.getIntExtra(Const.EXTRA_REST_SYSM_FLAGS,initSystemUIFlags);
        int winRstFlags = intent.getIntExtra(Const.EXTRA_REST_WIND_FLAGS,initWindowFlags);
        int sysFlags = intent.getIntExtra(Const.EXTRA_SYS_FLAGS,0);
        int wintFlags = intent.getIntExtra(Const.EXTRA_WIN_FLAGS,0);
        initWindowFlags&=(~winRstFlags);
        wintFlags |= initWindowFlags;
        getWindow().getAttributes().flags = wintFlags;

        TextView textView = new TextView(this);
        textView.setText("adahsdahsdhasdh");
        setContentView(textView);

        getWindow().getDecorView().setSystemUiVisibility(sysFlags);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.RED));

    }
}
