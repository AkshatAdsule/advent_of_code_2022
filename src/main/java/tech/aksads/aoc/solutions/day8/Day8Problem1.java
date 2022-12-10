package tech.aksads.aoc.solutions.day8;

import java.util.ArrayList;

import tech.aksads.aoc.solutions.Solution;

public class Day8Problem1 extends Solution<Integer> {

    private int map[][];

    public Day8Problem1() {
        super("d8p1");
    }

    @Override
    public void setup(boolean isTest) {
        ArrayList<String> lines = readInputFile(isTest);
        map = new int[lines.size()][lines.get(0).length()];

        for(int i = 0; i < map.length; ++i) {
            for(int j = 0; j < map[i].length; ++j) {
                map[i][j] = (lines.get(i).charAt(j) - '0');
            }
        }
    }

    @Override
    public Integer solve() {
        int count = 2 * (map.length + map[0].length) - 4;
        
        for(int i = 1; i < map.length - 1; ++i) {
            for(int j = 1; j < map[i].length - 1; ++j) {
                if(is_visible(map, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    boolean is_visible(int map[][], int r, int c) {
        int height = map[r][c];
        // check going up
        for(int i = r - 1; i >= 0; --i) {
            if(i == 0 && map[0][c] < height) {
                return true;
            } else {
                if(map[i][c] >= height) {
                    break;
                }
            }
        }

        // check going down
        for(int i = r + 1; i < map.length; ++i) {
            if(i == map.length - 1 && map[i][c] < height) {
                return true;
            } else {
                if(map[i][c] >= height) {
                    break;
                }
            }
        }

        // check going left
        for(int i = c - 1; i >= 0; --i) {
            if(i == 0 && map[r][0] < height) {
                return true;
            } else {
                if(map[r][i] >= height) {
                    break;
                }
            }
        }

        // check going right
        for(int i = c + 1; i < map[0].length; ++i) {
            if(i == map[0].length - 1 && map[r][i] < height) {
                return true;
            } else {
                if(map[r][i] >= height) {
                    break;
                }
            }
        }

        return false;
    }

    @Override
    public boolean test() {
        int solution = solve();
        return solution == 21;
    }
}
