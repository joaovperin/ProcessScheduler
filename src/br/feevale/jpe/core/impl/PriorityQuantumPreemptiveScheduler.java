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
package br.feevale.jpe.core.impl;

import br.feevale.jpe.core.AbstractScheduler;

/**
 * Process Scheduler
 */
public class PriorityQuantumPreemptiveScheduler extends AbstractScheduler {

    @Override
    protected final void pickProcess() {
        // Obtains the highest priority
        Integer higherPriority = getProcesses().stream().map(p -> p.getPriority()).
                sorted().findFirst().orElse(Integer.MAX_VALUE);

        // Pick a process to run looking to the quantum
        getProcesses().stream().filter(p -> p.getPriority().equals(higherPriority)).forEach(p -> {
            if (!hasRunningProcess()) {
                setRunningProcess(p);
            }
            if (getRunningProcess() != p && getRunningProcess().isQuantumFinished() && !p.isQuantumFinished()) {
                setRunningProcess(p);
            }
        });

        // If the running process achieved it's quantum, pick another
        if (hasRunningProcess() && getRunningProcess().isQuantumFinished()) {
            setRunningProcess(null);
            getProcesses().stream().filter(p -> p.getPriority().equals(higherPriority)).forEach(p -> {
                if (!hasRunningProcess()) {
                    setRunningProcess(p);
                }
                p.resetQuantumFinish();
            });
        }
    }

}
