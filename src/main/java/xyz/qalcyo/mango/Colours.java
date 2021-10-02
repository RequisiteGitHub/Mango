package xyz.qalcyo.mango;

import xyz.qalcyo.mango.collections.abstraction.AbstractTriplet;
import xyz.qalcyo.mango.collections.impl.MutableTriplet;

public class Colours {

    /**
     * @param colour The RGB colour to get from.
     * @return The alpha of the colour provided.
     */
    public static int alphaOf(int colour) {
        return (colour >> 24 & 255);
    }

    /**
     * Converts a rgb value to a normalised value (between 0 & 1)
     * Often used in things like OpenGL for colours
     * @param r the red value
     * @param g the green value
     * @param b the blue value
     * @return The normalised colour value
     */
    public static MutableTriplet<Double, Double, Double> rgbToNormalised(int r, int g, int b) {
        double red = r / 255.0;
        double green = g / 255.0;
        double blue = b / 255.0;

        return new MutableTriplet<>(red, green, blue);
    }

    /**
     Converts a rgb value to a normalised value (between 0 & 1)
     * Often used in things like OpenGL for colours
     * @param rgb The red green blue value
     * @return The normalised colour value
     */
    public static MutableTriplet<Double, Double, Double> rgbToNormalised(AbstractTriplet<Integer, Integer, Integer> rgb) {
        return rgbToNormalised(rgb.first(), rgb.second(), rgb.third());
    }
}