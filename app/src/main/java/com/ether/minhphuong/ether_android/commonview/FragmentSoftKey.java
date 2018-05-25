package com.ether.minhphuong.ether_android.commonview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ether.minhphuong.ether_android.R;
import com.ether.minhphuong.ether_android.databinding.FragmentSoftKeyBinding;

/**
 * Created by minhphuong on 5/25/18.
 */

public class FragmentSoftKey extends Fragment implements View.OnClickListener{

    private FragmentSoftKeyBinding mBinding;
    private OnItemClicked mOnItemClicked;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_soft_key, container, false);
        initViews();
        return mBinding.getRoot();
    }

    private void initViews(){
        mBinding.btn0.setOnClickListener(this);
        mBinding.btn1.setOnClickListener(this);
        mBinding.btn2.setOnClickListener(this);
        mBinding.btn3.setOnClickListener(this);
        mBinding.btn4.setOnClickListener(this);
        mBinding.btn5.setOnClickListener(this);
        mBinding.btn6.setOnClickListener(this);
        mBinding.btn7.setOnClickListener(this);
        mBinding.btn8.setOnClickListener(this);
        mBinding.btn9.setOnClickListener(this);
        mBinding.btnDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        mOnItemClicked.onClicked(view);
    }

    public void setOnItemClicked(OnItemClicked onItemClicked) {
        this.mOnItemClicked = onItemClicked;
    }

    public interface OnItemClicked {
        void onClicked(View view);
    }

}
