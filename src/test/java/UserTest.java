import org.example.Battleship;
import org.example.CardinalPoint;
import org.example.Ship;
import org.example.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class UserTest {
    @Test

    public void userTest() {

        User user = new User(List.of(new Ship(3, new Point(1, 1), new Point(1, 3), CardinalPoint.NORTH), new Ship(3, new Point(3, 3), new Point(3, 5), CardinalPoint.NORTH)));
        User user2 = new User(List.of(new Battleship(5, new Point(1, 1), new Point(1, 5), CardinalPoint.NORTH), new Ship(3, new Point(3, 3), new Point(3, 5), CardinalPoint.NORTH),new Ship(3, new Point(1, 1), new Point(1, 3), CardinalPoint.NORTH)));
        User user3 = new User(new ArrayList<>());
        System.out.println("------------------");
        User user4 = new User(List.of(new Ship(3, new Point(1, 1), new Point(1, 3), CardinalPoint.NORTH), new Ship(3, new Point(3, 3), new Point(3, 5), CardinalPoint.NORTH),new Ship(3, new Point(1, 1), new Point(1, 3), CardinalPoint.NORTH),new Ship(3, new Point(3, 3), new Point(3, 5), CardinalPoint.NORTH)));

        user3.setShip(new Ship(3, new Point(1, 1), new Point(1, 3), CardinalPoint.NORTH));

        System.out.println("------------------");

        Assertions.assertTrue(user.attack(new Point(1, 1), user2));
        Assertions.assertTrue(user.attack(new Point(1, 1), user2));
        Assertions.assertTrue(user.attack(new Point(1, 1), user2));
        Assertions.assertTrue(user.attack(new Point(1, 2), user2));
        Assertions.assertTrue(user.attack(new Point(1, 3), user2));
        Assertions.assertTrue(user.attack(new Point(1, 4), user2));
        System.out.println("------------------");

        Assertions.assertTrue(user.attack(new Point(1, 5), user2));

        System.out.println("------------------");

        Assertions.assertTrue(user.getShot(new Point(1, 3)));
        Assertions.assertTrue(user.getShot(new Point(3, 4)));
        Assertions.assertFalse(user.getShot(new Point(3, 6)));

    }
};
