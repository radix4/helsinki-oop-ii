/**
 * This program manages people phone numbers and addresses.
 * @author  Thang Cao
 * @since   06/24/2020
 * */

import phonesearch.PhoneSearch;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        PhoneSearch search = new PhoneSearch(reader);
        search.start();
    }
}
