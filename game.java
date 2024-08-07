public class DaggerWeapon implements Weapon {
    @Override
    public void use() {
        System.out.println("Dagger weapon used!");
    }
}

public class DemoMain {
    public static void main(String[] args) {
        // Create game instance
        Game game = Game.getInstance();
        
        // Set easy level factory and play the game
        GameElementFactory easyLevelFactory = new EasyLevelFactory();
        game.setLevelFactory(easyLevelFactory);
        game.play();
        System.out.println("------------");
        
        // Set hard level factory and play the game
        GameElementFactory hardLevelFactory = new HardLevelFactory();
        game.setLevelFactory(hardLevelFactory);
        game.play();
    }
}

public class EasyLevelFactory implements GameElementFactory {
    @Override
    public Enemy createEnemy() {
        return new GoblinEnemy();
    }

    @Override
    public Weapon createWeapon() {
        return new DaggerWeapon();
    }

    @Override
    public PowerUp createPowerUp() {
        return new HealthPowerUp();
    }
}

public interface Weapon {
    void use();
}

public interface Enemy {
    void attack();
}

public class Game {
    private static Game instance;
    private GameElementFactory factory;

    private Game() { } // Private constructor to prevent direct instantiation

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void setLevelFactory(GameElementFactory factory) {
        this.factory = factory;
    }

    public void play() {
        Enemy enemy = factory.createEnemy();
        Weapon weapon = factory.createWeapon();
        PowerUp powerup = factory.createPowerUp();
        enemy.attack();
        weapon.use();
        powerup.activate();
    }
}

public interface GameElementFactory {
    Enemy createEnemy();
    Weapon createWeapon();
    PowerUp createPowerUp();
}

public class GoblinEnemy implements Enemy {
    @Override
    public void attack() {
        System.out.println("Goblin enemy attack!");
    }
}

public class HardLevelFactory implements GameElementFactory {
    @Override
    public Enemy createEnemy() {
        return new OrcEnemy();
    }

    @Override
    public Weapon createWeapon() {
        return new SwordWeapon();
    }

    @Override
    public PowerUp createPowerUp() {
        return new ShieldPowerUp();
    }
}

public class HealthPowerUp implements PowerUp {
    @Override
    public void activate() {
        System.out.println("Health power-up activated!");
    }
}

public class OrcEnemy implements Enemy {
    @Override
    public void attack() {
        System.out.println("Orc enemy attack!");
    }
}

public interface PowerUp {
    void activate();
}

public class ShieldPowerUp implements PowerUp {
    @Override
    public void activate() {
        System.out.println("Shield power-up activated!");
    }
}

public class SwordWeapon implements Weapon {
    @Override
    public void use() {
        System.out.println("Sword weapon used!");
    }
}
