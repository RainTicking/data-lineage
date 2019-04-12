package com.ganglee.datalineage.parser;


import org.apache.hadoop.hive.ql.lib.Node;
import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.apache.hadoop.hive.ql.parse.HiveParser;
import org.apache.hadoop.hive.ql.parse.ParseDriver;
import org.apache.hadoop.hive.ql.parse.ParseException;

import java.io.IOException;
import java.util.ArrayList;


public class Parser  {


    public void sqlparse()  throws ParseException{
        String sql = "select dd+1 from(select id+1 dd from zpc) d";
        ParseDriver pd = new ParseDriver();
        //HiveParser hp = new HiveParser();
        ASTNode ast = pd.parse(sql);
        System.out.println(ast.toStringTree());
        System.out.println(ast.getChild(1).getChildCount());
        System.out.println(ast.getChild(0).getChildCount());
        System.out.println(ast.getChild(0).getChild(0).toStringTree());
        System.out.println(ast.getChild(0).getChild(0).toString());


       int i = 0;
       while(ast.getChildCount()>0){
           System.out.println("当前节点"+i+"token"+ast.getText());
           if(ast.getChildCount()==1){
               System.out.println("节点"+i+"左子树"+ast.getChild(0).toStringTree());
               ast = (ASTNode)ast.getChild(0);
           }else{
               System.out.println("节点"+i+"左子树"+ast.getChild(0).toStringTree());
               System.out.println("节点"+i+"右子树"+ast.getChild(1).toStringTree());
               ast = (ASTNode)ast.getChild(0);
           }
            i++;
       }



        ArrayList<Node>  alnode = ast.getChildren();
        System.out.println(alnode.get(0).getName());
        //while(!alnode.isEmpty())
        //System.out.println(alnode.toString());


        // System.out.println(ast.token);



    }





}
