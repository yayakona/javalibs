package utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimestampUtils {

    private static String defaultTimestampFormat = "yyyy/MM/dd HH:mm:ss";

    /**
     * 日付文字列がtimestampのフォーマットとして有効であるかを判断する
     * Todo "2000/2/29  01:02:24"がfalseになる
     * SimpleDateFormatは前方一致問題もあってどうしよう
     *
     * @param date 確認したい日付文字列
     * @return 有効であるか
     */
    public static Boolean isValidFormat(String date){

        DateFormat dataFormat = new SimpleDateFormat(defaultTimestampFormat);
        dataFormat.setLenient(false);

        try{
            return dataFormat.format(dataFormat.parse(date)).equals(date);
        } catch (ParseException e){
            return false;
        }
        //return true;

    }

    /**
     * 現在日付を取得する
     *
     * @return 現在日付を表すtimestamp
     */
    public static String getCurrentTimestamp(){

        return new SimpleDateFormat()
                .format(new Timestamp(System.currentTimeMillis()));
    }

    /**
     * 日付文字列を元にtimestamp型に変換する
     *
     * @param timeString 変換したい日付文字列
     * @return timeStringを元に作成したtimestamp
     */
    public static Timestamp getTimestamp(String timeString){

        try {
            return new Timestamp(
                    new SimpleDateFormat(defaultTimestampFormat)
                        .parse(timeString).getTime()
            );
        } catch (ParseException e){
            return null;
        }
    }

    /**
     * timestampを任意の日数を加算する
     *
     * @param orgTimestamp 加算元のtimestamp
     * @param days 加算したい日数
     * @return 加算後のtimestamp
     */
    public static Timestamp addDaysIntoTimestamp(Timestamp orgTimestamp, Integer days){

        Calendar cal = Calendar.getInstance();
        cal.setTime(orgTimestamp);
        cal.add(Calendar.DAY_OF_MONTH, days);

        return new Timestamp(cal.getTimeInMillis());
    }
}