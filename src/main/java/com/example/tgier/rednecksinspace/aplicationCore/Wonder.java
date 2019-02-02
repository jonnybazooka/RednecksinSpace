package com.example.tgier.rednecksinspace.aplicationCore;

import android.widget.Toast;
import com.example.tgier.rednecksinspace.MainActivity;

public class Wonder {

    private double wonderConstructionProgress;
    private double wonderBuildEfficiency;
    private boolean wonderBuiltThisTurn;

    public Wonder(double wonderConstructionProgress, double wonderBuildEfficiency, boolean wonderBuiltThisTurn) {
        this.wonderConstructionProgress = wonderConstructionProgress;
        this.wonderBuildEfficiency = wonderBuildEfficiency;
        this.wonderBuiltThisTurn = wonderBuiltThisTurn;
    }

    public double getWonderConstructionProgress() {
        return wonderConstructionProgress;
    }

    public void setWonderConstructionProgress(double wonderConstructionProgress) {
        this.wonderConstructionProgress = wonderConstructionProgress;
    }

    public double getWonderBuildEfficiency() {
        return wonderBuildEfficiency;
    }

    public void setWonderBuildEfficiency(double wonderBuildEfficiency) {
        this.wonderBuildEfficiency = wonderBuildEfficiency;
    }

    public boolean isWonderBuiltThisTurn() {
        return wonderBuiltThisTurn;
    }

    public void setWonderBuiltThisTurn(boolean wonderBuiltThisTurn) {
        this.wonderBuiltThisTurn = wonderBuiltThisTurn;
    }

    public void constructWonder(Resources resources) {
        if (resources.getMineralResources() >= 5 && !wonderBuiltThisTurn) {
            wonderConstructionProgress = wonderConstructionProgress + (5 * wonderBuildEfficiency);
            resources.setMineralResources(resources.getMineralResources() - 5);
            wonderBuiltThisTurn = true;
        }
    }

    public void checkVictoryCondition() {
        if (wonderConstructionProgress >= 50) {
            System.out.println("CONGRATULATIONS! YOU HAVE WON!");
            App.gameContinue = false;
        }
    }
}
