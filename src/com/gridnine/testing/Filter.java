package com.gridnine.testing;

/**
 * Basic interface defines the behavior of filter classes.
 */
public interface Filter {

    boolean test(Flight flight);
    String getMessage();
}
