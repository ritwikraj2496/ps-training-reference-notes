import React from "react";
import { useDispatch } from "react-redux";
import { deleteTask, toggleTask } from "../features/task/taskSlice";

function TaskItem({ task }) {
  const dispatch = useDispatch();

  const handleCheckboxChange = () => {
    dispatch(toggleTask(task.id));
  };

  const taskStyle = {
    textDecoration: task.completed ? "line-through" : "none",
    color: task.completed ? "gray" : "black",
  };

  return (
    <div>
      <li>
        <input
          type="checkbox"
          checked={task.completed}
          onChange={handleCheckboxChange}
        />
        <span style={taskStyle}>{task.text}</span>
        <button
          onClick={() => dispatch(deleteTask(task.id))}
          style={{ marginLeft: "8px" }}
        >
          Delete
        </button>
      </li>

      {/* <li>
        <span style={taskStyle}>{task.text}</span>
        <button onClick={() => dispatch(toggleTask(task.id))}>
          {task.completed ? "Undo" : "Done"}
        </button>
        <button onClick={() => dispatch(deleteTask(task.id))}>Delete</button>
      </li> */}
    </div>
  );
}

export default TaskItem;
