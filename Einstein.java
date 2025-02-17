import java.util.Scanner;

/**
* The Einstein program asks the user to enter the mass of an object.
* It then sees how much energy could be released from that object.
* It also includes a loop, try ... catch and is rounded to 3 decimal places.

*
* @author Noah Smith
* @version 1.0
* @since 2025-02-16
*/

final class Einstein {

    /**
    * The speed of light in metres per second.
    */
    public static final double SPEED_OF_LIGHT = (2.998 * Math.pow(10, 8));

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
    */
    private Einstein() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(final String[] args) {
        // Using Scanner for getting input from user
        Scanner scanner = new Scanner(System.in);

        // Greet user
        System.out.println("Welcome to the Einstein equation program!");

        // Loop to give user another chance to enter valid input
        do {
            // Ask the user to enter the mass of the object in kilograms
            System.out.println("Enter the mass of your object (kg): ");

            // Try to Catch invalid input
            try {
                // Get the object mass from the user as a double
                double objMass = scanner.nextDouble();

                // Check user's object mass to make sure it is valid
                if (objMass <= 0) {
                    System.out.println(
                            "The mass must be greater than 0. Try again."
                        );
                } else {
                    // Calculate the energy
                    double objEnergy = objMass * Math.pow(SPEED_OF_LIGHT, 2);

                    // Display the energy, rounded to 3 decimal places
                    System.out.println(
                            String.format("%.3f", objEnergy)
                            + "J of energy can be released from your object. "
                        );

                    // break from the loop
                    break;
                }
            // Catch invalid input
            } catch (Exception exception) {
                // If the user does not enter a number
                System.out.println("Please enter a number.");
                System.out.println("Try again.");

                // Move on to the next line of input
                // to prevent potential infinite loop
                scanner.nextLine();
            }
        }
        // Keep looping while input is still invalid
        while (true);

        // Closing Scanner
        scanner.close();
    }
}
