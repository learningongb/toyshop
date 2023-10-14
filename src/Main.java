import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Logger logger = new Logger();
        int countMeashuring = 3;
        int countInMeashure = 10;

        ToysQueue toysQueue = new ToysQueue();
        toysQueue.put("1 2 конструктор");
        toysQueue.put("2 2 робот");
        toysQueue.put("3 6 кукла букла");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yy hh:mm:ss");
        logger.log("Начало замера: " + simpleDateFormat.format(new Date()));

        for (int i=0; i<countMeashuring; i++) {
            logger.log("Замер № " + (i + 1));
            for (int j = 0; j < countInMeashure; j++) {
                logger.log(String.join(" ", toysQueue.get()));
            }

            logger.log(toysQueue.getStatistic());
            toysQueue.clearStatistic();
        }
    }
}