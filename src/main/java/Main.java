import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Car[] cars = new Car[3];
        Race race = new Race();

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < cars.length; i++) {
            String name;
            System.out.println("Введите название машины №" + (i + 1));
            while (true) {
                name = scanner.nextLine();
                if (!name.isEmpty()) {
                    break;
                } else {
                    System.out.println("У каждой машины есть название! Тут не может быть пусто :(");
                }
            }

            int speed;
            System.out.println("Введите скорость машины №" + (i + 1));
            while (true) {
                // Столкнулся с проблемой проверки пустого ввода и значений "abc/#$%" или "2.50" в int
                // Решение через try/catch подсказал ИИ, так как способы проверки вводимых данных через scanner на курсе ещё не проходили :)
                try {
                    speed = Integer.parseInt(scanner.nextLine());
                    if (speed > 0 && speed <= 250) {
                        cars[i] = new Car(name, speed);
                        race.choosingLeader(cars[i]);
                        break;
                    } else {
                        System.out.println("Введена неверная скорость, введите скорость от 0 до 250!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Введите целочисленное число!");
                }
            }
        }

        System.out.println("Самая быстрая машина " + race.raceLeader);

    }
}

class Car {
    String carName;
    int speed;
    Car(String carName, int speed) {
        this.carName = carName;
        this.speed = speed;
    }
}

class Race {
    String raceLeader = "";
    int leaderDistance = 0;
    public void choosingLeader (Car cars) {
        int distance = 24 * cars.speed;

        if (distance > leaderDistance) {
            raceLeader = cars.carName;
            leaderDistance = distance;
        }
    }
}

