public class Main {
    public static void main(String[] args) {
        //Initialize array
        String[] names = new String[]{"Billy", "Andrew", "Jacob", "Zoey", "Sandra", "Jimmy", "Walt", "Barbra", "Gustavo", "Louis"};
        //Array fr will store frequencies of element
        int maxValue = 250;
        int[] fr = new int[names.length];
        int visited = -1;
            for (int i = 0; i < names.length; i++) {
                int count = 1;
                int rand = (int) (Math.random() * names.length);
                String random_name = names[rand];
                for (int j = i + 1; j < names.length; j++) {
                    if (random_name == names[j]) {
                        count++;
                        //To avoid counting same element again
                        fr[j] = visited;
                    }
                }
                if (fr[i] != visited)
                    fr[i] = count;
            }

            //Displays the frequency of each element present in array
        for (int i = 0; i < fr.length; i++) {
                if (fr[i] != visited)
                    System.out.println(names[i] + ": " + fr[i]);
            }
        }
}