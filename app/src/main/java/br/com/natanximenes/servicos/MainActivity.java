package br.com.natanximenes.servicos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button startServiceButton, stopServiceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startServiceButton = (Button) findViewById(R.id.main_bt_service_start);
        startServiceButton.setOnClickListener(this);
        stopServiceButton = (Button) findViewById(R.id.main_bt_service_stop);
        stopServiceButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MainThreadService.class);
        switch (view.getId()) {
            case R.id.main_bt_service_start:
                startService(intent);
                break;
            case R.id.main_bt_service_stop:
                stopService(intent);
                break;
            default:
                break;
        }
    }
}
