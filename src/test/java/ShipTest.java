import org.example.CardinalPoint;
import org.example.Ship;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class ShipTest {
    @Test

    public void testShip() {
        Ship ship = new Ship(2, new Point(1, 1), new Point(1, 3), CardinalPoint.NORTH);
        Ship ship2 = new Ship(2, new Point(1, 1), new Point(1, 3), CardinalPoint.NORTH);
        Ship ship3 = new Ship(3, new Point(1, 1), new Point(1, 3), CardinalPoint.NORTH);
        Ship ship4 = new Ship(6, new Point(1, 1), new Point(1, 3), CardinalPoint.NORTH);

        Assertions.assertEquals(CardinalPoint.NORTH, ship.getDirection());
        Assertions.assertFalse(ship.getShot(new Point(0, 0)));
        Assertions.assertTrue(ship.getShot(new Point(1, 1)));
        Assertions.assertTrue(ship.getShot(new Point(1, 2)));




    }

}
