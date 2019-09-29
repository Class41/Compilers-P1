/*
Author: Vasyl Onufriyev
Date: 8.28.2019
Class: CS4280
Instructor: Professor Janikow
Description: Initial point of the program--contains the main function and commandline argument validation/parsing
*/

package com.umsl.vasylonufriyev;

import com.umsl.vasylonufriyev.DataStructures.Tree;
import com.umsl.vasylonufriyev.DatasourceParser.ParseCMD;
import com.umsl.vasylonufriyev.DatasourceParser.ParseFile;

public class Main {
    public static String OUTPUT_BASE_STRING = "";

    public static void main(String[] args) {
        String[] parsedData = classifyAndParseTokens(args);

        if (parsedData == null) { //for the cast that no data was parsed or returned for whatever reason
            return;
        } else if (parsedData.length == 0) { //for case that input file is empty
            System.out.println("Invalid input length");
            return;
        }

        System.out.println("~~ read " + parsedData.length + " tokens. ~~");


    }

    private static String[] classifyAndParseTokens(String[] cmdArgs) {
        String[] dataSet = null;

        switch (cmdArgs.length) { //check length of list
            case 0: //if there is no filename provided
                ParseCMD cmdInputParser = new ParseCMD();
                dataSet = cmdInputParser.getParseResult();
                Main.OUTPUT_BASE_STRING = "tree";
                break;
            case 1: //if a filename is provided
                ParseFile fileInputParser = new ParseFile(cmdArgs[0]);
                dataSet = fileInputParser.getParseResult();

                if (cmdArgs[0].endsWith(".fs19")) //check if the extension is already present
                    Main.OUTPUT_BASE_STRING = cmdArgs[0].substring(0, cmdArgs[0].length() - 5);
                else
                    Main.OUTPUT_BASE_STRING = cmdArgs[0];

                break;
            default: //if more than 1 parameter is provided (filename)
                System.out.println("Input exceeded expected argument count. Expected 0 or 1 got " + cmdArgs.length);
                break;
        }

        return dataSet;
    }
}
