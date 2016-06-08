package com.wrightcontrol.zebraxross;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Grant on 08/06/2016.
 */
public abstract class SingleFragmentActivity  extends AppCompatActivity {

    protected abstract Fragment createFragment();
    protected abstract int getLayout();
    protected abstract int getContainerID();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayout());

        int containerID = getContainerID();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = fragmentManager.findFragmentById(containerID);
        Fragment content;

        if (fragment == null) {
            content = createFragment();
            fragmentTransaction.add(containerID, content);
            fragmentTransaction.commit();
        }
    }
}
