public class Main {
    public static void main(String[] args) {

        Taburetka taburetka = new Taburetka(3, "Trehnogavaja");
        Taburetka taburetka1 = new Taburetka(4, "chetyrehnogavajataburetka");
        TaburetkaService service = new TaburetkaService();
        service.burnTaburetka(taburetka);
        Taburetka taburetka2 = new Taburetka(6);
        System.out.println(taburetka.getNozkiCount());
        taburetka.setNozkiCount(9);
        System.out.println(taburetka.getNozkiCount());
    }

}
