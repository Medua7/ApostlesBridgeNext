package com.medua.apostlesbridgenext.config;

public class ConfigUtil {

    public static String getOriginReplacement(String origin) {
        return switch (origin.toLowerCase()) {
            case "dc" -> Config.getFormattingNames().getDiscord();
            case "g1" -> Config.getFormattingNames().getG1();
            case "g2" -> Config.getFormattingNames().getG2();
            case "g3" -> Config.getFormattingNames().getG3();
            default -> Config.getFormattingNames().getBridge();
        };
    }

    public static String convertToColor(String rawColor) {
        return rawColor.replace("§", "&");
    }
    public static String convertToRawColor(String color) {
        return color.replace("&", "§");
    }
}
