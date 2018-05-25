package com.ether.minhphuong.ether_android.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.ether.minhphuong.ether_android.R;

/**
 * Created by minhphuong on 5/23/18.
 */

public class DialogUtils {

    public static AlertDialog showDialogInternet(Context context, DialogInterface.OnClickListener diaOnClickListenerz) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setTitle(context.getString(R.string.dialog_title_oops));
        builder.setMessage(context.getString(R.string.not_connect_internet));
        builder.setNegativeButton(context.getString(R.string.dialog_label_close), (dialogInterface, i) -> {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent);
        });
        builder.setPositiveButton(context.getString(R.string.dialog_label_retry), diaOnClickListenerz);
        AlertDialog dialog = builder.create();
        return dialog;
    }

//    public static Dialog showDialogLoading(Activity activity) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
//        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.dialog_dot_loading, null);
//        builder.setView(view);
//        builder.setCancelable(false);
//        AlertDialog dialog = builder.create();
//        if (dialog.getWindow() != null) {
//            dialog.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
//            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//        }
//        return dialog;
//    }


}
