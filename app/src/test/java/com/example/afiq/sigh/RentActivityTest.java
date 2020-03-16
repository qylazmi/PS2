package com.example.afiq.sigh;

import android.content.ContentValues;

import org.junit.Before;
import org.junit.Test;



import static org.junit.Assert.*;


public class RentActivityTest {
    RentActivity test;

    @Before
    public void setUp(){
        test = new RentActivity();
    }

    @Test
    public void onCreateTest() {
        book booking = new book();
        assertEquals("ali",booking.getName(),test.editName);
        assertEquals("960219-14-5457",booking.getIc(),test.editIc);
        assertEquals("019-2734926",booking.getTel(),test.editTel);
        assertEquals("dewan al-ghazali",booking.getHall(),test.editHall);
        assertEquals("28.2.2018",booking.getDate(),test.editDate);
        assertEquals("To do speech",booking.getPurpose(),test.editPurpose);
    }




    @Test
    public void AddDataTest() {


        book booking = new book();

        String name="sfiq",  ic="960219-14-5457",  tel="019-2734926",  hall="dewan al-ghazali",  date="28.2.2018",  purpose="To do speech";
        ContentValues contentValues = new ContentValues();

        assertSame(contentValues.get(name),booking.getName());
        assertSame(contentValues.get(ic),booking.getIc());
        assertSame(contentValues.get(tel),booking.getTel());
        assertSame(contentValues.get(hall),booking.getHall());
        assertSame(contentValues.get(date),booking.getDate());
        assertSame(contentValues.get(purpose),booking.getPurpose());

    }



    @Test(expected=NullPointerException.class)
    public void testNullPointerException() {


        assertNotNull(test.editName.getText());
        assertNotNull(test.editIc.getText());
        assertNotNull(test.editTel.getText());
        assertNotNull(test.editHall.getText());
        assertNotNull(test.editDate.getText());
        assertNotNull(test.editPurpose.getText());

    }

}
