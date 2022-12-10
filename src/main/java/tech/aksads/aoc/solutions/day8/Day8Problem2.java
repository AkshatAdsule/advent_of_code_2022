package tech.aksads.aoc.solutions.day8;

import java.util.ArrayList;

import tech.aksads.aoc.solutions.Solution;

public class Day8Problem2 extends Solution<Integer> {

    private int map[][];

    public Day8Problem2() {
        super("d8p2");
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
        int max_score = -1;
        int curr_score;
        for(int i = 1; i < map.length - 1; ++i) {
            for(int j = 1; j < map[i].length - 1; ++j) {
                curr_score = (get_depth(map, i, j, -1, 0) * get_depth(map, i, j, 1, 0) * get_depth(map, i, j, 0, -1) * get_depth(map, i, j, 0, 1));
                if(curr_score > max_score) {
                    max_score = curr_score;
                }
            }
        }
        return max_score;
    }

    int get_depth(int map[][], int r, int c, int dr, int dc) {
        return _get_depth_recurs(map, r + dr, c + dc, dr, dc, 0, map[r][c]);
    }

    private int _get_depth_recurs(int map[][], int r, int c, int dr, int dc, int count, int base_height) {
        if(r < 0 || c < 0 || r >= map.length || c >= map[r].length) {
            return count;
        }
        int curr_height = map[r][c];
        if(curr_height >= base_height) {
            return count + 1;
        } else {
            return _get_depth_recurs(map, r + dr, c + dc, dr, dc, count + 1, base_height);
        }
    }

    @Override
    public boolean test() {
        int sol = solve();
        return sol == 8;
    }
    
}
