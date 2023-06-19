package car_service_billing;

import java.util.Scanner;

public class ServiceList {
    int bs;
    int ef;
    int cf;
    int bf;
    int gf;
    // total var to calculate the total price
    int total = 0;
    // getting the information from user which service he want then store into the
    // string object
    String[] sr = new String[5];

    ServiceList() {

    }

    // creating parameterized constracter for initilize the service price
    ServiceList(int bs, int ef, int cf, int bf, int gf) {
        this.bs = bs;
        this.ef = ef;
        this.cf = cf;
        this.bf = bf;
        this.gf = gf;
    }

    // creating scanner objct for getting the input from user
    Scanner obj = new Scanner(System.in);

    // service provided method
    public void enters() {
        System.out.println("----------------------------------------------");
        System.out.println("Availble Services with Service Code");
        System.out.println("-----------------------------------------------");
        System.out.println("Basic Service             bs01 ");
        System.out.println("Enginge Fixing Service    ef01 ");
        System.out.println("Cluch Fixing Service      cf01 ");
        System.out.println("Break Fixing Service      bf01 ");
        System.out.println("Gear Fixing Service       gf01 ");

        // asking the user for how many service you want
        System.out.println("enter no of sevice");
        int n = obj.nextInt();
        obj.nextLine();
        // enter the service code yoy want
        System.out.println("Eneter s code");
        for (int i = 0; i < n; i++) {
            // storing the service code
            sr[i] = obj.nextLine();

        }

        // creating object of sa claas , bcs it has printing service method
        ServiceCharges obj11 = new ServiceCharges();
        for (int j = 0; j < n; j++) {
            // assign the services from string to temp var and checking each with services
            // availble
            String tem = sr[j];

            if (tem.equals("bs01")) {
                // if service matches calling the method for printing the service with price
                obj11.call("bs01", this.bs);

                // getting the service price and add to the existing total var
                total += this.bs;
            } else if (tem.equals("ef01")) {
                obj11.call("ef01", this.ef);
                total += this.ef;
            } else if (tem.equals("cf01")) {
                obj11.call("cf01", this.cf);
                total += this.cf;
            } else if (tem.equals("bf01")) {
                obj11.call("bf01", this.bf);
                total += this.bf;
            } else if (tem.equals("gf01")) {
                obj11.call("gf01", this.gf);
                total += this.gf;
            }
        }
        System.out.println("Total Bill - ₹ " + total);
    }

}
