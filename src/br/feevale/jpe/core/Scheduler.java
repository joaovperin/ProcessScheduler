/*
 * Copyright (C) 2018 joaovperin
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
import br.feevale.jpe.bean.Process;
import java.util.ArrayList;
import java.util.List;

/**
 * Process Scheduler
 */
public class Scheduler extends Thread {

    List<Process> processes = new ArrayList<Process>();
    private Boolean running = true;
    private Integer quantum = 0;
    private Process runningProcess;
    private Integer nextPid = 0;
    private Integer currentTime = 0;

    public void addProcess(Process p) {
        processes.add(p);
        updateCounter();
    }

    public Integer getCurrentTime() {
        return currentTime;
    }

    private void updateCounter() {
        MainFrame.labelProcessCount.setText("Processes Count: " + processes.size());
        MainFrame.labelCurrentTime.setText("Current Time: " + currentTime);
    }

    public void setQuantum(Integer quantum) {
        this.quantum = quantum;
    }

    public void stopSchedler() {
        running = false;
    }

    public Integer nextPid() {
        return nextPid++;
    }

    @Override
    public void run() {
        while (running) {
            try {
                if (runningProcess == null) {
                    for (Process p : processes) {
                        if (!p.isFinished()) {
                            runningProcess = p;
                            break;
                        }
                    }
                }

                if (runningProcess == null) {
                    MainFrame.outputTextArea.setText("IDLE!");
                } else {
                    MainFrame.outputTextArea
                            .setText("RUNNING PROCESS PID = " +
                                    runningProcess.getPid());

                    MainFrame.outputTextArea.append("\n");

                    MainFrame.outputTextArea.append("INSERTION TIME = " +
                            runningProcess.getInsertionTime());

                    MainFrame.outputTextArea.append("\n");

                    MainFrame.outputTextArea.append("REMAINING TIME = " +
                            runningProcess.getRemainingTime());

                    runningProcess.runProcess();
                    if (runningProcess.isFinished()) {
                        processes.remove(runningProcess);
                        runningProcess = null;
                    }
                }

                currentTime++;
                updateCounter();
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
