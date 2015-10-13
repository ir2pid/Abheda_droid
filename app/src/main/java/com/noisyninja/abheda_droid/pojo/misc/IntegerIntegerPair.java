package com.noisyninja.abheda_droid.pojo.misc;

import com.noisyninja.abheda_droid.pojo.BasePojo;

/**
 * Created by ir2pi on 4/28/2015.
 */
public class IntegerIntegerPair extends BasePojo {

    int i1;
    int i2;

    public IntegerIntegerPair(int i1, int i2) {
        this.i1 = i1;
        this.i2 = i2;
    }

    public int getI1() {
        return i1;
    }

    public void setI1(int i1) {
        this.i1 = i1;
    }

    public int getI2() {
        return i2;
    }

    public void setI2(int i2) {
        this.i2 = i2;
    }
}
