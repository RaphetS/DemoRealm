package org.raphets.demorealm.activity;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import org.raphets.demorealm.R;
import org.raphets.demorealm.bean.Dog;
import org.raphets.demorealm.util.RealmHelper;

import butterknife.BindView;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * 其他查询
 */
public class OtherQueryActivity extends BaseActivity {
    @BindView(R.id.toolBar)
    Toolbar mToolbar;

    @BindView(R.id.tv_average_age)
    TextView tvAverage;//平均年龄
    @BindView(R.id.tv_sum_age)
    TextView tvSumAge;//总年龄
    @BindView(R.id.tv_max_id)
    TextView tvMaxId;

    private Realm mRealm;

    @Override
    public int getLayoutId() {
        return R.layout.activity_other_query;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbar(mToolbar,"其他查询");

        mRealm=Realm.getDefaultInstance();

        getAverageAge();

        getSumAge();

        getMaxId();
    }

    /**
     *  查询平均年龄
     */
    private void getAverageAge() {
         double avgAge=  mRealm.where(Dog.class).findAll().average("age");
        tvAverage.setText(avgAge+"岁");
    }

    /**
     *  查询总年龄
     */
    private void getSumAge() {
      Number sum=  mRealm.where(Dog.class).findAll().sum("age");
        int sumAge=sum.intValue();
        tvSumAge.setText(sumAge+"岁");
    }

    /**
     *  查询最大年龄
     */
    private void getMaxId(){
      Number max=  mRealm.where(Dog.class).findAll().max("age");
        int maxAge=max.intValue();
        tvMaxId.setText(maxAge+"岁");
    }
}
