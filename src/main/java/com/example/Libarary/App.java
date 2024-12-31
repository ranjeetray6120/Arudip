package com.example.Libarary;

import utility.ConnectionProvider;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Menu menu = new Menu();
        menu.display();
        
        
//        ConnectionProvider.getConnection();
    }
}
