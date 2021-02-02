package ua.rudkovskyi.datetimeapi;

import java.time.ZoneId;
import java.util.List;

public interface Task5 {
    List<ZoneId> zonesAlwaysClockShift(List<ZoneId> zones);
    List<ZoneId> zonesNeverClockShift(List<ZoneId> zones);
    List<ZoneId> zonesChangedClockShiftRules(List<ZoneId> zones);
}
