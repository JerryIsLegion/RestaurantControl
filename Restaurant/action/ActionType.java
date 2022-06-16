package Restaurant.action;

public enum ActionType {
    READER(new ReaderActionExecutor()),
    WRITER(new WriterActionExecutor()),
    SCHEDULE(new ScheduleActionExecutor()),
    SELL(new SellActionExecutor()),
    REPORT(new ReportActionExecutor());

    private final ActionExecutor actionExecutor;

    ActionType(ActionExecutor actionExecutor) {
        this.actionExecutor = actionExecutor;
    }

    public ActionExecutor getActionExecutor() {
        return actionExecutor;
    }
}
