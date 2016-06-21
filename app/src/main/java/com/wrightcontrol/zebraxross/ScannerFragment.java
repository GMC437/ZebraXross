package com.wrightcontrol.zebraxross;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

/**
 * Created by Grant on 08/06/2016.
 */
public class ScannerFragment extends Fragment {

    private String toastMessage;
    private Button scanButton;

    public static ScannerFragment newInstance() {
        return new ScannerFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scan_home, container, false);

        instantiateWidgets(view);

        return view;
    }

    private void instantiateWidgets(View view) {
        scanButton = (Button) view.findViewById(R.id.button_scan);
        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanFromFragment();
            }
        });
    }

    public void scanFromFragment() {
        IntentIntegrator.forSupportFragment(this).initiateScan();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                toastMessage = "Cancelled from fragment";
            } else {
                toastMessage = "Scanned from fragment: " + result.getContents();
            }

            // At this point we may or may not have a reference to the activity
            displayToast();
        }


    }

    private void displayToast() {
        if (getActivity() != null && toastMessage != null) {
            Toast.makeText(getActivity(), toastMessage, Toast.LENGTH_LONG).show();
            toastMessage = null;
        }
    }
}
