package Observer;

import Decorator.Character;
import Factory.Human;

public interface Observer {
    void update(Character human);
}
