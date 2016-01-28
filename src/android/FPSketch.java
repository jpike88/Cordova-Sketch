package com.formpigeon.sketch;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.Intent;
import com.formpigeon.sketch.SketchActivity;
import android.content.Context;
public class FPSketch extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        Context context=this.cordova.getActivity().getApplicationContext();
Intent intent = new Intent(context, SketchActivity.class);
intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);



        context.startActivity(intent);

        if (action.equals("greet")) {

            String name = data.getString(0);
            String message = "Hello, " + name;
            callbackContext.success(message);

            return true;

        } else {
            
            return false;

        }
    }
}
