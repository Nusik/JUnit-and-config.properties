package task1;

public class Radio {

    String radioType = "weather radio";

    int NumberOfChannels = 7;

    boolean alarmClockPresent = true;

    boolean weatherScan = false;

    String warningAlarm(){
        String alarm = "Tornado!";
        return alarm;
    }

    String fm = null;

    String category(){
        String type = "prime";
        return type;
    }
}
