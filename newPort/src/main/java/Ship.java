import java.util.Random;

public class Ship {

    int cargo;
int cargoToLoad=1;
int cargoToUnload=2;
int cargoLoadtoAnotherShip=3;
    Ship() {

        int[] cargo12 = {0, 25};
        Random rnd = new Random();
        cargo = cargo12[rnd.nextInt(2)];

    }
}
