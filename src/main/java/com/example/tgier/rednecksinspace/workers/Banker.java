package com.example.tgier.rednecksinspace.workers;

import java.io.Serializable;
import java.util.Scanner;

public class Banker extends Worker implements Serializable {
    public Banker(String job, double payRate, double foodRequirements, double foodProduction, double mineralProduction,
                  double brainPowerProduction, boolean exhaustionStatus) {
        super(job, payRate, foodRequirements, foodProduction, mineralProduction, brainPowerProduction, exhaustionStatus);
    }

    public static Banker buildBanker() {
        Banker myBanker;
        System.out.println("How smart is your Banker? Pick between 2.0 and 4.0 ");
        double brainPow = new Scanner(System.in).nextDouble();
        if (brainPow < 2.0) {
            brainPow = 2.0;
        }
        if (brainPow > 4.0) {
            brainPow = 4.0;
        }

        double minProd = Math.sqrt(18 - (Math.pow(brainPow, 2.0)));
        double foodProd = Math.sqrt(18 - (Math.pow(brainPow, 2.0)));
        double pay = 0.5 * foodProd + 0.5 * minProd + 0.8 * brainPow;
        double foodReq = 0.2 * foodProd + 0.2 * minProd + 0.6 * brainPow;
        myBanker = new Banker("Banker", pay, foodReq, foodProd, minProd, brainPow, false);
        myBanker.introduceWorker();
        return myBanker;
    }
}
