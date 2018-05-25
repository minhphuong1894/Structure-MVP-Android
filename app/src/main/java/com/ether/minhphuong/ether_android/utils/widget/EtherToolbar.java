package com.ether.minhphuong.ether_android.utils.widget;

import android.content.Context;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ether.minhphuong.ether_android.R;

/**
 * Created by minhphuong on 5/23/18.
 */

public class EtherToolbar extends Toolbar {

    private TextView tvTitle;

    public EtherToolbar(Context context) {
        super(context);
        this.tvTitle = new TextView(context);
        this.addView(this.tvTitle);
        setupDefault(context);
    }

    public EtherToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.tvTitle = new TextView(context, attrs);
        this.addView(this.tvTitle);
        setupDefault(context);
    }

    public EtherToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.tvTitle = new TextView(context, attrs, defStyleAttr);
        this.addView(this.tvTitle);
        setupDefault(context);
    }

    private void setupDefault(Context context) {
        Toolbar.LayoutParams titleLayoutParams =
                new Toolbar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
        titleLayoutParams.gravity = Gravity.CENTER;
        this.tvTitle.setLayoutParams(titleLayoutParams);
        this.tvTitle.setMaxLines(1);
        this.tvTitle.setEllipsize(TextUtils.TruncateAt.END);
        this.tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        this.tvTitle.setTextColor(ContextCompat.getColor(context, R.color.colorWhite));
    }

    @Override
    public void setTitle(@StringRes int resId) {
        super.setTitle(null);
        this.tvTitle.setText(resId);
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle("");
        this.tvTitle.setText(title);
    }

}
