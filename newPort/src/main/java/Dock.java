class Dock implements Runnable {

    Ship ship = null;                   //Переменная хранящая корабль, она будет переписываться после каждого цикла

    @Override
    public void run() {

        System.out.println("Док " + Thread.currentThread().getName() + " активирован");

        try {

            while (true) {
                ship = Port.queue.take();             //Присваивание переменной ship элемента из очереди кораблей
                if ((ship.cargoLoadtoAnotherShip != 0)) {    //Условие груза связанное с грузом коробля
                    ship1.cargo-=ship1.cargoLoadtoAnotherShip;
                    ship0.cargo+=ship1.cargoLoadtoAnotherShip;
                    Thread.sleep(10);         //Ожидание 1 сек

                    System.out.println(Thread.currentThread().getName() + " Началась загрузка " + ship);
                    ship.cargo += 25;                  //Добавление контейнеров на корабль

                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Корабль " + ship + " загружен ");

                } else {                             //Условие противоположное выше стоящему

                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + " Началась разгрузка " + ship);
                    ship.cargo -= 25;                //соответственно разгрузка

                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Корабль " + ship + " разгружен ");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}