package com.rostertwo.models;

public enum Position {
    SYSTEM_ENGINEER, SOFTWARE_ENGINEER, SOFTWARE_TESTING_ENGINEER, BUSINESS_ANALYST;

    public String toString() {
        switch (this) {
            case SYSTEM_ENGINEER:
                return "System Engineer";
            case SOFTWARE_ENGINEER:
                return "Software Engineer";
            case SOFTWARE_TESTING_ENGINEER:
                return "Software Testing Engineer";
            case BUSINESS_ANALYST:
                return "Business Analyst";
        }
        return "";
    }
}