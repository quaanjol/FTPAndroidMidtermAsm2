package com.kwan.midtermasm2.model;

public class Temperature {
    private TempMinMax Minimum;
    private TempMinMax Maximum;

    public Temperature(TempMinMax minimum, TempMinMax maximum) {
        Minimum = minimum;
        Maximum = maximum;
    }

    public TempMinMax getMinimum() {
        return Minimum;
    }

    public void setMinimum(TempMinMax minimum) {
        Minimum = minimum;
    }

    public TempMinMax getMaximum() {
        return Maximum;
    }

    public void setMaximum(TempMinMax maximum) {
        Maximum = maximum;
    }
}
