/*
 * android-spinnerwheel
 * https://github.com/ai212983/android-spinnerwheel
 *
 * based on
 *
 * Android Wheel Control.
 * https://code.google.com/p/android-wheel/
 *
 * Copyright 2011 Yuri Kanivets
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package library.saurabh.com.horizontalscale.widget.spinnerWheel.adapters;

import android.content.Context;

/**
 * Numeric Wheel adapter.
 */
public class FloatingWheelAdapter extends AbstractWheelTextAdapter {

    /** The default min value */
    public static final int DEFAULT_MAX_VALUE = 90;

    /** The default max value */
    private static final int DEFAULT_MIN_VALUE = 0;

    // Values
    private int minValue;
    private int maxValue;

    // format
    private String format;

    /**
     * Constructor
     * @param context the current context
     */
    public FloatingWheelAdapter(Context context) {
        this(context, DEFAULT_MIN_VALUE, DEFAULT_MAX_VALUE);
    }

    /**
     * Constructor
     * @param context the current context
     * @param minValue the spinnerwheel min value
     * @param maxValue the spinnerwheel max value
     */
    public FloatingWheelAdapter(Context context, int minValue, int maxValue) {
        this(context, minValue, maxValue, null);
    }

    /**
     * Constructor
     * @param context the current context
     * @param minValue the spinnerwheel min value
     * @param maxValue the spinnerwheel max value
     * @param format the format string
     */
    public FloatingWheelAdapter(Context context, int minValue, int maxValue, String format) {
        super(context);
        
        this.minValue = minValue*10;
        this.maxValue = maxValue*10;
        this.format = format;
    }

    @Override
    public CharSequence getItemText(int index) {
        if (index >= 0 && index < getItemsCount()) {
            int value = minValue + index;
            if(value % 10 == 0) {
                int valueFloat = value/10;
                return format != null ? String.format(format, valueFloat) : Integer.toString(valueFloat);
                //return format != null ? String.format(format, valueFloat) : Float.toString(valueFloat);
            }else {
                return "";
            }

        }
        return null;
    }

    @Override
    public int getItemsCount() {
        return maxValue - minValue + 1;
    }

}
