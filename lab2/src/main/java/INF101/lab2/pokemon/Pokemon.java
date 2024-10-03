package INF101.lab2.pokemon;

import java.util.Random;

public class Pokemon {
    ////// Oppgave 1a
    // Create field variables here:
    String name;
    int healthPoints;
    int maxHealthPoints;
    int strength;

    ///// Oppgave 1b
    // Create a constructor here:
    public Pokemon(String name, int healthPoints, int strength) {
        this.name = name;
        this.maxHealthPoints = healthPoints;
        this.healthPoints = this.maxHealthPoints;
        this.strength = strength;
    }

    ///// Oppgave 2
	/**
     * Get name of the pokémon
     * @return name of pokémon
     */
    String getName() {
        return this.name;
    }

    /**
     * Get strength of the pokémon
     * @return strength of pokémon
     */
    int getStrength() {
        return this.strength;
    }

    /**
     * Get current health points of pokémon
     * @return current HP of pokémon
     */
    int getCurrentHP() {
        return this.healthPoints;
    }
    
    /**
     * Get maximum health points of pokémon
     * @return max HP of pokémon
     */
    int getMaxHP() {
        return this.maxHealthPoints;
    }

    /**
     * Check if the pokémon is alive. 
     * A pokemon is alive if current HP is higher than 0
     * @return true if current HP > 0, false if not
     */
    boolean isAlive() {
        if (this.healthPoints > 0) {
            return true;
        }
        return false;
    }


    
    ///// Oppgave 4
    /**
     * Damage the pokémon. This method reduces the number of
     * health points the pokémon has by <code>damageTaken</code>.
     * If <code>damageTaken</code> is higher than the number of current
     * health points then set current HP to 0.
     *
     * It should not be possible to deal negative damage, i.e. increase the number of health points.
     *
     * The method should print how much HP the pokemon is left with.
     *
     * @param damageTaken
     */
    void damage(int damageTaken) {
        if (damageTaken >= maxHealthPoints) {
            damageTaken = maxHealthPoints;
        }
        if (damageTaken <= 0) {
            damageTaken = 0;
        }
        if (healthPoints == 0) {
            damageTaken = 0;
        }
        healthPoints -= damageTaken;
        if (healthPoints < 0) {
            healthPoints = 0;
        }
        System.out.println(name + " takes " + damageTaken + " and is left with " + healthPoints + "/" + maxHealthPoints + " HP");;
    }

    ///// Oppgave 5
    /**
     * Attack another pokémon. The method conducts an attack by <code>this</code>
     * on <code>target</code>. Calculate the damage using the pokémons strength
     * and a random element. Reduce <code>target</code>s health.
     * 
     * If <code>target</code> has 0 HP then print that it was defeated.
     * 
     * @param target pokémon that is being attacked
     */
    void attack(Pokemon target) {
        Random rand = new Random();
        int damageInflincted = (int) (rand.nextInt(this.strength+1));
        if (target.isAlive()) {
            System.out.println(this.getName() + " attacks " + target.getName() + ".");
        }
        target.damage(damageInflincted);
        if (!target.isAlive()) {
            System.out.println(target.getName() + " is defeated by " + this.getName() + ".");
        }


    }

    ///// Oppgave 3
    @Override
    public String toString() {
        return name + " HP: (" + healthPoints + "/" + maxHealthPoints + ") STR: " + strength;
    }

}
