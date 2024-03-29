package customThreadPoolExecutor.model;

import customThreadPoolExecutor.constants.ScheduledTaskType;

/*custom thread pool executor*/
public class ScheduledTask implements Comparable<ScheduledTask> {
    private final Runnable task;
    private Long scheduledExecutionTime;
    private final ScheduledTaskType scheduledTaskType;
    private Long schedulePeriodInMillis;

    public ScheduledTask(Runnable task, Long scheduledExecutionTime, ScheduledTaskType scheduledTaskType) {
        this.task = task;
        this.scheduledExecutionTime = scheduledExecutionTime;
        this.scheduledTaskType = scheduledTaskType;
    }

    public ScheduledTask(Runnable task, Long scheduledExecutionTime, ScheduledTaskType scheduledTaskType,
            Long schedulePeriodInMillis) {
        this.task = task;
        this.scheduledExecutionTime = scheduledExecutionTime;
        this.scheduledTaskType = scheduledTaskType;
        this.schedulePeriodInMillis = schedulePeriodInMillis;
    }

    public Runnable getTask() {
        return task;
    }

    public Long getScheduledExecutionTime() {
        return scheduledExecutionTime;
    }

    public ScheduledTaskType getScheduledTaskType() {
        return scheduledTaskType;
    }

    public Long getSchedulePeriodInMillis() {
        return schedulePeriodInMillis;
    }

    public void setScheduledExecutionTime(Long scheduledExecutionTime) {
        this.scheduledExecutionTime = scheduledExecutionTime;
    }

    @Override
    public int compareTo(ScheduledTask o) {
        return (int) (scheduledExecutionTime - o.scheduledExecutionTime);
    }

    @Override
    public String toString() {
        return "ScheduledTask{" +
                "scheduledExecutionTime=" + scheduledExecutionTime +
                ", scheduledTaskType=" + scheduledTaskType +
                ", schedulePeriodInMillis=" + schedulePeriodInMillis +
                '}';
    }
}
