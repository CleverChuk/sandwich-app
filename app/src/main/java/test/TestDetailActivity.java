package test;

import com.udacity.sandwichclub.utils.TextUtil;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;


/**
 * A simple test for TextUtil class methods
 * Created by chuk on 4/24/18.
 */

public class TestDetailActivity {
    @Test
    public void testGetStringFromIterable(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("US");
        arrayList.add("DevOps");

        assertEquals("US, DevOps", TextUtil.getStringFromIterable(arrayList));
        assertEquals(null, TextUtil.getStringFromIterable(new ArrayList<String>()));
    }
}
