/*
 * Grid.java - The grid containing the characters.
 * Befunge2020 - Stack-based execution for the future.
 *
 * Copyright (c) 2020 John Nunley and Thomas Jeffery
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.notgull.befunge2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Grid {
    protected int x, x1;
    protected int y, y1;
    protected Character[][] grid;
    public Grid(String fileName){
        //get size of the array fileName and pass into grid
        List<List<Character>> grid = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                List<Character> l = new ArrayList<>();
                for (int i = 0; i < line.length(); i++) {
                    l.add(line.charAt(i));
                }
                grid.add(l);
            }
        } catch (IOException ex) {
            System.err.println("An error occurred.");
        }

        Character[][] actualGrid = new Character[grid.size()][];
        for (int i = 0; i < grid.size(); i++) {
            List<Character> l = grid.get(i);
            Character[] gridRow = new Character[l.size()];
            l.toArray(gridRow);
            actualGrid[i] = gridRow;
        }

        this.grid = actualGrid;

        this.x = 0;
        this.y = 0;
    }
    protected void setX(int x){
        this.x = x;
    }
    protected void setY(int y){
        this.y = y;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public String toString(){
        String g = "";
        for (int x = 0; x < grid.length; x++){
            for (int y = 0; y < grid[x].length; y++){
                g += grid[x][y];
            }
            g += "\n";
        }
        return g;
    }

    public char getChar(int x, int y) {
        return grid[y][x];
    }

    public int getRowCount() {
        return grid.length;
    }

    public int getColsAt(int y) {
        return grid[y].length;
    }
}
