package br.com.dclfactor.enumeration;

import lombok.Getter;

@Getter
public enum Month {

    JAN(1), FEV(2), MAR(3), ABR(4), MAI(5), JUN(6), JUL(7), AGO(8), SET(9), OUT(10), NOV(11), DEZ(12);

    private final Integer value;

    private Month(Integer value) {
        this.value = value;
    }
}
