package cryptenet.thanatos.util;

import android.content.Context;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.util.Log;

public class DialogUtil {
    private static String TAG = DebugUtil.getTag(DialogUtil.class.getSimpleName());

    public static void showMessage(Context context, String title, String message, String pButton, boolean cancelable) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(context);
        }
        builder.setTitle(title)
                .setMessage(message)
                .setCancelable(cancelable)
                .setPositiveButton(pButton, (dialog, which) -> {
                    // continue with delete
                })
                .show();
    }

    public static void showMessageAbout(Context context) {
        showMessage(context, "About", AppInfo.getAboutInfo(), "Ok",true);
        Log.d("alert", AppInfo.getAboutInfo());
    }
}
