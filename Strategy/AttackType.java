package Strategy;

import Decorator.Character;
import Factory.Human;

public interface AttackType {
    void attack(Character allie, Character enemy);
}
