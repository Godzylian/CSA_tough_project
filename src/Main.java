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

        // Get number of items that tie for the top value.
        // to be used for building new array.
        int dupe_count = 0;
        for (int i = 0; i < asterisk_count.length; i++) {
            if (asterisk_count[i] == biggest) {
                dupe_count++;
            }
        }

        // Create array `tied_names` based on `dupe_count` size, to hold the top items.
        // Then, add the top winning names to the `tied_names` array.
        if (dupe_count > 1) {
            String[] tied_names = new String[dupe_count];
            int tied_names_index = 0;

            // Print initial text:
            System.out.print("Tie between ");

            // Loop: If the `asterisk_count[i]` is equal to `biggest`, add name to `tied_names`
            // Manually increment a counter every time something is added to `tied_names`, so
            // you know what node of `tied_names` you're adding to.
            if (dupe_count > 1) {
                for (int i = 0; i < asterisk_count.length; i++) {
                    if (asterisk_count[i] == biggest) {
                        tied_names[tied_names_index] = names[i];
                        System.out.print(names[i]);
                        if (tied_names_index < dupe_count - 1) {
                            System.out.print(" and ");
                        }
                        tied_names_index++;
                    }
                }
                System.out.println();
                System.out.println("Student selected: foo, foo (add code for multiple winners)");
            } else {
                System.out.println("Student selected: (add code for one winner");
            }
        }
    }
}
