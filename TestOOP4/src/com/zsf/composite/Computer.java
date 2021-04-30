package com.zsf.composite;

public class Computer {
    private Cpu cpu = new Cpu();
    private MainBoard mainBoard = new MainBoard();
    private Memory memory = new Memory();

    public void work(){
        cpu.calc();
        cpu.control();
        memory.store();
        mainBoard.connect();
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.work();
    }
}
