package INF101.lab2.pokemon;

public class Main {

    public static Pokemon pokemon1;
    public static Pokemon pokemon2;
    public static void main(String[] args) {
        ///// Oppgave 6
        // Have two pokemon fight until one is defeated
        pokemon1 = new Pokemon("Pikachu", 94, 12);
        pokemon2 = new Pokemon("Oddish", 100, 3);
        
        System.out.println();
        System.out.println(pokemon1.getName() + " HP: (" + pokemon1.healthPoints + "/" + pokemon1.maxHealthPoints + ") STR: " + pokemon1.strength);
        System.out.println(pokemon2.getName() + " HP: (" + pokemon2.healthPoints + "/" + pokemon2.maxHealthPoints + ") STR: " + pokemon2.strength);
        System.out.println();

        while (true) {
            pokemon1.attack(pokemon2);
            if (!pokemon2.isAlive()) {
                break;
            }
            pokemon2.attack(pokemon1);
            if (!pokemon1.isAlive()) {
                break;
            }
        }
    }
}
