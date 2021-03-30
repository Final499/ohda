package com.example.ohda499;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class regestrTest {
    @Test
    void valiemail() {
        regestr rg = new regestr();
        String em ="hu@gmail.com";
        assertTrue(rg.valiemail(em,1));
    }
    @Test
    void validPhone() {
        regestr rg = new regestr();
        String em ="0506556102";
        assertTrue(rg.validPhone(em,1));
    }
}