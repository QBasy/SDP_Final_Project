package Observer;

import Interfaces.Character;

import java.util.List;

public interface Observer {
    void update(List<Character> allies, List<Character> enemy);
    void checkForDead(List<Character> allies, List<Character> enemies);
}
