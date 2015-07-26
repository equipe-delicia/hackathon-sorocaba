package com.ciandt.hackathon.sorocaba.util;

/**
 * Useful class for generic methods.
 *
 * @author falvojr
 */
public final class AppUtil {

    private AppUtil() {
        super();
    }

    public static <T> T get(Object element) {
        return (T) element;
    }
}
