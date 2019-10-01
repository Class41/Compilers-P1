/*
Author: Vasyl Onufriyev
Date: 10.1.19
Class: CS4280
Instructor: Professor Janikow
Description: Holds filtered data and provides an easy-to-use interface for the scanner.
Handles getting/returning characters, and storing line numbers.
This object will be passed back and forth between the caller of the scanner and the scanner itself to keep
track of position in file and also transmit the token that was parsed.
*/

package com.umsl.vasylonufriyev.TokenScanner;

import com.umsl.vasylonufriyev.DataStructures.Token;

class ProgramDataBuffer {

    private String[] data; //Contains filtered data free of comments

    int GetLineNumber() {
        return lineNumber;
    } //Getter

    int GetCharPosition() {
        return charPosition;
    } //Getter

    private int savedLineNumber; //Saved previous position for easy rollback
    private int savedCharPosition; //Saved previous position for easy rollback
    private int lineNumber; //Line number currently on
    private int charPosition; //Character position on the line

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

    void UngetNextCharacter() { //Return the character back and don't consume it
        lineNumber = savedLineNumber;
        charPosition = savedCharPosition;
    }

    void SetParsedTk(Token Tk) { //Usd to pass back the token value parsed from raw input
        this.parsedTk = Tk;
    } //Saves the token generated

    Token GetParsedTk() {
        return parsedTk;
    } //Returns token generated

}
