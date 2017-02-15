package fakeaccount.com.saltedge.utils;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

import fakeaccount.com.saltedge.R;

public class UITools {

    public static AlertDialog showAlertDialog(Context context,String title, String message, DialogInterface.OnClickListener listener) {
        AlertDialog.Builder adb = new AlertDialog.Builder(context);
        adb.setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, listener);
        return adb.show();
    }

    public static void destroyAlertDialog(AlertDialog dialog) {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public static ProgressDialog createProgressDialog(Context context, String title) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.show();
        dialog.setIndeterminate(true);
        dialog.setContentView(R.layout.layout_progress_dialog);
        dialog.setMessage(title);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.hide();
        return dialog;
    }

    public static void destroyProgressDialog(ProgressDialog dialog) {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public static void showProgressDialog(ProgressDialog dialog) {
        dialog.show();
    }

}
