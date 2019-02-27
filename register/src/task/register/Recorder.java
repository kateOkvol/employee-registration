package task.register;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class Recorder {

    private static final String BLANK_SPACE = " ";

    public Recorder() {
    }

    String[] load(String file) {
        String record;
        ArrayList<String> arrString = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((record = reader.readLine()) != null) {
                //System.out.println(record);
                check(record);
                arrString.add(record);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrString.toArray(new String[0]);
    }

    private void check(String record) {
        String[] arr = record.split(BLANK_SPACE);
        for (String subRecord : arr) {
            String[] strDigit = subRecord.split(":");
            int hh = Integer.parseInt(strDigit[0]);
            int mm = Integer.parseInt(strDigit[1]);
            if (!((hh >= 0 && hh <= 23) && (mm >= 0 && mm <= 59))) {
                System.out.println("Incorrect data entry in the file.\n" +
                        "Please make sure that the data is written in the format " +
                        "\"HH:MM HH:MM\" (00:00 ≤ HH:ММ ≤ 23:59).");
                System.exit(0);
            }
        }
    }

    List<Date> processing(String[] test) {
        SimpleDateFormat format = new SimpleDateFormat();
        List<Date> recordsList = new ArrayList<>();
        format.applyPattern("HH:mm");
        for (String record : test) {
            for (String subRecord : record.split(BLANK_SPACE)) {
                try {
                    recordsList.add(format.parse(subRecord));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return recordsList;
    }

    int numberOfEmployees(List<Date> recordsList) {
        int value;
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < recordsList.size() - 3; i += 2) {
            value = 1;
            Date d = recordsList.get(0);
            Date d1 = recordsList.get(1);
            for (int j = recordsList.size() - 3; j >= 1; j -= 2) {
                Date d2 = recordsList.get(j + 1);
                Date d3 = recordsList.get(j + 2);
                if ((d.before(d3) || d.equals(d3)) &&
                        (d2.before(d1) || d2.equals(d1))) {
                    if (d.before(d2)) d = d2;
                    if (d3.before(d1)) d1 = d3;
                    value++;
                }
            }
            values.add(value);
            Collections.swap(recordsList, 0, recordsList.size() - 2 - i);
            Collections.swap(recordsList, 1, recordsList.size() - 1 - i);
        }
        return Collections.max(values);
    }
}






