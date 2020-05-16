package com.spell.number;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class SpellNumberTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertEquals("Eight", SpellNumber.convert(8));
        assertEquals("Sixteen", SpellNumber.convert(16));
        assertEquals("Seven Hundred Fifty Eight", SpellNumber.convert(758));
        assertEquals("Nine Thousand Eight Hundred Five", SpellNumber.convert(9805));
        assertEquals("Thirteen Thousand Four Hundred Fifty Six", SpellNumber.convert(13456));
        assertEquals("One Lakh Twenty Three Thousand Four Hundred Fifty Six", SpellNumber.convert(123456));
        assertEquals("Twelve Lakh Thirty Four Thousand Five Hundred Sixty Seven", SpellNumber.convert(1234567));
        assertEquals("One Crore Twenty Three Lakh Forty Five Thousand Six Hundred Seventy Eight", SpellNumber.convert(12345678));
    }
}
