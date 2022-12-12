package com.mao.design.design.pattern.behavioral.state.example;

/**
 * 抽象活动接口
 */
interface ActivityInterface {
    void participate(Long userId);
}

/**
 * 抽象装饰角色
 * 装饰器模式[1-5]的定义：指在不改变现有对象结构的情况下，动态地给该对象增加一些职责（即增加其额外功能）的模式，它属于对象结构型模式。
 * 装饰器模式主要包含以下角色：
 * 抽象构件（Component）角色：定义一个抽象接口以规范准备接收附加责任的对象。
 * 具体构件（ConcreteComponent）角色：实现抽象构件，通过装饰角色为其添加一些职责。
 * 抽象装饰（Decorator）角色：继承抽象构件，并包含具体构件的实例，可以通过其子类扩展具体构件的功能。
 * 具体装饰（ConcreteDecorator）角色：实现抽象装饰的相关方法，并给具体构件对象添加附加的责任。
 */
abstract class ActivityDecorator implements ActivityInterface {
    protected ActivityInterface activity;
    public ActivityDecorator(ActivityInterface activity) {
        this.activity = activity;
    }

    @Override
    public abstract void participate(Long userId);
}

/**
 * 能够对活动做风险控制的包装类
 */
class RiskControlDecorator extends ActivityDecorator {
    public RiskControlDecorator(ActivityInterface activity) {
        super(activity);
    }
    @Override
    public void participate(Long userId) {
        // 对目标用户做风险控制，失败则抛出异常
        Risk.doControl(userId);
        // 更新任务状态为进行中
        activity.participate(userId);
    }
}

/**
 * 活动类
 */
class Activity implements ActivityInterface {
    protected String type;
    protected Long id;
    protected String name;
    protected Integer scene;
    protected String material;

    /**
     * 全参构造函数
     *
     * @param type
     * @param id
     * @param name
     * @param scene
     * @param material
     */
    public Activity(String type, Long id, String name, Integer scene, String material) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.scene = scene;
        this.material = material;
    }

    @Override
    public void participate(Long userId) {
        // do nothing
    }

    /**
     * 静态建造器类，使用奇异递归模板模式允许继承并返回继承建造器类
     *
     * @param <T>
     */
    public static class Builder<T extends Builder<T>> {
        protected String type;
        protected Long id;
        protected String name;
        protected Integer scene;
        protected String material;

        public T setType(String type) {
            this.type = type;
            return (T) this;
        }

        public T setId(Long id) {
            this.id = id;
            return (T) this;
        }

        public T setId() {
            if ("period".equals(this.type)) {
                this.id = 0L;
            }
            return (T) this;
        }

        public T setScene(Integer scene) {
            this.scene = scene;
            return (T) this;
        }

        public T setMaterial(String material) {
            this.material = material;
            return (T) this;
        }

        public T setName(String name) {
            if ("period".equals(this.type)) {
                this.name = "period" + name;
            } else {
                this.name = "normal" + name;
            }
            return (T) this;
        }

        public Activity build() {
            return new Activity(type, id, name, scene, material);
        }
    }
}

/**
 * 任务型活动
 */
class TaskActivity extends Activity {
    protected Task task;

    /**
     * 全参构造函数
     *
     * @param type
     * @param id
     * @param name
     * @param scene
     * @param material
     * @param task
     */
    public TaskActivity(String type, Long id, String name, Integer scene, String material, Task task) {
        super(type, id, name, scene, material);
        this.task = task;
    }

    // 参与任务型活动
    @Override
    public void participate(Long userId) {
        // 对目标用户做风险控制，失败则抛出异常
        Risk.doControl(userId);
        // 更新任务状态为进行中
        task.getState().update(task, ActionType.START);
    }

    /**
     * 继承建造器类
     */
    public static class Builder extends Activity.Builder<Builder> {
        private Task task;

        public Builder setTask(Task task) {
            this.task = task;
            return this;
        }

        @Override
        public TaskActivity build() {
            return new TaskActivity(type, id, name, scene, material, task);
        }
    }
}

/**
 * 风险
 */
class Risk {
    public static void doControl(Long userId) {

    }
}