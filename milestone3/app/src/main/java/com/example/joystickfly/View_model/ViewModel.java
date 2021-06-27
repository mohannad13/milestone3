package com.example.joystickfly.View_model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;


import com.example.joystickfly.BR;
import com.example.joystickfly.Views.JoystickView;
import com.example.joystickfly.Views.Server;
import com.example.joystickfly.model.Model;

public class ViewModel extends BaseObservable {
    private Model model;
    Server con;
    @Bindable
    public String getModelPort() {
        return model.getPort();
    }
    @Bindable
    public double getModelThrottle() {
        return model.getThrottle();
    }
    @Bindable
    public double getModelRudder() {
        return model.getRudder();
    }
    @Bindable
    public String getModelIp() {
        return model.getIp();
    }
    @Bindable
    public JoystickView getModelJoyStick() {
        return model.getJoystick();
    }
    public void setModelThrottle(double throttle) {
        model.setThrottle((double)throttle/100);
        notifyPropertyChanged(BR.modelThrottle);
    }
    public void setModelRudder(double rudder) {
        model.setRudder((double)rudder/100);
        notifyPropertyChanged(BR.modelRudder);
    }
    public void setModelPort(String Port) {
        model.setPort(Port);
        notifyPropertyChanged(BR.modelPort);
    }
    public void setModelIp(String ip) {
        model.setIp(ip);
        notifyPropertyChanged(BR.modelIp);
    }
    public void setModelIp(JoystickView joystickView) {
        model.setJoystick(joystickView);
        notifyPropertyChanged(BR.modelJoyStick);
    }
    public void onRudderClick(){
        Runnable runC = () -> con.sendCommand("set /controls/flight/rudder ",this.getModelRudder());
        Thread ServerThread = new Thread(runC);
        ServerThread.start();
    }
    public void onThrottleClick(){
        Runnable runC = () -> con.sendCommand("set /controls/engines/current-engine/throttle",this.getModelThrottle());
        Thread ServerThread = new Thread(runC);
        ServerThread.start();
    }
    public void onClickConnect(){

        Runnable client = () -> con.connect(this.getModelIp(),Integer.parseInt(this.getModelPort()));
        Thread serverThread = new Thread(client);
        serverThread.start();
    }
}
