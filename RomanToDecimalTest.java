import static org.junit.Assert.*;

public class RomanToDecimalTest {

    @org.junit.Test
    public void romanToDecimal() {
        assertEquals(RomanToDecimal.romanToDecimal("XI"), 11);
        assertEquals(RomanToDecimal.romanToDecimal("iv"), 4);
        assertEquals(RomanToDecimal.romanToDecimal("ix"), 9);
        assertEquals(RomanToDecimal.romanToDecimal("XXI"), 21);
        assertEquals(RomanToDecimal.romanToDecimal("VD"), 505);
        assertEquals(RomanToDecimal.romanToDecimal("XIX"), 19);
        assertEquals(RomanToDecimal.romanToDecimal("mm"), 2000);
        assertEquals(RomanToDecimal.romanToDecimal("ball"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("XC"), 90);
        assertEquals(RomanToDecimal.romanToDecimal("CCXD"), 710);
        assertEquals(RomanToDecimal.romanToDecimal("IXIX"), 20);
        assertEquals(RomanToDecimal.romanToDecimal("run"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("ivvi"), 10);
        assertEquals(RomanToDecimal.romanToDecimal("cary academy"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("xiix"), 20);
        assertEquals(RomanToDecimal.romanToDecimal("ixix"), 20);
        assertEquals(RomanToDecimal.romanToDecimal("xd"), 510);
        assertEquals(RomanToDecimal.romanToDecimal("dm"), 1500);
        assertEquals(RomanToDecimal.romanToDecimal("ISIS"), -1);
        assertNotEquals(RomanToDecimal.romanToDecimal("lol"), 12);
        assertNotEquals(RomanToDecimal.romanToDecimal("bruh"), 13);
    }
}