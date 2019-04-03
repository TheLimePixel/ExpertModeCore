package com.EmosewaPixel.expertmodecore.recipes;

public class StringStack {
    private String string;
    private int count;

    public StringStack(String string, int count) {
        this.string = string;
        this.count = count;
    }

    public StringStack(String string) {
        this(string, 1);
    }

    public String getString() {
        return string;
    }

    public int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count = count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public StringStack copy() {
        return new StringStack(this.string, this.count);
    }
}
