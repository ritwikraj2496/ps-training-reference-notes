import { createSlice, nanoid } from "@reduxjs/toolkit";

const taskSlice = createSlice({
  name: "task",
  initialState: {
    items: [],
    filters: "all",
  },
  reducers: {
    addTask: {
      reducer: (state, action) => {
        state.items.push(action.payload);
      },
      prepare: (text) => {
        return {
          payload: {
            id: nanoid(),
            text,
            completed: false,
          },
        };
      },
    },
    deleteTask: (state, action) => {
      state.items = state.items.filter((item) => item.id !== action.payload);
    },
    toggleTask: (state, action) => {
      const task = state.items.find((item) => item.id === action.payload);
      if (task) {
        task.completed = !task.completed;
      }
    },
    setFilter: (state, action) => {
      state.filters = action.payload;
    },
  },
});

export const { addTask, deleteTask, toggleTask, setFilter } = taskSlice.actions;
export default taskSlice.reducer;