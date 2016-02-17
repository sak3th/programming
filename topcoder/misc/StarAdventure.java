package misc;

public class StarAdventure {

    public static void main(String[] args) {
        String str = "mississippi";
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.substring(i) + " " + str.substring(i).hashCode());
        }
    }
}
