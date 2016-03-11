package com.bili.diushoujuaner.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bili.diushoujuaner.R;
import com.bili.diushoujuaner.base.BaseActivity;
import com.bili.diushoujuaner.presenter.presenter.LoginActivityPresenter;
import com.bili.diushoujuaner.presenter.viewinterface.LoginActivityView;
import com.bili.diushoujuaner.widget.CustomProgress;
import com.bili.diushoujuaner.widget.CustomToast;

import butterknife.Bind;

public class LoginActivity extends BaseActivity implements LoginActivityView, View.OnClickListener {

    @Bind(R.id.textRight)
    TextView textRight;
    @Bind(R.id.btnLogin)
    Button btnLogin;
    @Bind(R.id.textForgetPsd)
    TextView textForgetPsd;
    @Bind(R.id.textMobile)
    EditText textMobile;
    @Bind(R.id.textPassword)
    EditText textPassword;

    @Override
    public void tintStatusColor() {
        super.tintStatusColor();
        tintManager.setStatusBarTintResource(R.color.TRANSPARENT);
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_login);
    }

    @Override
    public void setViewStatus() {
        showPageHead(null, null, "新用户");

        btnLogin.setOnClickListener(this);
        basePresenter = new LoginActivityPresenter(this);
    }

    @Override
    public void LoginSuccess() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void LoginFail(String errorMsg) {
        CustomToast.getInstance().showWarning(context, errorMsg);
    }

    @Override
    public void showLoading() {
        CustomProgress.getInstance(context).show(getResources().getString(R.string.loging_status), true, null);
    }

    @Override
    public void hideLoading() {
        CustomProgress.getInstance(context).dismiss();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                getPresenterByClass(LoginActivityPresenter.class).getUserLogin(textMobile.getText().toString().trim(), textPassword.getText().toString().trim());
                break;
        }
    }

}
