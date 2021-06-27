package com.example.joystickfly.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.joystickfly.R;

import android.widget.SeekBar;

import  com.example.joystickfly.View_model.ViewModel;
import com.example.joystickfly.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(new ViewModel());
        activityMainBinding.executePendingBindings();


        Server con = new Server();
        SeekBar rudderBar = findViewById(R.id.rudder);
        SeekBar throttleBar = findViewById(R.id.throttle);
        JoystickView joystick = findViewById(R.id.joystickView);


        rudderBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        throttleBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Runnable runC = () -> con.sendCommand("set /controls/engines/current-engine/throttle ",(double) progress/100);
                Thread ServerThread = new Thread(runC);
                ServerThread.start();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        joystick.setOnJoystickMoveListener((angle, power, direction) -> {
            Runnable runC = () -> con.sendCommand("set /controls/flight/aileron ",(double) angle/100);
            Thread ServerThread = new Thread(runC);
            ServerThread.start();
            Runnable runC2 = () -> con.sendCommand("set /controls/flight/elevator ",(double) power/100);
            Thread ServerThread2 = new Thread(runC2);
            ServerThread2.start();

        }, JoystickView.DEFAULT_LOOP_INTERVAL);
    }
}