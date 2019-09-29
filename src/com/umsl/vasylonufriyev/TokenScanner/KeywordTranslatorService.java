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

    public static String TryTranslate(String key) {
        return keywordDictionary.getOrDefault(key, null);
    }
}
