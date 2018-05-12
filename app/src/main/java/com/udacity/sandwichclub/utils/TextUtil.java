/*
 * Copyright (c) 2018  Chukwubuikem Ume-Ugwa
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.udacity.sandwichclub.utils;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * A utility class for formatting JSON array object to a string
 * Created by chuk on 4/24/18.
 */

public class TextUtil {

    /**
     * converts {@link Iterable<String>} to {@link String} removing the bracket tokens
     * @param iterable an object that implements iterable interface
     * @return string
     */
    public static String getStringFromIterable(Iterable<String> iterable){
        if(!iterable.iterator().hasNext())
            return null;

        String str = iterable.toString();
        return str.substring(1,str.length()-1); // remove [ ] tokens
    }

    /**
     * converts {@link JSONArray} to {@link ArrayList<String>}
     * @param jsonArray JSONArray object
     * @return an array list of strings
     */
    public static ArrayList<String> getArray(JSONArray jsonArray){
        ArrayList<String> array = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                array.add(jsonArray.getString(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return array;
    }

    private TextUtil(){}//should not be instantiated
}
