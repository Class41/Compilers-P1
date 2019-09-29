package com.umsl.vasylonufriyev.DataStructures;

public class Token {
    private String tokenType = null;
    private String tokenValue = null;
    private int tokenLine = -1;

    public Token(String tokenType, String tokenValue, int tokenLine) {
        this.tokenType = tokenType;
        this.tokenValue = tokenValue;
        this.tokenLine = tokenLine;
    }

    public Token() { }

    public String GetTokenType() {
        return tokenType;
    }

    public void SetTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String GetTokenValue() {
        return tokenValue;
    }

    public void SetTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public int GetTokenLine() {
        return tokenLine;
    }

    public void SetTokenLine(int tokenLine) {
        this.tokenLine = tokenLine;
    }
}
