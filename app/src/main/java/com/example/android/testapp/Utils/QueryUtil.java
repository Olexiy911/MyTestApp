package com.example.android.testapp.Utils;

import android.content.Context;
import android.util.Log;

import com.example.android.testapp.model.Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class QueryUtil  {
    private QueryUtil() {
    }

    /**
     * Return a list of {@link Data} objects that has been built up from
     * parsing a JSON response.
     */
    public static ArrayList<Data> extractData(Context context) {

        // Create an empty ArrayList
        ArrayList<Data> data = new ArrayList<>();

        String json = null;
        try {
            InputStream is = context.getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");

            JSONObject jsonObj = new JSONObject(json);

            JSONObject feed = jsonObj.getJSONObject("feed");
            // Getting JSON Array node
            JSONArray dataArray = feed.getJSONArray("entry");
            for (int i = 0; i < dataArray.length(); i++) {
                JSONObject c = dataArray.getJSONObject(i);
                JSONObject properties = c.getJSONObject("im:price");
                String price = properties.getString("label");

                /*JSONArray imageArray = c.getJSONArray("im:image");
                JSONObject p = dataArray.getJSONObject(2);
                String picture = p.getString("label");*/

                JSONObject t = c.getJSONObject("title");
                String title = t.getString("label");

            Data info = new Data(price, title);
            data.add(info);
            }

        } catch (JSONException e) {

            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Return the list of earthquakes
        return data;
    }
}
