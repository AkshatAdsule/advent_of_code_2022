package tech.aksads.aoc.solutions.day2;

import java.util.ArrayList;

import tech.aksads.aoc.solutions.Solution;

public class Day2Problem1 extends Solution<Integer> {

    public Day2Problem1() {
        super("d2p1");
    }

    ArrayList<Pieces[]> games = new ArrayList<>();

    @Override
    public void setup(boolean isTest) {
        ArrayList<String> lines = readInputFile(isTest);
        Pieces[] curr_game;

        for(String line: lines) {
            curr_game = new Pieces[2];
            switch(line.charAt(0)) {
                case 'A':
                    curr_game[0] = Pieces.A;
                    break;
                case 'B':
                    curr_game[0] = Pieces.B;
                    break;
                case 'C':
                    curr_game[0] = Pieces.C;
                    break;
            }

            switch(line.charAt(2)) {
                case 'X':
                    curr_game[1] = Pieces.X;
                    break;
                case 'Y':
                    curr_game[1] = Pieces.Y;
                    break;
                case 'Z':
                    curr_game[1] = Pieces.Z;
                    break;
            }

            games.add(curr_game);
        }
        
    }

    @Override
    public Integer solve() {
        int total_score = 0;
        for(Pieces[] game : games) {
            total_score += get_result(game);
        }
        return total_score;
    }

    @Override
    public boolean test() {
        return solve() == 15;
    }

    public int get_result(Pieces[] game) {
        Pieces op = game[0];
        Pieces pl = game[1];

        int val = -1;

        switch(op) {
            case A:
                switch(pl) {
                    case X:
                        val = 3;
                        break;
                    case Y:
                        val = 6;
                        break;
                    case Z:
                        val = 0;
                        break;
                    default:
                        break;
                }
                break;
            case B:
                switch(pl) {
                    case X:
                        val = 0;
                        break;
                    case Y:
                        val = 3;
                        break;
                    case Z:
                        val = 6;
                        break;
                    default:
                        break;
                }
                break;
            case C:
                switch(pl) {
                    case X:
                        val = 6;
                        break;
                    case Y:
                        val = 0;
                        break;
                    case Z:
                        val = 3;
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }

        return pl.val + val;
    }
}
