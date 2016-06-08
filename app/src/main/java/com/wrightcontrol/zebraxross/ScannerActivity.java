package com.wrightcontrol.zebraxross;

import android.support.v4.app.Fragment;

public class ScannerActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return ScannerFragment.newInstance();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_container;
    }

    @Override
    protected int getContainerID() {
        return R.id.fragment_container;
    }
}
