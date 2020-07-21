package pnj.uas.alia_ismayanti.View;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import pnj.uas.alia_ismayanti.EasyLocation;
import pnj.uas.alia_ismayanti.EasyLocationCallbacks;
import pnj.uas.alia_ismayanti.R;
import pnj.uas.alia_ismayanti.SelectedLocation;

public class MainActivity extends AppCompatActivity {
    private Button openDokterActivityBtn,openUploadActivityBtn;
    private EasyLocation easyLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        final Location loc = new Location("Maps");
        loc.setLatitude(-6.307421);
        loc.setLongitude(106.928649);

        openDokterActivityBtn = findViewById ( R.id.openDokterActivityBtn );
        openUploadActivityBtn = findViewById ( R.id.openUploadActivityBtn );

        openDokterActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ItemsActivity.class);
                startActivity(i);
            }
        });

        Button pickLocationBtn = findViewById(R.id.btnPickLocation);
        pickLocationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                easyLocation = new EasyLocation.Builder(MainActivity.this,"AIzaSyDN5ddrih49nZYoZ4Fzf4VcB1cFqtXg448")
                        .showCurrentLocation(true)
                        .useGeoCoder(true)
                        .setResultOnBackPressed(false)
                        .withLocation(loc)
                        .setCallbacks(new EasyLocationCallbacks() {
                            @Override
                            public void onSuccess(SelectedLocation location) {
                                Toast.makeText(MainActivity.this, location.toString(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailed(String reason) {
                                Toast.makeText(MainActivity.this, reason, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build();
            }
        });

        openUploadActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, UploadActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        easyLocation.onActivityResult(requestCode, resultCode, data);
    }


}
