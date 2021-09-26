package CalculatorForJavaMentor;

public enum Roman {
    O(0), I(1), V(5), X(10), L(50), C(100);

    int value;

    Roman(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    static Roman valueOf(int value) {
        for (Roman roman : Roman.values())
            if (value == roman.getValue())
                return roman;
        throw new IllegalArgumentException();
    }
}
