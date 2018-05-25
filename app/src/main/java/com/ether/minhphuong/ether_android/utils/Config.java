package com.ether.minhphuong.ether_android.utils;

/**
 * Created by minhphuong on 5/24/18.
 */

public class Config {

    public enum ServerMode {
        SERVER_MODE_DEVELOPMENT(0),
        SERVER_MODE_PRODUCTION(1);

        private final int value;

        private ServerMode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    private static ServerMode currentMode = ServerMode.SERVER_MODE_DEVELOPMENT;

    public static ServerMode getMode() {
        return currentMode;
    }

    public static void setMode(ServerMode mode) {
        currentMode = mode;
    }
}
