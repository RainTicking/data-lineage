package com.ganglee.datalineage.parser;
import java.io.IOException;
import org.apache.hadoop.hive.ql.parse.ParseException;


public class ParserTest {

    public static void main(String[] args) throws ParseException{
        Parser ps = new Parser();
        ps.sqlparse();


    }

}
