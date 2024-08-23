import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class task4 {
    public static void main(String[] args) {
        // Создаем список для хранения чисел
        List<Integer> list_nums = new ArrayList<>();
        try {
            File file = new File(args[0]);
            Scanner scanner = new Scanner(file);
            // Читаем числа из файла и добавляем их в список
            while (scanner.hasNextInt()) {
                list_nums.add(scanner.nextInt());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден");
        }
        // Находим медиану и выводим результат
        int median = solver(list_nums, 0, list_nums.size() - 1, (list_nums.size() + 1) / 2);
        System.out.println(deviation (list_nums, median));
    }
    // Рекурсивный метод для нахождения медианы
    static int solver(List<Integer> list_nums, int start, int end, int k) {
        int pivotPosition = pivotPositionSolver(list_nums, start, end);

        if (pivotPosition < k - 1) {
            return solver(list_nums, pivotPosition + 1, end, k);
        } else if (pivotPosition == k - 1) {
            return list_nums.get(pivotPosition);
        } else {
            return solver(list_nums, start, pivotPosition - 1, k);
        }
    }
    //выбор опорного элемента и перестановки
    public static int pivotPositionSolver(List<Integer> list_nums, int left, int right) {
        int pivot = list_nums.get(right);
        int pivotPosition = left;

        for (int i = left; i <= right; i++) {
            if (list_nums.get(i) < pivot) {
                int temp = list_nums.get(i);
                list_nums.set(i, list_nums.get(pivotPosition));
                list_nums.set(pivotPosition, temp);
                ++pivotPosition;
            }
        }

        int temp = list_nums.get(right);
        list_nums.set(right, list_nums.get(pivotPosition));
        list_nums.set(pivotPosition, temp);
        return pivotPosition;
    }
    //отклонение от медианы
    private static int deviation (List<Integer> list, Integer median) {
        int deviation  = 0;
        for (Integer value : list) {
            deviation  += Math.abs(value - median);
        }
        return deviation ;
    }
}
