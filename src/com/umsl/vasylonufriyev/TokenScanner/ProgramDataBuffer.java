package com.umsl.vasylonufriyev.TokenScanner;

import com.umsl.vasylonufriyev.DataStructures.Token;

class ProgramDataBuffer {

    private String[] data;

    int GetLineNumber() {
        return lineNumber;
    }

    int GetCharPosition() {
        return charPosition;
    }

    private int savedLineNumber;
    private int savedCharPosition;
    private int lineNumber;
    private int charPosition;

    private Token parsedTk;

    ProgramDataBuffer(String[] data) {
        this.data = data;
        this.lineNumber = 0;
        this.charPosition = 0;
        this.savedCharPosition = 0;
        this.savedLineNumber = 0;
        this.parsedTk = null;
    }

    char GetNextCharacter() {
        savedLineNumber = lineNumber;
        savedCharPosition = charPosition;

        while (true) { //Keep going until we return something
            if (lineNumber < data.length) { //Visit all lines
                if (charPosition < (data[lineNumber]).length()) { //Visit all chars on a line
                    return data[lineNumber].charAt(charPosition++);
                } else {
                    lineNumber++;
                    charPosition = 0;
                }
            } else {
                return 0x7f; //Symbolizes EOF
            }
        }
    }

    void UngetNextCharacter() {
        lineNumber = savedLineNumber;
        charPosition = savedCharPosition;
    }

    void SetParsedTk(Token Tk) { //Usd to pass back the token value parsed from raw input
        this.parsedTk = Tk;
    }

    Token GetParsedTk() {
        return parsedTk;
    }

}
