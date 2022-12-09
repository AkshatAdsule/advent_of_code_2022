package tech.aksads.aoc.solutions.day7;

import java.util.ArrayList;
import tech.aksads.aoc.solutions.day7.fs.*;

public class Parser {
    private final ArrayList<String> lines;

    public Parser(ArrayList<String> lines) {
        this.lines = lines;
    }

    public Directory parse() {
        Directory root = new Directory("/", null);
        Directory current_directory = root;

        for(int i = 1; i < lines.size(); ++i) {
            String curr_line = lines.get(i);

            if(curr_line.charAt(0) == '$') {
                if(curr_line.charAt(2) == 'l') {
                    ls(lines, i, current_directory);
                } else {
                    String[] split = curr_line.split(" ");
                    String file = split[2];
                    if(file.equals("..")) {
                        current_directory = (Directory) current_directory.parent;
                    } else {
                        for(FileSystemEntry entry : current_directory.children) {
                            if(entry instanceof Directory && entry.name.equals(file)) {
                                current_directory = (Directory) entry;
                            }
                        }
                    }
                }
            }
        }
        return root;
    }

    private void ls(ArrayList<String> lines, int start_index, Directory curr_directory) {
        String curr_line;
        String[] split;
        for(int i = start_index + 1; true; ++i) {
            if(i >= lines.size()) {
                break;
            }
            curr_line = lines.get(i);
            if(curr_line.charAt(0) == '$') {
                break;
            } else {
                split = curr_line.split(" ");
                if(split[0].equals("dir")) {
                    curr_directory.add_child(new Directory(split[1], curr_directory));
                } else {
                    curr_directory.add_child(new File(split[1], curr_directory, Integer.parseInt(split[0])));
                }
            }
        }
    }
}
