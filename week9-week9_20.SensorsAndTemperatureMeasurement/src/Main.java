/**
 * This program demonstrates sensors and temperature measurement.
 * @author  Thang Cao
 * @since   06/18/2020
 * */

import application.ConstantSensor;

public class Main {
    public static void main(String[] args) {
        ConstantSensor ten = new ConstantSensor(10);
        ConstantSensor minusFive = new ConstantSensor(-5);

        System.out.println( ten.measure() );
        System.out.println( minusFive.measure() );

        System.out.println( ten.isOn() );
        ten.off();
        System.out.println( ten.isOn() );
    }
}
