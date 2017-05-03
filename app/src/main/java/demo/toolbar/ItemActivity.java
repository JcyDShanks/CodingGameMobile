package demo.toolbar;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by JcyDShanks on 2017/4/18.
 */

public class ItemActivity extends Activity {
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 123;
    private static final int MY_PERMISSIONS_REQUEST_SMS = 456;
    private MyAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_item);
        Toolbar toolbar3 = (Toolbar) findViewById(R.id.toolbar3);
        toolbar3.setTitle("Information");
        TextView nametv = (TextView) findViewById(R.id.name_display);
        TextView numbertv = (TextView) findViewById(R.id.number_display);
        final Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        final String number = intent.getStringExtra("number");
        nametv.setText(name);
        numbertv.setText(number);
        final Context mContext=this;
        Button buttonCall = (Button) findViewById(R.id.buttonCall);
        Button buttonSMS = (Button) findViewById(R.id.buttonSMS);
        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL,Uri.fromParts("tel",number,null));
                if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    ActivityCompat.requestPermissions((Activity) mContext, new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST_CALL_PHONE);
                    return;
                }
                ItemActivity.this.startActivity(intentCall);
            }
        });
        buttonSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFinalMessage=new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:"+number));
                if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    ActivityCompat.requestPermissions((Activity) mContext, new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_SMS);
                    return;
                }
                ItemActivity.this.startActivity(intentFinalMessage);

            }
        });

    }
}
