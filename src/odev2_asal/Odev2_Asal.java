package odev2_asal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Odev2_Asal extends JFrame {
    public boolean bas = false;
    private static final int UPDATE_INTERVAL = 1000;
    public Odev2_Asal() {
        setTitle("Asal Sayılar");
        setSize(320, 200);
        JButton button = new JButton("2");
        JButton button2 = new JButton("3");
        JButton button3 = new JButton("5");
        JButton button4 = new JButton("7");
        JButton button5 = new JButton("11");
        JPanel ekran = new JPanel();
        ekran.setBackground(Color.MAGENTA);
        button.setBackground(Color.orange);
        button2.setBackground(Color.green);
        button3.setBackground(Color.CYAN);
        button4.setBackground(Color.yellow);
        button5.setBackground(Color.WHITE);
        ekran.add(button);
        ekran.add(button2);
        ekran.add(button3);
        ekran.add(button4);
        ekran.add(button5);
        this.getContentPane().add(ekran);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Thread updateThread = new Thread() {
            @Override
            public void run() {
                int dizi[] = new int[5];
                dizi[0] = 2;
                dizi[1] = 3;
                dizi[2] = 5;
                dizi[3] = 7;
                dizi[4] = 11;
                while (true) {
                    try {
                        int kontrol = 0;
                        for (int i = 12;; i++) {
                            for (int j = 2; j < i; j++) {
                                if (i % j == 0) {
                                    kontrol = 1;
                                }
                            }
                            if (kontrol == 0) {
                                dizi[0] = dizi[1];
                                dizi[1] = dizi[2];
                                dizi[2] = dizi[3];
                                dizi[3] = dizi[4];
                                dizi[4] = i;
                                button.setText(String.valueOf(dizi[0]));
                                button2.setText(String.valueOf(dizi[1]));
                                button3.setText(String.valueOf(dizi[2]));
                                button4.setText(String.valueOf(dizi[3]));
                                button5.setText(String.valueOf(dizi[4]));
                                Thread.sleep(1000);
                            } else {
                                kontrol = 0;
                            }
                        }
                    } catch (InterruptedException ignore) {
                    }
                }
            }
        };
        updateThread.start();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (bas == true) {
                    updateThread.resume();
                    System.out.println("Akıyor");
                    bas = false;
                } else {
                    updateThread.suspend();
                    System.out.println("Durduruldu");
                    bas = true;
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (bas == true) {
                    updateThread.resume();
                    System.out.println("Akıyor");
                    bas = false;
                } else {
                    updateThread.suspend();
                    System.out.println("Durduruldu");
                    bas = true;
                }
            }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (bas == true) {
                    updateThread.resume();
                    System.out.println("Akıyor");
                    bas = false;
                } else {
                    updateThread.suspend();
                    System.out.println("Durduruldu");
                    bas = true;
                }
            }
        });
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (bas == true) {
                    updateThread.resume();
                    System.out.println("Akıyor");
                    bas = false;
                } else {
                    updateThread.suspend();
                    System.out.println("Durduruldu");
                    bas = true;
                }
            }
        });
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (bas == true) {
                    updateThread.resume();
                    System.out.println("Akıyor");
                    bas = false;
                } else {
                    updateThread.suspend();
                    System.out.println("Durduruldu");
                    bas = true;
                }
            }
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Odev2_Asal(); // Let the constructor do the job
            }
        });
    }
}
