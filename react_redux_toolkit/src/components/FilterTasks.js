import React from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { setFilter } from '../../src/features/task/taskSlice';

function FilterTasks() {

    //const filter = useSelector(state => state.task.filters);
    const dispatch = useDispatch();

  return ( 
    <div>
      <button onClick={()=>dispatch(setFilter('all'))}>All</button>
      <button onClick={()=>dispatch(setFilter('completed'))}>Completed</button>
    </div>
  )
}

export default FilterTasks
