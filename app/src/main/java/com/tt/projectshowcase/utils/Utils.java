package com.tt.projectshowcase.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.regex.Pattern;

/**
 * @author tturcic
 *         \date 1.9.2017.
 */
public class Utils {

    /**
     * Check that all given permissions have been granted by verifying that each entry in the
     * given array is of the value {@link PackageManager#PERMISSION_GRANTED}.
     *
     * @see Activity#onRequestPermissionsResult(int, String[], int[])
     */
    public static boolean verifyPermissions(int[] grantResults) {
        // At least one result must be checked.
        if(grantResults.length < 1){
            return false;
        }

        // Verify that each required permission has been granted, otherwise return false.
        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    /**
     * Email validation pattern.
     */
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );

    /**
     * Validates if the given input is a valid email address.
     *
     * @param email The {@link Pattern} used to validate the given email.
     * @return {@code true} if the input is a valid email. {@code false} otherwise.
     */
    public static boolean isValidEmail(CharSequence email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }

    public static int spToPx(float sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, Resources.getSystem().getDisplayMetrics());
    }

    public static void showKeyboard(Context context){
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if(imm != null)
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
    }

    public static void hideKeyBoard(View v){
        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if(imm != null)
            imm.hideSoftInputFromWindow(v.getWindowToken(),0);
    }

    public static final String[] TEST_IMAGES = {
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRQalyuuX8c-NUWw-BjO_I1lwaHzFm9d96bY4upwsIXu3LtlNqQ",
                "http://www.gettyimages.com/gi-resources/images/Embed/new/embed2.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQORaH2BF3ZzUy2ATj866BszLShnoe2cRbjc-WQauazk5iThjC-4w",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTLb5mOUtzV0ObqBVuAURSvPAsC27148aFdKGc6e6Z_Z78vmMWf",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2jMfhV08O10OfRFDqf04mqAO4lDMectKSbg1kItLwCNOzPy_t"
    };

    public static final String[] TEST_LOGOS = {
            "https://upload.wikimedia.org/wikipedia/hr/thumb/e/e6/Konzum-Logo.svg/1024px-Konzum-Logo.svg.png",
            "https://upload.wikimedia.org/wikipedia/en/thumb/8/8e/Intersport_logo.svg/1280px-Intersport_logo.svg.png",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4wIscfQqPhJLT41k74Q_ohI2-ie0Ts5g1IHaiZ3QLJUUVZjMq",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSVWhvbWqMTj8nWVW7giOQHMZ9mEggRmSwFwAzzxpYIxrhbXDBT",
            "http://data.wikomobile.com/documents/retailers/7fd8f262b9003d0fb557c9430f9ce387.png",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTebTB20tDDlxL-YkE8Bh6KU6qbsh_sPB3Y372yCPZZ1YfMelaPBQ",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTzJnRIjHj5wbMGd6esk31n9o5waNlOpVdzrPtxKlWS3Dvwxlwk"
    };
}
