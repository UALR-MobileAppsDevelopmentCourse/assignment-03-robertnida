package com.ualr.simpletasklist.model;

import java.util.HashMap;
import java.util.Map;

public class TaskList {
    // TODO 03. Define TaskList's attributes. The class will have just one attribute to store all
    //  the tasks created by the user.
    // TODO 04. Define the class constructor and the corresponding getters and setters.
    private final Map<Integer, Task> taskList;
    public TaskList() {
        taskList = new HashMap<>();

    }
    public String getKeyDesc(Integer id)
    {
        Task retrieved = this.taskList.get(id);
        return retrieved.getTaskDesc();
    }

    public String getTaskDone(Integer id)
    {
        Task status = this.taskList.get(id);
        return status.getTaskDone();

    }
    public void setTaskDone(Integer id)
    {

        Integer key =id;
        Task change = this.taskList.get(id);
        change.setTaskDone("Finished!");

    }
    // TIP. We need a data structure able to dynamically grow and shrink. That's why we'll use a HashMap.
    // where keys will be integer values and the mapped values will be a task object

    // TODO 06.03. Define a new method called "add" that, given a task description, will create a
    //  new task and add it to the task list.
    public void add(String taskDesc) {
        Task newTask = new Task(taskDesc);
        Integer key = taskList.size() + 1;
        this.taskList.put(key, newTask);
    }

    // TODO 06.04. Define a new "toString" method that provides a formatted string with all the tasks in the task list.
    public String toString() {
        String formatted = "";
        String status;
        Integer i =  this.taskList.size();
        while(i !=0)
        {
            status  = this.getTaskDone(i);
            formatted += i.toString() + "-" + this.getKeyDesc(i) + "     " + status + "“\n”";
            i--;
        }
        return formatted;
    }

    // TODO 07.03. Define a new method called "delete" that, given a task id, will delete the
    //  corresponding task from the task list.
    public void delete (String key) {
        int intKey;
        try {
            intKey = Integer.parseInt(key);
        }
        catch (NumberFormatException e)
        {
            intKey = 0;
        }
        this.taskList.remove(intKey);
    }

    // TODO 08.03. Define a new method called "markDone" that, given a task id, will mark the
    //  corresponding task as done.
    public void markDone(Integer id){
        this.setTaskDone(id);
    }
}
