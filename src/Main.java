import java.util.Random;

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
        //
        // If there's more than 1 winner:
        if (dupe_count > 1) {
            // Create an array to hold the list of tied names.
            String[] tied_names = new String[dupe_count];
            // Create array to hold the index number of each tied name.
            int[] names_index = new int[dupe_count];
            // Incrementer for the loop.
            int tied_names_index = 0;

            // Print initial text:
            System.out.print("Tie between ");

            // Loop: If the `asterisk_count[i]` is equal to `biggest`, add name to `tied_names`
            // Manually increment a counter every time something is added to `tied_names`, so
            // you know what node of `tied_names` you're adding to. Print results.
            for (int i = 0; i < asterisk_count.length; i++) {
                if (asterisk_count[i] == biggest) {
                    tied_names[tied_names_index] = names[i];
                    names_index[tied_names_index] = i;
                    System.out.print(names[i]);
                    if (tied_names_index < dupe_count - 1) {
                        System.out.print(" and ");
                    }
                    tied_names_index++;
                }
            }
            System.out.println();

            // Tiebreaker routine
            // Pick a random winner from `tied_names`
            Random rand = new Random();
            int random_winner = rand.nextInt(tied_names.length);

            // Print winner.
            System.out.println("Student selected: " + (names_index[random_winner] + 1) + ", " +
                names[names_index[random_winner]]);
        } else {
            // if there's only one winner, we don't have as much to process.
            // Create a string and an int to hold the name of the winner and the winner's index from
            // the `name` array
            String winner = "nerf";
            int name_index = -1;
            for (int i = 0; i < asterisk_count.length; i++) {
                if (asterisk_count[i] == biggest) {
                    winner = names[i];
                    name_index = i;
                }
            }
            System.out.println("Student selected: " + (name_index + 1) + ", " + winner);
        }
    }
}
