package tech.aksads.aoc.solutions.day7.fs;

import java.util.ArrayList;

public abstract class FileSystemEntry {
    public final String name;
    public final FileSystemEntry parent;
    public ArrayList<FileSystemEntry> children;

    public FileSystemEntry(String name, FileSystemEntry parent) {
        this.parent = parent;
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void add_child(FileSystemEntry child) {
        children.add(child);
    }
    
    public abstract int get_size();
}
