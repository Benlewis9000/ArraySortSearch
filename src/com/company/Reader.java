package com.company;

import java.util.Scanner;

public class Reader {

    public Reader () {

    }

    public String getIn (){

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        return str;

    }

}
