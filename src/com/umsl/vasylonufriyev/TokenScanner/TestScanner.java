package com.umsl.vasylonufriyev.TokenScanner;

public class TestScanner {
    public TestScanner(String[] parsedData) {
        ProgramDataBuffer t = new ProgramDataBuffer(parsedData);
        Scanner s = new Scanner();
        do {
            try {
                s.ScannerDriver(t);
                System.out.println(t.GetParsedTk().ToString());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(-1);
            }
        } while (t.GetParsedTk().GetTokenType() != "EOF_TK");
    }
}
