package org.raphets.demorealm.activity;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.raphets.demorealm.R;
import org.raphets.demorealm.util.RealmHelper;

import butterknife.BindView;
import butterknife.OnClick;

public class UpdateActivity extends BaseActivity {
    @BindView(R.id.toolBar)
    Toolbar mToolbar;
    @BindView(R.id.et_name)
    EditText etName;

    private RealmHelper mRealmHelper;
    private String mId;

    @Override
    public int getLayoutId() {
        return R.layout.activity_update;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbar(mToolbar, "改");

        initData();
    }

    private void initData() {
        mRealmHelper=new RealmHelper(this);
        mId=getIntent().getStringExtra("id");
    }

    @OnClick(R.id.btn_update)
    void onClick(View v) {
        String name=etName.getText().toString().trim();
        if (TextUtils.isEmpty(name)){
            Toast.makeText(UpdateActivity.this,"请输入名称",Toast.LENGTH_SHORT).show();
            return;
        }

        mRealmHelper.updateDog(mId,name);

        setResult(RESULT_OK);
        finish();
    }
}
