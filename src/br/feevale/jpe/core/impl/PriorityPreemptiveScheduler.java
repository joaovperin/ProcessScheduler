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
public class PriorityPreemptiveScheduler extends AbstractScheduler {

    @Override
    protected final void pickProcess() {
        setRunningProcess(getProcesses().stream().
                sorted(br.feevale.jpe.core.Process::compareTo).
                filter(br.feevale.jpe.core.Process::isRunning).
                findFirst().orElse(null));
    }

}
