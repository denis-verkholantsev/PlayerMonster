import java.util.Random;

class Creature{
    private final int attack;
    private final int defense;
    protected int health;
    protected final int maxHealth;
    private final Range rangeDamage;
    public Creature(int attack, int defense, int health, int startRange, int stopRange) {
        if (isValidAttackDefense(attack) || isValidAttackDefense(defense) ||
                !isValidDamageRange(startRange, stopRange) || health < 0) {
            throw new IllegalArgumentException("Invalid input values");
        }
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.maxHealth = health;
        this.rangeDamage = new Range(startRange, stopRange);
    }

    private boolean isValidAttackDefense(int X) {
        return X <= 0 || X >= 31;
    }

    private boolean isValidDamageRange(int lhs, int rhs) {
        return !(lhs > rhs || lhs < 0);
    }

    public boolean isAlive(){
        return health > 0;
    }

    private int attackModifier(Creature target){
        return this.attack - target.defense + 1;
    }

    private boolean rollingDies(int N){
        if(N < 1){
            N = 1;
        }
        Random randInt = new Random();
        for(int i=0; i<N; ++i){
            int rand = randInt.nextInt(6) + 1;
            if (rand == 5 || rand == 6){
                return true;
            }
        }
        return false;
    }

    private void damageInfliction(int damage){
        health = Math.max(health - damage, 0);
    }

    public void attack(Creature target) {
        if (rollingDies(attackModifier(target))) {
            int damage = rangeDamage.getRand();
            target.damageInfliction(damage);
        }
    }
    public int getHealth(){
        return this.health;
    }
}
