package sellweb.utils;

import java.util.Random;

public class KeyUtil {

    /**
     * produce the unique key
     * format is current time with a random number
     * @return the unique key
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
