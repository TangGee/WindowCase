package yumin.com.window;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import yumin.com.window.R;

/**
 * Created by mi on 18-4-23.
 */

public class Tester implements View.OnClickListener{

    public static final int REST_WIN_FLAGS = WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS
            | WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
            | WindowManager.LayoutParams.FLAG_FULLSCREEN
            | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
            | WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR
            | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;

    public static final int REST_SYS_FLAGS = View.SYSTEM_UI_FLAG_FULLSCREEN
            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_IMMERSIVE
            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN ;



    private int initSystemUIFlags = 0;
    private int initWindowFlags = 0;

    private CheckBox S_FULLSCREEN;
    private CheckBox S_HIDE_NAVIGATION;
    private CheckBox S_IMMERSIVE;
    private CheckBox S_IMMERSIVE_STICKY;
    private CheckBox S_L_HIDE_NAVIGATION;
    private CheckBox S_L_FULLSCREEN;


    private CheckBox F_BAR_BG;
    private CheckBox F_TRANSLUCENT_STATUS;
    private CheckBox F_FULLSCREEN;
    private CheckBox F_TRANSLUCENT_NAV;
    private CheckBox F_L_IN_SCREEN;
    private CheckBox F_L_INSET_DECOR;


    private Button runSystemUI;
    private Button runWindow;
    private Button newActivity;

    private Activity mActivity;

    public Tester(Activity activity){

        mActivity = activity;

        runSystemUI = activity.findViewById(R.id.run);
        runWindow = activity.findViewById(R.id.runWindow);
        newActivity  = activity.findViewById(R.id.newActivity);
        S_FULLSCREEN = activity.findViewById(R.id.S_FULLSCREEN);
        S_HIDE_NAVIGATION = activity.findViewById(R.id.S_HIDE_NAVIGATION);
        S_IMMERSIVE = activity.findViewById(R.id.S_IMMERSIVE);
        S_IMMERSIVE_STICKY = activity.findViewById(R.id.S_IMMERSIVE_STICKY);
        S_L_HIDE_NAVIGATION = activity.findViewById(R.id.S_L_HIDE_NAVIGATION);
        S_L_FULLSCREEN = activity.findViewById(R.id.S_L_FULLSCREEN);
        F_BAR_BG = activity.findViewById(R.id.F_BAR_BG);
        F_TRANSLUCENT_STATUS = activity.findViewById(R.id.F_TRANSLUCENT_STATUS);
        F_FULLSCREEN = activity.findViewById(R.id.F_FULLSCREEN);

        F_TRANSLUCENT_NAV = activity.findViewById(R.id.F_TRANSLUCENT_NAV);
        F_L_IN_SCREEN = activity.findViewById(R.id.F_L_IN_SCREEN);
        F_L_INSET_DECOR = activity.findViewById(R.id.F_L_INSET_DECOR);

        runSystemUI.setOnClickListener(this);
        runWindow.setOnClickListener(this);
        newActivity.setOnClickListener(this);
    }

    public void onClick(View v){
        int wFlags = 0;
        int sysFlags = 0;
        if (S_FULLSCREEN.isChecked()){
            sysFlags |= View.SYSTEM_UI_FLAG_FULLSCREEN;
        }
        if (S_HIDE_NAVIGATION.isChecked()){
            sysFlags |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        }
        if (S_IMMERSIVE.isChecked()){
            sysFlags |= View.SYSTEM_UI_FLAG_IMMERSIVE;
        }
        if (S_IMMERSIVE_STICKY.isChecked()){
            sysFlags |= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        }
        if (S_L_HIDE_NAVIGATION.isChecked()){
            sysFlags |= View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        }
        if (S_L_FULLSCREEN.isChecked()){
            sysFlags |= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
        }

        if (F_BAR_BG.isChecked()){
            wFlags |= WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS;
        }
        if (F_TRANSLUCENT_STATUS.isChecked()){
            wFlags |= WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        }

        if (F_FULLSCREEN.isChecked()){
            wFlags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        }
        if (F_TRANSLUCENT_NAV.isChecked()){
            wFlags |= WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
        }
        if (F_L_IN_SCREEN.isChecked()){
            wFlags |= WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
        }
        if (F_L_INSET_DECOR.isChecked()){
            wFlags |= WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR;
        }

        switch (v.getId()){
            case R.id.run:
                int newUiOptions = initSystemUIFlags;
                mActivity.getWindow().getDecorView().setSystemUiVisibility(newUiOptions);
                break;
            case R.id.runWindow:
                int newWindowOp = initWindowFlags;
                mActivity.getWindow().getAttributes().flags = newWindowOp;
                break;
            case R.id.newActivity:
                Intent intent = new Intent(mActivity,TestActivity.class);
                intent.putExtra(Const.EXTRA_REST_SYSM_FLAGS,REST_SYS_FLAGS);
                intent.putExtra(Const.EXTRA_REST_WIND_FLAGS,REST_WIN_FLAGS);
                intent.putExtra(Const.EXTRA_WIN_FLAGS,wFlags);
                intent.putExtra(Const.EXTRA_SYS_FLAGS,sysFlags);
                mActivity.startActivity(intent);
                break;
        }
    }

}
