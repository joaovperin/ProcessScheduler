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
 * A Factory for schedulers
 */
public class SchedulerFactory {

    public static final String TYPE_1 = "1-Não preemptivo, por chegada";
    public static final String TYPE_2 = "2-Preemptivo, por prioridade";
    public static final String TYPE_3 = "3-Preemptivo, por prioridade/quantum";

    public static final Scheduler create(String type) {
        if (type != null && !type.trim().isEmpty()) {
            switch (type) {
                case TYPE_1:
                    return new NonPreemptiveScheduler();
                case TYPE_2:
                    return new PreemptiveScheduler();
            }
        }
        throw new IllegalArgumentException("Type must always have a valid value!");
    }

    public static String[] getTypes() {
        return new String[] { TYPE_1, TYPE_2, TYPE_3 };
    }

}
