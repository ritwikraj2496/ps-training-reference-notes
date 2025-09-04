import React, { useReducer } from "react";

const initialSate = 0;
const reducer = (state, action) => {
  switch (action) {
    case "Increment":
      return state + 1;
    case "Decrement":
      return state - 1;
    default:
      return state;
  }
};

function CounterUseReducer() {

    const [count, dispatch] = useReducer(reducer, initialSate);

    return (
    <div>
        <div>Count: {count}</div>
      <button onClick={()=>dispatch("Increment")}>Increment</button>
      <button onClick={()=>dispatch("Decrement")}>Decrement</button>
    </div>
  );

  // useReducer is a hook that is used to manage state in a more complex way than useState.
  // alternative for useState
  // preferable for complex state management logic

  // const [state, dispatch] = useReducer((reducer, initialState));
  // reducer(currentState, action)

  // newState = reducer(currentState, action)
}

export default CounterUseReducer;
