import org.apache.commons.lang3.StringUtils;
import utils.TimestampUtils;

import java.sql.Timestamp;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println(TimestampUtils.isValidFormat("2004/02/29 01:02:24"));
        System.out.println(TimestampUtils.isValidFormat("2005/02/29 01:02:24"));
        System.out.println(TimestampUtils.isValidFormat("2004/13/01 01:02:24"));
        System.out.println(TimestampUtils.isValidFormat("2000/2/29  01:02:24"));
        System.out.println(TimestampUtils.isValidFormat("2004/02/29 01:02:24"));
    }
}