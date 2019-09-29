package com.umsl.vasylonufriyev.DataStructures;

public class ProgramDataBuffer {

    private String[] data;
    private int lineNumber;
    private int charPosition;

    public ProgramDataBuffer(String[] data) {
        this.data = data;
        this.lineNumber = 0;
        this.charPosition = 0;
    }

    public char GetNextCharacter() {
        while (true) {
            if (lineNumber < data.length) {
                if (charPosition < (data[lineNumber]).length()) {
                    char returnVal = data[lineNumber].charAt(charPosition);
                    charPosition++;
                    return returnVal;
                } else {
                    lineNumber++;
                    charPosition= 0;
                }
            } else {
                return '~'; //Symbolizes EOF
            }
        }
    }
}
