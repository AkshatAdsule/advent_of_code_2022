package tech.aksads.aoc.solutions.day7.fs;

public class File extends FileSystemEntry {

    private final int size;

    public File(String name, FileSystemEntry parent, int size) {
        super(name, parent);
        this.size = size;
    }

    @Override
    public int get_size() {
        return size;
    }
    
}
