package com.umsl.vasylonufriyev.TokenScanner;

import java.util.HashMap;
import java.util.Map;

public class KeywordTranslatorService {
    private static Map<String, String> keywordDictionary = new HashMap<String, String>() {{
        this.put("start", "START_TK");
        this.put("stop", "STOP_TK");
        this.put("iterate", "ITERATE_TK");
        this.put("void", "VOID_TK");
        this.put("var", "VAR_TK");
        this.put("return", "RETURN_TK");
        this.put("in", "IN_TK");
        this.put("out", "OUT_TK");
        this.put("program", "PROGRAM_TK");
        this.put("cond", "COND_TK");
        this.put("then", "THEN_TK");
        this.put("let", "LET_TK");
        this.put("=", "ASSIGN_TK");
        this.put("<", "LESSTHAN_TK");
        this.put(">", "GREATERTHAN_TK");
        this.put("<=", "LESSTHANEQUAL_TK");
        this.put(">=", "GREATERTHANEQUAL_TK");
        this.put("==", "EQUALCOMPARE_TK");
        this.put(":", "COLON_TK");
        this.put("+", "PLUS_TK");
        this.put("_", "UNDERSCORE_TK");
        this.put("*", "MULT_TK");
        this.put("/", "DIVIDE_TK");
        this.put("%", "MODULO_TK");
        this.put(".", "MEMBER_TK");
        this.put("(", "PARENTHESISOPEN_TK");
        this.put(")", "PARENTHESISCLOSE_TK");
        this.put(",", "COMMA_TK");
        this.put("{", "CURLYBRACEOPEN_TK");
        this.put("}", "CURLYBRACECLOSE_TK");
        this.put("[", "SQUAREBRACKETOPEN_TK");
        this.put("]", "SQUAREBRACKETCLOSE_TK");
    }};

    public static String TryTranslateToToken(String key) {
        return keywordDictionary.getOrDefault(key, null);
    }

    private static Map<Character, Integer> charColumnDictionary = new HashMap<Character, Integer>() {{
        this.put('=', 2);
        this.put('<', 3);
        this.put('>', 4);
        this.put(':', 5);
        this.put('+', 6);
        this.put('_', 7);
        this.put('*', 8);
        this.put('/', 9);
        this.put('%', 10);
        this.put('.', 11);
        this.put('(', 12);
        this.put(')', 13);
        this.put(',', 14);
        this.put('{', 15);
        this.put('}', 16);
        this.put('[', 17);
        this.put(']', 18);
        this.put((char)0xe65, 20);
    }};


    public static int TryTranslateToColumnPosition(char key) {
        if(Character.isAlphabetic(key)) //If it is a letter, that is stored in column 0
            return 0;
        if(Character.isDigit(key)) //if it is a digit, it is stored in column 1
            return 1;
        if(Character.isWhitespace(key)) //If it is a whitespace, it is stored in column 19
            return 19;

        return charColumnDictionary.getOrDefault(key, 1021); //If returns 1021, invalid character detected.
    }

    private static Map<Integer, String> errorStatesDictionary = new HashMap<Integer, String>() {{
        this.put(1000, "Alpha is not allowed in attempted context");
        this.put(1001, "Digit is not allowed in attempted context");
        this.put(1002, "= is not allowed in attempted context");
        this.put(1003, "< is not allowed in attempted context");
        this.put(1004, "> is not allowed in attempted context");
        this.put(1005, ": is not allowed in attempted context");
        this.put(1006, "+ is not allowed in attempted context");
        this.put(1007, "_ is not allowed in attempted context");
        this.put(1008, "* is not allowed in attempted context");
        this.put(1009, "/ is not allowed in attempted context");
        this.put(1010, "% is not allowed in attempted context");
        this.put(1011, ". is not allowed in attempted context");
        this.put(1012, "( is not allowed in attempted context");
        this.put(1013, ") is not allowed in attempted context");
        this.put(1014,",is not allowed in attempted context");
        this.put(1015, "{ is not allowed in attempted context");
        this.put(1016, "} is not allowed in attempted context");
        this.put(1017, "[ is not allowed in attempted context");
        this.put(1018, "] is not allowed in attempted context");
        this.put(1019, "Whitespace is not allowed in attempted context");
        this.put(1020, "EOF is not allowed in attempted context");
        this.put(1021, "Could not parse character");
    }};
}
