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
package br.feevale.jpe.bean;

/**
 * A Single process
 */
public class Process implements Comparable<Process> {

    private final Integer pid;
    private final Integer priority;
    private final Integer totalTime;
    private final Integer insertionTime;

    private Integer remainingTime;
    private Boolean finished;

    public Process(Integer pid, Integer priority, Integer totalTime, Integer currentTime) {
        this.pid = pid;
        this.priority = priority;
        this.totalTime = totalTime;
        this.remainingTime = totalTime;
        this.finished = false;
        this.insertionTime = currentTime;
    }

    public Integer getPid() {
        return pid;
    }

    public Integer getPriority() {
        return priority;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public Integer getRemainingTime() {
        return remainingTime;
    }

    public Integer getInsertionTime() {
        return insertionTime;
    }

    public void runProcess() {
        if (remainingTime > 0) {
            remainingTime--;
        }
        finished = remainingTime == 0;
    }

    public Boolean isFinished() {
        return finished;
    }

    @Override
    public int compareTo(Process o) {
        if (this.priority > o.getPriority()) {
            return 1;
        } else if (this.priority < o.getPriority()) {
            return -1;
        }
        return 0;
    }

}
