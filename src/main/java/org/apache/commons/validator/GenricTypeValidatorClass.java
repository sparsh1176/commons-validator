package org.apache.commons.validator;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;

public class GenricTypeValidatorClass implements Serializable {
    /**
     * Checks if the value can safely be converted to a byte primitive.
     *
     * @param value The value validation is being performed on.
     * @return the converted Byte value.
     */
    public static Byte formatByte(String value) {
        if (value == null) {
            return null;
        }

        try {
            return Byte.valueOf(value);
        } catch (NumberFormatException e) {
            return null;
        }

    }

    /**
     * Checks if the value can safely be converted to a byte primitive.
     *
     * @param value  The value validation is being performed on.
     * @param locale The locale to use to parse the number (system default if
     *               null)
     * @return the converted Byte value.
     */
    public static Byte formatByte(String value, Locale locale) {
        Byte result = null;

        if (value != null) {
            NumberFormat formatter = null;
            if (locale != null) {
                formatter = NumberFormat.getNumberInstance(locale);
            } else {
                formatter = NumberFormat.getNumberInstance(Locale.getDefault());
            }
            formatter.setParseIntegerOnly(true);
            ParsePosition pos = new ParsePosition(0);
            Number num = formatter.parse(value, pos);

            // If there was no error      and we used the whole string
            if (pos.getErrorIndex() == -1 && pos.getIndex() == value.length() &&
                    num.doubleValue() >= Byte.MIN_VALUE &&
                    num.doubleValue() <= Byte.MAX_VALUE) {
                result = Byte.valueOf(num.byteValue());
            }
        }

        return result;
    }

    /**
     * Checks if the value can safely be converted to a short primitive.
     *
     * @param value The value validation is being performed on.
     * @return the converted Short value.
     */
    public static Short formatShort(String value) {
        if (value == null) {
            return null;
        }

        try {
            return Short.valueOf(value);
        } catch (NumberFormatException e) {
            return null;
        }

    }

    /**
     * Checks if the value can safely be converted to a short primitive.
     *
     * @param value  The value validation is being performed on.
     * @param locale The locale to use to parse the number (system default if
     *               null)
     * @return the converted Short value.
     */
    public static Short formatShort(String value, Locale locale) {
        Short result = null;

        if (value != null) {
            NumberFormat formatter = null;
            if (locale != null) {
                formatter = NumberFormat.getNumberInstance(locale);
            } else {
                formatter = NumberFormat.getNumberInstance(Locale.getDefault());
            }
            formatter.setParseIntegerOnly(true);
            ParsePosition pos = new ParsePosition(0);
            Number num = formatter.parse(value, pos);

            // If there was no error      and we used the whole string
            if (pos.getErrorIndex() == -1 && pos.getIndex() == value.length() &&
                    num.doubleValue() >= Short.MIN_VALUE &&
                    num.doubleValue() <= Short.MAX_VALUE) {
                result = Short.valueOf(num.shortValue());
            }
        }

        return result;
    }
}