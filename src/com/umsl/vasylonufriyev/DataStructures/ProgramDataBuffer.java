package com.umsl.vasylonufriyev.DataStructures;

public class ProgramDataBuffer {

    private String[] data;
    private int lineNumber;
    private int charPosition;

    private Token parsedTk;

    public ProgramDataBuffer(String[] data) {
        this.data = data;
        this.lineNumber = 0;
        this.charPosition = 0;
        this.parsedTk = null;
    }

    public char GetNextCharacter() {
        while (true) { //Keep going until we return something
            if (lineNumber < data.length) { //Visit all lines
                if (charPosition < (data[lineNumber]).length()) { //Visit all chars on a line
                    return data[lineNumber].charAt(charPosition++);
                } else {
                    lineNumber++;
                    charPosition = 0;
                }
            } else {
                return 0xe65; //Symbolizes EOF
            }
        }
    }

    public void SetParsedTk(Token Tk) { //Usd to pass back the token value parsed from raw input
        this.parsedTk = Tk;
    }

    public Token GetParsedTk() {
        return parsedTk;
    }

}
