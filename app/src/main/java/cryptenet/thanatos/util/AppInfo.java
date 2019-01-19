package cryptenet.thanatos.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;

import cryptenet.thanatos.smart_tour_guide.MainApplication;
import cryptenet.thanatos.smart_tour_guide.R;

public class AppInfo {
    private static String TAG = DebugUtil.getTag(DialogUtil.class.getSimpleName());
    private static Context context = MainApplication.getContext();

    public static final String APP_NAME = context.getResources().getString(R.string.app_name);
    public static final String APP_PACKAGE = context.getPackageName();
    public static final String APP_LINK = "https://play.google.com/store/apps/details?id=" + APP_PACKAGE;

    public static final String DEVELOPER_CODE = context.getResources().getString(R.string.app_developer_company);
    public static final String DEVELOPER_NAME = context.getResources().getString(R.string.app_developer_name);
    public static final String DEVELOPER_EMAIL = context.getResources().getString(R.string.app_developer_email);

    public static final int SPLASH_TIME_OUT = 5000;

    private static String getAppVersionName() {
        String s = null;
        try {
            PackageInfo pInfo = context.getPackageManager().getPackageInfo(
                    APP_PACKAGE, 0);
            s = pInfo.versionName;
            Log.d(TAG, "Version Name: " + s);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (s == null)
            s = "ERROR";

        return s;
    }

    public static String getAboutInfo() {

        String info;

        info = APP_NAME + "\nVersion : " + getAppVersionName()
                + "\nCopyright © 2018, RaihanSadeq" + "\nDeveloper : " + DEVELOPER_CODE
                + "\nContact : " + DEVELOPER_EMAIL + "\n";

        return info;
    }
}
