<!-- Action in Redux:- -->
Actions are Javascript objects that contain information
Actions are the only source of information for the store. It only tells us what has happened but not how the application state changes.
Actions have a type property and it should be defined in string constraint.
it is compulsory to include the type property in the action object.

Syntax:
const action = {
  type: 'ACTION_TYPE',
  payload: {
    // additional data
  }
};

<!-- Reducer  -->
Reducer decides how the state of the application changes depending upon the action sent to the store.
Reducers are pure functions that accepts the previous state and an action as the parameter and return the next state of the application.

Syntax:
const reducer = (initialState, action)

reducer is the new state of the application
initialState is the previous state of the application
action is the action object that is sent to the store

<!-- Store -->
Entire application contains a single store.
it is responsible for holding the state of the application.
getState() method is used to get the current state of the application.
dispatch(action) method is used to send an action to the store/method allow state to be updated.

<!-- useSelector hook -->
useSelector hook provides access to the state of the application.
- to get hold of any state that is maintained in the redux store.

Syntax:-
const value = useSelector(selector: Function, equalityFn?: Function)

Selector is a function that takes the state as an argument and returns the value we want to access.

<!-- useDispatch hook -->
This hook returns a reference to the dispatch function from the Redux store.
- it is used to dispatch actions to the store.

Syntax:-
const dispatch = useDispatch()

