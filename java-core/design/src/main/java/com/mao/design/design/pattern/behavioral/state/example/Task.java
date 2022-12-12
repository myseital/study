package com.mao.design.design.pattern.behavioral.state.example;

import lombok.Data;

@Data
class Task {
    private Long taskId;
    // 初始化为初始态
    private State state = new TaskInit();

//    private Long taskId;
    // 任务的默认状态为初始化
//    private TaskState state = TaskState.INIT;
    // 活动服务
//    private ActivityService activityService;
    // 任务管理器
//    private TaskManager taskManager;

    /**
     * 使用条件分支进行任务更新
     * @param actionType
     */
//    public void updateState(ActionType actionType) {
//        if (state == TaskState.INIT) {
//            if (actionType == ActionType.START) {
//                state = TaskState.ONGOING;
//            }
//        } else if (state == TaskState.ONGOING) {
//            if (actionType == ActionType.ACHIEVE) {
//                state = TaskState.FINISHED;
//                // 任务完成后进对外部服务进行通知
//                activityService.notifyFinished(taskId);
//                taskManager.release(taskId);
//            } else if (actionType == ActionType.STOP) {
//                state = TaskState.PAUSED;
//            } else if (actionType == ActionType.EXPIRE) {
//                state = TaskState.EXPIRED;
//            }
//        } else if (state == TaskState.PAUSED) {
//            if (actionType == ActionType.START) {
//                state = TaskState.ONGOING;
//            } else if (actionType == ActionType.EXPIRE) {
//                state = TaskState.EXPIRED;
//            }
//        }
//    }

    /**
     * 更新状态
     * @param actionType
     */
    public void updateState(ActionType actionType) {
        state.update(this, actionType);
    }
}