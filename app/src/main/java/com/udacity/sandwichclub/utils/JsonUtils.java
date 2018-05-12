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

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {
    private static final String NAME;
    private static final String DESCRIPTION;
    private static final String MAIN_NAME;
    private static final String ALSO_KNOWN_AS;
    private static final String IMAGE;
    private static final String INGREDIENTS;
    private static final String PLACE_OF_ORIGIN;

    // initialize static fields
    static {
        NAME = "name";
        DESCRIPTION = "description";
        MAIN_NAME = "mainName";
        ALSO_KNOWN_AS = "alsoKnownAs";
        IMAGE = "image";
        INGREDIENTS = "ingredients";
        PLACE_OF_ORIGIN = "placeOfOrigin";
    }



    public static Sandwich parseSandwichJson(String json) {
        return getSandwich(json);
    }

    /**
     * a helper method for parseSandwichJson
     * @param json json string
     * @return Sandwich object built from json
     */
    private static Sandwich getSandwich(String json) {
        try {
            JSONObject jObject = new JSONObject(json);
            JSONObject object = jObject.getJSONObject(NAME); // name field is an object
            String mainName = object.getString(MAIN_NAME);

            String description = jObject.getString(DESCRIPTION);
            String image = jObject.getString(IMAGE);
            String placeOfOrigin = jObject.getString(PLACE_OF_ORIGIN);

            ArrayList<String> alsoKnownAs = TextUtil.getArray(object.getJSONArray(ALSO_KNOWN_AS));
            ArrayList<String> ingredients = TextUtil.getArray(jObject.getJSONArray(INGREDIENTS));

            return new Sandwich(mainName,alsoKnownAs,placeOfOrigin,description,image,ingredients);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }



    // this class is a utility and should not be instantiated
    private JsonUtils(){}
}
