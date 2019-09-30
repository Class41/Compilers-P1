package com.umsl.vasylonufriyev.TokenScanner;

import com.umsl.vasylonufriyev.DataStructures.Token;

public class Scanner {
    /*
     * State array. Initial values for each row are:
     * 1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 1010, 1011, 1012, 1013, 1014, 1015, 1016, 1017, 1018, 1019, 1020, 1021, 1022, 1023
     */
    int[][] FAD = new int[][]{
            //Initial state. If number, transfer to number state.
            {1000, 2, 1002, 1, 1004, 1005, 1006, 1007, 1008, 1009, 1010, 1011, 1012, 1013, 1014, 1015, 1016, 1017, 1018, 1019, 1020, 0, -23, 1023},
            //Number state. Keep getting integer values until any other character comes by.
            {1000, -22, -22, 1, -22, -22, -22, -22, -22, -22, -22, -22, -22, -22, -22, -22, -22, -22, -22, -22, -22, -22, -22, -22},
            //Identifier state. Keep getting letters/numbers until any other character comes by.
            {1000, 2, 2, 2, -21, -21, -21, -21, -21, -21, -21, -21, -21, -21, -21, -21, -21, -21, -21, -21, -21, -21, -21, -21}
    };

    public ProgramDataBuffer ScannerDriver(ProgramDataBuffer data) throws Exception {
        String proccessedData = "";
        int state = 0;
        int nextState = 0;
        char nextChar = data.GetNextCharacter();
        int nextColumn = 0;

        while (state >= 0) {
            nextColumn = KeywordTranslatorService.TryTranslateToColumnPosition(nextChar);

            if (nextColumn < 1000) { //if a character fails to parse, it returns 1023. This will be handled further on
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
                    if (KeywordTranslatorService.TryTranslateToToken(proccessedData) != null) {
                        data.SetParsedTk(new Token(KeywordTranslatorService.TryTranslateToToken(proccessedData), "", data.GetLineNumber()));
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
