/*  Copyright 2011 Claudio Martella
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.acaro.graffiti.query;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.Writable;

import com.google.common.base.Joiner;

public class LocationStep 
implements Writable {

    public static final String EMPTY = " ";
	public static final String ANY   = "*";
    private ArrayList<Condition> conditions = new ArrayList<Condition>();
    private String edge = EMPTY;
    private int repeat = -1;
    private boolean isSP = false;

    public LocationStep() { }

    public LocationStep(LocationStep other) {
        this.conditions.addAll(other.getConditions());
        this.edge   = other.getEdge();
        this.repeat = other.getRepeat();
        this.isSP   = other.isSP();
    }

    public void setEdge(String edge) {
        this.edge = edge;
    }

    public void addCondition(Condition condition) {
        conditions.add(condition);
    }

    public void setRepeat(Integer repeat) {
        this.repeat = repeat;
    }

    public void setSP(boolean value) {
        this.isSP = value;
    }

    public String getEdge() {
        return this.edge;
    }

    public List<Condition> getConditions() {
        return this.conditions;
    }

    public int getRepeat() {
        return this.repeat;
    }

    public boolean isSP() {
        return this.isSP;
    }

    public String toString() {
        StringBuffer string = new StringBuffer();

        if (!edge.equals(EMPTY)) {
            string.append(edge);
        } else {
            string.append("<no edge>");
        }

        string.append(" ");
        string.append(Joiner.on(" | ").skipNulls().join(conditions));

        if (repeat != -1) {
            string.append(" (");
            if (isSP)
                string.append("*");
            string.append(repeat);
            string.append(")");
        }

        return string.toString();
    }

    @Override
    public void readFields(DataInput input) 
    throws IOException {
        setEdge(input.readUTF());
        setRepeat(input.readInt());
        setSP(input.readBoolean());

        int n = input.readInt();
        for (int i = 0; i < n; i++) {
            Condition.TYPE type = Condition.TYPE.values()[input.readInt()];
            Condition c;

            switch (type) {
            case FILTER:
            {
                c = new Filter();
                break;
            }	
            case SUBQUERY:
            {
                c = new Subquery();
                break;
            }
            case HASEDGE:
            {
            	c = new HasEdge();
            	break;
            }
            default:
                throw new RuntimeException("Unknown Condition type at readFields!");
            }

            c.readFields(input);
            conditions.add(c);
        }
    }

    @Override
    public void write(DataOutput output) 
    throws IOException {
        output.writeUTF(edge);
        output.writeInt(repeat);
        output.writeBoolean(isSP);

        output.writeInt(conditions.size());
        for (Condition c: conditions) {
            c.write(output);
        }
    }
}
