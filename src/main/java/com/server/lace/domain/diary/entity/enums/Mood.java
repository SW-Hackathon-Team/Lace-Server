package com.server.lace.domain.diary.entity.enums;

public enum Mood {
    HAPPY, SAD, ANGRY, TIRED, WONDER;

    public static Mood toMood(String mood) {
        switch (mood) {
            case "HAPPY":
                return HAPPY;
            case "SAD":
                return SAD;
            case "ANGRY":
                return ANGRY;
            case "TIRED":
                return TIRED;
            case "WONDER":
                return WONDER;
            default:
                return null;
        }
    }

}
