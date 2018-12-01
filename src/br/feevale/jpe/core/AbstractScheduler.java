/*
 * Copyright (C) 2018 Perin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.feevale.jpe.core;

import br.feevale.jpe.gui.MainFrame;
import java.util.ArrayList;
import java.util.List;

/**
 * An abstract scheduler
 */
public abstract class AbstractScheduler extends Thread implements Scheduler {

    private static final int SLEEP_DELAY = 200;

    protected final List<br.feevale.jpe.bean.Process> processes;

    protected Boolean running;
    protected Integer quantum;
    protected br.feevale.jpe.bean.Process runningProcess;
    protected Integer nextPid;
    protected Integer currentTime;

    public AbstractScheduler() {
        super();
        this.processes = new ArrayList<>();
        resetScheduler();
    }

    @Override
    public final void startRunning() {
        start();
    }

    @Override
    public final void addProcess(br.feevale.jpe.bean.Process p) {
        processes.add(p);
        updateCounter();
    }

    @Override
    public final Integer getCurrentTime() {
        return currentTime;
    }

    @Override
    public final void setQuantum(Integer quantum) {
        this.quantum = quantum;
    }

    @Override
    public final void startScheduler() {
        running = true;
    }

    @Override
    public final void stopScheduler() {
        running = false;
    }

    @Override
    public final void resetScheduler() {
        processes.clear();
        this.running = false;
        this.quantum = 0;
        this.runningProcess = null;
        this.nextPid = 0;
        this.currentTime = 0;
        MainFrame.outputTextArea.setText("");
        updateCounter();
    }

    @Override
    public final Integer nextPid() {
        return nextPid++;
    }

    @Override
    public final void run() {
        while (true) {
            try {
                if (running) {
                    doLoop();
                } else {
                    updateCounter();
                }
                Thread.sleep(SLEEP_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace(System.out);
            }
        }
    }

    private void doLoop() {
        if (!hasRunningProcess()) {
            pickProcess();
        }

        updateRunningProcessInterface();

        if (hasRunningProcess()) {
            runProcess();
        }

        currentTime++;
        updateCounter();
    }

    private void pickProcess() {
        for (br.feevale.jpe.bean.Process p : processes) {
            if (!p.isFinished()) {
                runningProcess = p;
                break;
            }
        }
    }

    private void runProcess() {
        runningProcess.runProcess();
        if (runningProcess.isFinished()) {
            processes.remove(runningProcess);
            runningProcess = null;
        }
    }

    private boolean hasRunningProcess() {
        return runningProcess != null;
    }

    private void updateRunningProcessInterface() {
        if (hasRunningProcess()) {
            MainFrame.outputTextArea.setText("RUNNING PROCESS PID = " + runningProcess.getPid());
            MainFrame.outputTextArea.append("\n");
            MainFrame.outputTextArea.setText("PROCESS PRIORITY = " + runningProcess.getPriority());
            MainFrame.outputTextArea.append("\n");
            MainFrame.outputTextArea.append("INSERTION TIME = " + runningProcess.getInsertionTime());
            MainFrame.outputTextArea.append("\n");
            MainFrame.outputTextArea.append("REMAINING TIME = " + runningProcess.getRemainingTime());
        } else {
            MainFrame.outputTextArea.setText("IDLE!");
        }
    }

    private void updateCounter() {
        String labelCurrentTimeText = String.format("Current Time: %6d", currentTime);
        MainFrame.labelProcessCount.setText("Processes Count: " + processes.size());
        MainFrame.labelCurrentTime.setText(labelCurrentTimeText);
    }

}
