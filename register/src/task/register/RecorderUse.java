package task.register;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class RecorderUse {
    public static void main(String[] args) {
        System.out.println("Enter the path to the file:");
        Scanner scanner = new Scanner(System.in);
        Recorder recorder = new Recorder();
        List<Date> list = recorder.processing(recorder.load(scanner.nextLine()));
        System.out.println("The number: " + recorder.numberOfEmployees(list));
    }
}
