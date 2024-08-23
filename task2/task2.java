import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        //проверка ввода
        if (args.length != 2) {
            System.out.println("Необходимо указать: <файл_окружности> <файл_точек>");
            return;
        }
        // Считываем данные окружности из первого файла
        double circleX, circleY, radius;
        try (Scanner circleScanner = new Scanner(new File(args[0]))) {
            circleX = circleScanner.nextDouble();
            circleY = circleScanner.nextDouble();
            radius = circleScanner.nextDouble();
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: файл окружности не найден: " + e.getMessage());
            return;
        }
        // Считываем координаты точек из второго файла
        try (Scanner pointScanner = new Scanner(new File(args[1]))) {
            while (pointScanner.hasNextDouble()) {
                double pointX = pointScanner.nextDouble();
                double pointY = pointScanner.nextDouble();

                // Вычисляем расстояние от точки до центра окружности
                double distance = Math.sqrt(Math.pow(pointX - circleX, 2) + Math.pow(pointY - circleY, 2));

                // Определяем положение точки относительно окружности
                int position;
                if (Math.abs(distance - radius) < 1e-6) { // Используем погрешность для сравнения чисел с плавающей точкой
                    position = 0;
                } else if (distance < radius) {
                    position = 1;
                } else {
                    position = 2;
                }

                // Выводим результат
                System.out.println(position);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: файл с точками не найден: " + e.getMessage());
        }
    }
}

