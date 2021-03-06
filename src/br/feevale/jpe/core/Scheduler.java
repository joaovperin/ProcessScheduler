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

/**
 * A simple interface for schedulers
 */
public interface Scheduler {

    public void startScheduler();

    public void stopScheduler();

    public void setQuantum(Integer quantum);

    public Integer nextPid();

    public Integer getCurrentTime();

    public void addProcess(Process p);

    public void startRunning();

    public void resetScheduler();

    public void dispose();

}
