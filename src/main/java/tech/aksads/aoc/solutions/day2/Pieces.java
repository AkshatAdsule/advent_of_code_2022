package tech.aksads.aoc.solutions.day2;

public enum Pieces {
    A(1), // r
    B(2), // p
    C(3), // s
    X(1), // r
    Y(2), // p
    Z(3); // s

    public final int val;
    
    private Pieces(int val) {
        this.val = val;
    }
}
