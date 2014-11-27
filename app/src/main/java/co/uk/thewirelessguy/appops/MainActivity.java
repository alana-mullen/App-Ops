package co.uk.thewirelessguy.appops;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Launches the app ops settings then finishes itself.
        Intent intent = new Intent("android.settings.APP_OPS_SETTINGS");
        if (isCallable(intent)){
            startActivity(intent);
        } else {
            Toast.makeText(this,"Sorry App Ops doesn't work on this version of Android. It only works on Android 4.3 to 4.4.1.",Toast.LENGTH_LONG).show();
        }
        finish();
    }

    private boolean isCallable(Intent intent) {
        List<ResolveInfo> list = getPackageManager().queryIntentActivities(intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }

    
}
