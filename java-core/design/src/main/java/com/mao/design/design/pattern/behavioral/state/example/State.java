package com.mao.design.design.pattern.behavioral.state.example;

/**
 * 任务状态抽象接口
 */
interface State {
    /**
     * 默认实现，不做任何处理
     *
     * @param task
     * @param actionType
     */
    default void update(Task task, ActionType actionType) {
        // do nothing
    }
}

/**
 * 任务初始状态
 */
class TaskInit implements State {
    @Override
    public void update(Task task, ActionType actionType) {
        if (actionType == ActionType.START) {
            TaskOngoing taskOngoing = new TaskOngoing();
            taskOngoing.add(new ActivityObserver());
            taskOngoing.add(new TaskManageObserver());
            task.setState(taskOngoing);
//            task.setState(new TaskOngoing());
        }
    }
}

/**
 * 任务进行状态
 */
class TaskOngoing extends Subject implements State {
    private ActivityService activityService;
    private TaskManager taskManager;

    @Override
    public void update(Task task, ActionType actionType) {
        if (actionType == ActionType.ACHIEVE) {
            task.setState(new TaskFinished());
            // 通知
//            activityService.notifyFinished(task.getTaskId());
//            taskManager.release(task.getTaskId());
            notifyObserver(task.getTaskId());
        } else if (actionType == ActionType.STOP) {
            task.setState(new TaskPaused());
        } else if (actionType == ActionType.EXPIRE) {
            task.setState(new TaskExpired());
        }
    }
}

/**
 * 任务暂停状态
 */
class TaskPaused implements State {
    @Override
    public void update(Task task, ActionType actionType) {
        if (actionType == ActionType.START) {
            task.setState(new TaskOngoing());
        } else if (actionType == ActionType.EXPIRE) {
            task.setState(new TaskExpired());
        }
    }
}

/**
 * 任务完成状态
 */
class TaskFinished implements State {

}

/**
 * 任务过期状态
 */
class TaskExpired implements State {

}