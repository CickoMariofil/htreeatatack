// IFlag29Interface.aidl
package io.hextree.attacksurface.services;

// Declare any non-default types here with import statements

interface IFlag29Interface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    String init();
    void authenticate(String str);
    void success();
}