import java.util.Date;
import java.util.Formatter;

public class FormatterEx2 {
    public static void main(String[] args) {
        Formatter formatter = new Formatter();

        Date date = new Date();  // Текущая дата и время

        // Использование спецификаторов для времени и даты
        formatter.format("Current time (24-hour format): %tH:%tM:%tS%n", date, date, date); // Часы, минуты, секунды
        formatter.format("Current time (12-hour format): %tI:%tM:%tS %tp%n", date, date, date, date); // 12-часовой формат
        formatter.format("Current year: %tY%n", date); // Год в четырехзначном формате
        formatter.format("Month: %tB%n", date); // Полное название месяца
        formatter.format("Day of the week: %tA%n", date); // Полное название дня недели

        // Вывод
        System.out.println(formatter.toString());
        
        // Закрытие formatter
        formatter.close();
    }
}
