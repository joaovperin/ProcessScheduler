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

    private static final int SLEEP_DELAY = 300;

    private final List<br.feevale.jpe.core.Process> processes;

    private br.feevale.jpe.core.Process runningProcess;

    protected Boolean running;
    protected Integer quantum;
    protected Integer nextPid;
    protected Integer currentTime;
    protected Float computeValue;
    protected Integer numProcess;
    protected Boolean isThreadRunning;

    public AbstractScheduler() {
        super();
        this.processes = new ArrayList<>();
        resetScheduler();
    }

    @Override
    public final void resetScheduler() {
        processes.clear();
        this.running = false;
        this.quantum = 0;
        this.runningProcess = null;
        this.nextPid = 0;
        this.currentTime = 0;
        this.computeValue = 0f;
        this.numProcess = 0;
        this.isThreadRunning = true;
        MainFrame.outputTextArea.setText("");
        updateCounter();
    }

    protected abstract void pickProcess();

    @Override
    public final void run() {
        while (isThreadRunning) {
            try {
                if (running) {
                    currentTime++;
                    pickProcess();
                    if (hasRunningProcess()) {
                        runProcess();
                    }
                }
                updateCounter();
                updateRunningProcessInterface();
                Thread.sleep(SLEEP_DELAY);
            } catch (InterruptedException e) {
            }
        }
    }

    protected final void runProcess() {
        runningProcess.runProcess();
        if (runningProcess.isFinished()) {
            numProcess++;
            computeValue += currentTime - (runningProcess.getTotalTime() + runningProcess.getInsertionTime());
            processes.remove(runningProcess);
            runningProcess = null;
        }
    }

    private void updateRunningProcessInterface() {
        if (hasRunningProcess()) {
            MainFrame.outputTextArea.setText("RUNNING PROCESS PID = " + runningProcess.getPid());
            MainFrame.outputTextArea.append("\n");
            MainFrame.outputTextArea.append("PROCESS PRIORITY = " + runningProcess.getPriority());
            MainFrame.outputTextArea.append("\n");
            MainFrame.outputTextArea.append("INSERTION TIME = " + runningProcess.getInsertionTime());
            MainFrame.outputTextArea.append("\n");
            MainFrame.outputTextArea.append("REMAINING TIME = " + runningProcess.getRemainingTime());
        } else if (processes.stream().filter(br.feevale.jpe.core.Process::isFinished).count() == processes.size()) {
            MainFrame.outputTextArea.setText("IDLE!");
            if (numProcess != 0) {
                MainFrame.outputTextArea.append("\n");
                MainFrame.outputTextArea.append("AVERAGE WAITING TIME:" + (computeValue / numProcess));
            }
        }
    }

    private void updateCounter() {
        String labelCurrentTimeText = String.format("Current Time: %6d", currentTime);
        MainFrame.labelProcessCount.setText("Processes Count: " + processes.size());
        MainFrame.labelCurrentTime.setText(labelCurrentTimeText);
    }

    @Override
    public final void startRunning() {
        start();
    }

    @Override
    public final void addProcess(br.feevale.jpe.core.Process p) {
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
    public final void dispose() {
        isThreadRunning = false;
    }

    @Override
    public final Integer nextPid() {
        return nextPid++;
    }

    protected final boolean hasRunningProcess() {
        return runningProcess != null;
    }

    public Process getRunningProcess() {
        return runningProcess;
    }

    public void setRunningProcess(Process runningProcess) {
        this.runningProcess = runningProcess;
    }

    public List<Process> getProcesses() {
        return processes;
    }

}
