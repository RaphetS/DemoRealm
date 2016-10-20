package org.raphets.demorealm.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import org.raphets.demorealm.R;
import org.raphets.demorealm.bean.Dog;
import org.raphets.demorealm.util.RealmHelper;

import java.util.List;

/**
 * Created by matou0289 on 2016/10/20.
 */

public class DogAdapter extends BaseAdapter<Dog> {

    private RealmHelper mRealmHleper;

    public DogAdapter(Context mContext, List<Dog> mDatas, int mLayoutId) {
        super(mContext, mDatas, mLayoutId);
        mRealmHleper = new RealmHelper(mContext);
    }

    @Override
    protected void convert(Context mContext, BaseViewHolder holder, final Dog dog) {
        holder.setText(R.id.tv_name, dog.getName())
                .setText(R.id.tv_id, dog.getId());

        final ImageView iv = holder.getView(R.id.iv_like);

        if (mRealmHleper.isDogExist(dog.getId())) {
            iv.setSelected(true);
        } else {
            iv.setSelected(false);
        }


        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iv.isSelected()) {
                    iv.setSelected(false);
                    mRealmHleper.deleteDog(dog.getId());
                } else {
                    iv.setSelected(true);
                    mRealmHleper.addDog(dog);
                }
            }
        });


    }
}
