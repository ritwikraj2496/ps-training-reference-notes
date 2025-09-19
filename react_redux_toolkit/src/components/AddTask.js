import React, { useState } from 'react'
import { useDispatch } from 'react-redux';
import { addTask } from '../features/task/taskSlice';
import FilterTasks from './FilterTasks';

function AddTask() {

const [text, setText] = useState("");

const dispatch = useDispatch();

const handleSubmit = (e) => {
  e.preventDefault();
  dispatch(addTask(text));
}

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <input 
        type="text" 
        placeholder="Add a new task"
        value={text} 
        onChange={(e)=>setText(e.target.value)}/>
        <button type='submit'>Add Task</button>
      </form>
      <FilterTasks/>
    </div>
  )
}

export default AddTask
