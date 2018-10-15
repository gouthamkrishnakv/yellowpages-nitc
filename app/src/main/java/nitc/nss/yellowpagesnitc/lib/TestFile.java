package nitc.nss.yellowpagesnitc.lib;

import java.util.Scanner;

class TestFile
{
    public static void main(String[] args) {
        Scanner userScanner = new Scanner(System.in);
        PhoneNumber newphone = new PhoneNumber("919447012779");
        newphone.NumPrint();
        Administration newAdmin = new Administration(userScanner);
        System.out.print(newAdmin.toString());
    }
}