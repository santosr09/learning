module com.mycompany.myproject { //The module name should be unique

    //Unqualified export => grants access to ALL other modules
    exports com.mycompany.myproject.foo;

    exports com.mycompany.myproject.foo.internal
        /* Having a 'to' clause means that this is a **qualified export** => exports the package only to the friends of the current module - the modules specified in the 'to' clause */
        to com.example.x;

    exports com.mycompany.myproject.bar.internal to com.example.y, com.example.z;

    /* Dependency on 'com.example.foo.bar' which must be present both at compile time AND runtime */
    requires com.example.foo.bar;

    /* Transitive dependency: Any module which requires current module will also *implicity* depend on this dependency */
    requires transitive com.kitties.bar;

    // Optional dependency is mandatory at compile time, but optional at runtime
    requires static com.owls.foo;
}