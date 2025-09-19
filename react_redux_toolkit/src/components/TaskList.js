import React from 'react'
import { useSelector } from 'react-redux'
import TaskItem from './TaskItem';

function TaskList() {

const {items, filters} = useSelector((state) => state.task);

const filteredItems = filters === 'completed'
? items.filter(task => task.completed)
: items;



  return (
    <ul>
        
      {filteredItems.map(task => (
        <TaskItem key={task.id} task={task} />
      ))}
    </ul>
  )
}

export default TaskList
