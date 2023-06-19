package car_service_billing;

public class ServiceCharges {
    int p;

    public void call(String str, int p) {
        this.p = p;
        // print the service and its price if the given service is mathces anyone
        // condition
        if (str.equals("bs01")) {
            System.out.println("charge for basic service - ₹ " + this.p);
        }
        if (str.equals("ef01")) {
            System.out.println("charge for engine fixing service - ₹ " + this.p);
        }
        if (str.equals("cf01")) {
            System.out.println("charge for cluch fixing service - ₹ " + this.p);
        }
        if (str.equals("bf01")) {
            System.out.println("charge for break fixing service - ₹ " + this.p);
        }
        if (str.equals("gf01")) {
            System.out.println("charge for gear fixing service - ₹ " + this.p);
        }

    }
}
