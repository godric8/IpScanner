package com.yoofn.ipscanner;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private TextView mHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHello = (TextView) findViewById(R.id.hello);

        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("正在扫描");
        dialog.setCanceledOnTouchOutside(false);
        IpScanner ipScanner = new IpScanner();
        ipScanner.setOnScanListener(new IpScanner.OnScanListener() {
            @Override
            public void scan(Map<String, String> resultMap) {
                dialog.dismiss();
                mHello.setText(resultMap.toString());
            }
        });
        ipScanner.startScan();
        dialog.show();

    }

}
