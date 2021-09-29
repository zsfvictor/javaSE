package com.zsf.lock2;

public class Test13 {
        public static void main(String[] args) {
            driveCar(new Car(){
                @Override
                public void drive() {
                        System.out.println("驾驶着BMW汽车");
                    }
                });
            }
            public static void driveCar(Car car){
                car.drive();
            }
        }

        interface Car {
            void drive();
        }


