package com.dalma.fibrew.contract;

public class Paths {

	public static final String APPLICATION = "fibrew";
    public static final String BASE_PATH = "/api/" + APPLICATION; // NOSONAR
    public static final String BY_ID = "/{id}";

    // Work order
    public static final String WORK_ORDER = "/workorder";
    public static final String NOTIFICATION = "/notification";
    public static final String INTEGRATE = "/integrate";

    private Paths() {
        // Utility class
    }
}
