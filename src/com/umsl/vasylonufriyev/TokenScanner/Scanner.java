package com.umsl.vasylonufriyev.TokenScanner;

import com.umsl.vasylonufriyev.DataStructures.ProgramDataBuffer;
import com.umsl.vasylonufriyev.DataStructures.Token;

public class Scanner {
    /*
     * State array. Initial values for each row are:
     * 1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 1010, 1011, 1012, 1013, 1014, 1015, 1016, 1017, 1018, 1019, 1020
     */
    int[][] FAD = new int[][]{
            //Initial state. If number, transfer to number state.
            {1000, 1, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 1010, 1011, 1012, 1013, 1014, 1015, 1016, 1017, 1018, 0, -23},
            //Number state. Keep getting integer values until any other character comes by.
            {-22, 1, -22, -22, -22, -22, -22, -22, -22, -22, -22, -22, -22, -22, -22, -22, -22, -22, -22, -22, -22}
    };

    public ProgramDataBuffer ScannerDriver(ProgramDataBuffer data) throws Exception {
        String proccessedData = "";
        int state = 0;
        int nextState = 0;
        char nextChar = data.GetNextCharacter();
        int nextColumn = 0;

        while (state >= 0) {
            nextColumn = KeywordTranslatorService.TryTranslateToColumnPosition(nextChar);

            if (nextColumn < 1000) { //if a character fails to parse, it returns 1021. This will be handled further on
                nextState = FAD[state][nextColumn];
            } else {
                nextState = nextColumn;
            }

            if (nextState >= 1000) {
                throw new Exception("ERR" + nextState + ":" + data.GetLineNumber() + ":" + data.GetCharPosition() + ": "
                        + KeywordTranslatorService.TryTranslateErrorCode(nextState));
            }
            if (nextState < 0) {
                if (nextState == -21) { //Identifier token final state
                    if (KeywordTranslatorService.TryTranslateToToken(state) != null) {
                        data.SetParsedTk(new Token(KeywordTranslatorService.TryTranslateToToken(nextState), "", data.GetLineNumber()));
                        return data;
                    } else {
                        data.SetParsedTk(new Token(KeywordTranslatorService.tryTranslateExitState(nextState), proccessedData, data.GetLineNumber()));
                        return data;
                    }
                } else {
                    data.SetParsedTk(new Token(KeywordTranslatorService.tryTranslateExitState(nextState), proccessedData, data.GetLineNumber()));
                    return data;
                }
            } else {
                state = nextState;
                if(nextChar != ' ')
                    proccessedData += nextChar;
                nextChar = data.GetNextCharacter();
            }
        }

        return data;
    }
}
