package org.raphets.demorealm.util;

import android.content.Context;

import org.raphets.demorealm.bean.Dog;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by matou0289 on 2016/10/20.
 */

public class RealmHelper {
    private static final String DB_NAME = "myRealm.realm";
    private Realm mRealm;


    public RealmHelper(Context context) {
        Realm.init(context);
        mRealm = Realm.getInstance(new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .name(DB_NAME)
                .build());
    }

    /**
     * add （增）
     */
    public void addDog(Dog dog) {
        mRealm.beginTransaction();
        mRealm.copyToRealm(dog);
        mRealm.commitTransaction();
    }

    /**
     * delete （删）
     */
    public void deleteDog(String id) {
        Dog dog = mRealm.where(Dog.class).equalTo("id", id).findFirst();
        mRealm.beginTransaction();
        dog.deleteFromRealm();
        mRealm.commitTransaction();
    }

    /**
     * update （改）
     */
    public void updateDog(String id, String newName) {
        Dog dog = mRealm.where(Dog.class).equalTo("id", id).findFirst();
        mRealm.beginTransaction();
        dog.setName(newName);
        mRealm.commitTransaction();
    }

    /**
     * query （查询所有）
     */
    public List<Dog> queryAllDog() {
        RealmResults<Dog> dogs = mRealm.where(Dog.class).findAll();
        /**
         * 对查询结果，按Id进行排序，只能对查询结果进行排序
         */
        dogs=dogs.sort("id");
        return mRealm.copyFromRealm(dogs);
    }

    /**
     * query （根据Id（主键）查）
     */
    public Dog queryDogById(String id) {
        Dog dog = mRealm.where(Dog.class).equalTo("id", id).findFirst();
        return dog;
    }


    /**
     * query （根据age查）
     */
    public List<Dog> queryDobByAge(int age) {
        RealmResults<Dog> dogs = mRealm.where(Dog.class).equalTo("age", age).findAll();

        return mRealm.copyFromRealm(dogs);
    }

    public boolean isDogExist(String id){
        Dog dog=mRealm.where(Dog.class).equalTo("id",id).findFirst();
        if (dog==null){
            return false;
        }else {
            return  true;
        }
    }
}
