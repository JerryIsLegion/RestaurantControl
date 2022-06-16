package Restaurant.action.schedule;

public enum ScheduleType {
    N_DAY(new SetDayScheduleExecutor()),
    N_WEEK(new SetWeekScheduleExecutor()),
    N_LINE(new SetLineScheduleExecutor()),
    R_DAY(new RemoveDayScheduleExecutor()),
    R_WEEK(new RemoveWeekScheduleExecutor()),
    R_LINE(new RemoveLineScheduleExecutor()),
    PRINT(new PrintScheduleExecutor());

    private final ScheduleExecutor scheduleExecutor;

    ScheduleType(ScheduleExecutor scheduleActions) {
        this.scheduleExecutor = scheduleActions;
    }

    public ScheduleExecutor getScheduleExecutor() {
        return scheduleExecutor;
    }
}
