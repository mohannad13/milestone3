package com.example.joystickfly.model;

import com.example.joystickfly.Views.JoystickView;

public class Model {
    String ip;
    String port;
    JoystickView joystick;
    double throttle;
    double rudder;

    public double getThrottle() {
        return throttle;
    }

    public void setThrottle(double throttle) {
        this.throttle = throttle;
    }

    public double getRudder() {
        return rudder;
    }

    public void setRudder(double rudder) {
        this.rudder = rudder;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public JoystickView getJoystick() {
        return joystick;
    }

    public void setJoystick(JoystickView joystick) {
        this.joystick = joystick;
    }
}
