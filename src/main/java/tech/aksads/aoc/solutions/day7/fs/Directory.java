package tech.aksads.aoc.solutions.day7.fs;

public class Directory extends FileSystemEntry {

    public Directory(String name, FileSystemEntry parent) {
        super(name, parent);
        }
        

    @Override
    public int get_size() {
        int sum = 0;
        for(FileSystemEntry entry : children) {
            sum += entry.get_size();
        }
        return sum;
    }

    public int solve_part_1() {
        int sum = 0;
        int size = get_size();
        if(size <= 100000) {
            sum += size;
        }

        for(FileSystemEntry entry : children) {
            if(entry instanceof Directory) {
                Directory dir = (Directory) entry;
                sum += dir.solve_part_1();
            }
        }

        return sum;
    }

    public int solve_part_2(int size_needed) {
        int best_fit = 0;
        int size = get_size();

        if(size >= size_needed) {
            if(Math.abs(size - size_needed) < Math.abs(best_fit - size_needed)) {
                best_fit = size;
            }
        }

        for(FileSystemEntry entry : children) {
            if(entry instanceof Directory) {
                Directory dir = (Directory) entry;
                int dir_best_fit = dir.solve_part_2(size_needed);
                if(dir_best_fit >= size_needed) {
                    if(Math.abs(best_fit - size_needed) > Math.abs(dir_best_fit - size_needed)) {
                        best_fit = dir_best_fit;
                    }
                }
            }
        }

        return best_fit;
    }
}
