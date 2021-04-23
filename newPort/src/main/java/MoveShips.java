import static java.lang.Thread.sleep;

class MoveShips extends Thread {     //Поток движение

    @Override
    public void run() {

        do {

            Ship ship = new Ship();          //Создание объекта ship

            try {
                if (Port.queue.size() == 10) {   //Информирование о заполнении очереди

                    System.out.println("""

                            Слишком много кораблей, порт приостановил прием
                            """);
                    sleep(10);

                } else {

                    Port.queue.put(ship);       //Добавление корабля в очередь
                    System.out.println("Корабль " + ship + " прибыл в порт" + ship.cargo);
                    System.out.println("Ждут свободного дока " + Port.queue.size() + " кораблей");

                    try {
                        sleep(9);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }

        } while (true);
    }
}