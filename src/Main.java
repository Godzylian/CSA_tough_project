public class Main {
    public static void main(String[] args) {
        // Assign 10 student names to an array:
        String[] names = new String[]{
            "Billy", "Andrew", "Jacob", "Zoey", "Sandra",
            "Jimmy", "Walt", "Barbra", "Gustavo", "Louis"
        };

        // Create a bucket to hold the number of asterisks at each node in the names array.
        int[] asterisk_count = new int[]{
            0, 0, 0, 0, 0,
            0, 0, 0, 0, 0
        };

        // Create a loop that runs 250 times.
        // Each iteration selects a random name from the array.

        for (int i = 0; i < 250; i++) {
            asterisk_count[(int) (Math.random() * 10)]++;
        }

        for (int i = 0; i < names.length; i++) {
            // build an asterisks line
            String asterisks = "";
            for (int j = 0; j < asterisk_count[i]; j++) {
                asterisks += "*";
            }

            // print the output
            System.out.print(i + 1);
            System.out.println(": " + asterisks + " " + names[i]);
        }

        // is there a tie? Look at the asterisk_count array and see if any of the topmost array
        // node values are equal (or, more than 1), and break the tie.

        // Find the maximum value in asterisk_count
        int biggest = 0;
        for (int i = 0; i < asterisk_count.length; i++) {
            if (asterisk_count[i] > biggest) {
                biggest = asterisk_count[i];
            }
        }

        // Create an array to hold the index values of the max values in asterisk_count
        int[] max_index_values = new int[0];
        for (int i = 0; i < asterisk_count.length; i++) {
            max_index_values[i] = asterisk_count[i];
        }

    }
}
