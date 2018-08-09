package com.emailxl.deviceid;

import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.emailxl.deviceid.utils.ListAdapter;
import com.emailxl.deviceid.utils.Output;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String android_id = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        List<Output> hardware = new ArrayList<>();
        hardware.add(new Output(getString(R.string.android_id),android_id));
        hardware.add(new Output(getString(R.string.board), Build.BOARD));
        hardware.add(new Output(getString(R.string.bootloader), Build.BOOTLOADER));
        hardware.add(new Output(getString(R.string.brand), Build.BRAND));
        hardware.add(new Output(getString(R.string.device), Build.DEVICE));
        hardware.add(new Output(getString(R.string.display), Build.DISPLAY));
        hardware.add(new Output(getString(R.string.fingerprint), Build.FINGERPRINT));
        hardware.add(new Output(getString(R.string.hardware), Build.HARDWARE));
        hardware.add(new Output(getString(R.string.host), Build.HOST));
        hardware.add(new Output(getString(R.string.id), Build.ID));
        hardware.add(new Output(getString(R.string.manufacturer), Build.MANUFACTURER));
        hardware.add(new Output(getString(R.string.model), Build.MODEL));
        hardware.add(new Output(getString(R.string.product), Build.PRODUCT));
        hardware.add(new Output(getString(R.string.serial), Build.SERIAL));

        if (Build.VERSION.SDK_INT >= 21) {
            String[] abis = Build.SUPPORTED_ABIS;

            StringBuilder sb = new StringBuilder();
            if (abis.length > 0) {
                sb.append(abis[0]);

                for (int i = 1; i < abis.length; i++) {
                    sb.append(", ").append(abis[i]);
                }
            }

            hardware.add(new Output(getString(R.string.supported_abis), sb.toString()));
        }


        hardware.add(new Output(getString(R.string.tags), Build.TAGS));
        hardware.add(new Output(getString(R.string.time), String.valueOf(Build.TIME)));
        hardware.add(new Output(getString(R.string.type), Build.TYPE));
        hardware.add(new Output(getString(R.string.user), Build.USER));

        ListAdapter hardwareAdapter = new ListAdapter(this, R.layout.activity_item, hardware);

        ListView lvHardware = findViewById(R.id.hardware);
        lvHardware.setAdapter(hardwareAdapter);

        List<Output> software = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= 23) {
            software.add(new Output(getString(R.string.base_os), Build.VERSION.BASE_OS));
        }
        software.add(new Output(getString(R.string.codename), Build.VERSION.CODENAME));
        software.add(new Output(getString(R.string.incremental), Build.VERSION.INCREMENTAL));
        software.add(new Output(getString(R.string.release), Build.VERSION.RELEASE));
        software.add(new Output(getString(R.string.sdk_int), String.valueOf(Build.VERSION.SDK_INT)));
        if (Build.VERSION.SDK_INT >= 23) {
            software.add(new Output(getString(R.string.security_patch), Build.VERSION.SECURITY_PATCH));
        }

        ListAdapter softwareAdapter = new ListAdapter(this, R.layout.activity_item, software);

        ListView lvSoftware = findViewById(R.id.software);
        lvSoftware.setAdapter(softwareAdapter);
    }
}
