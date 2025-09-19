import { BUY_BOOK, RENT_BOOK } from "./BookTypes";

const initialState = {
  totalBooks: 20,
  borrowedBooks: 0,
  rentedBooks: 0,
};

const BookReducer = (state = initialState, action) => {
  switch (action.type) {
    case BUY_BOOK:
      return {
        ...state,
        totalBooks: state.totalBooks - 1,
        borrowedBooks: state.borrowedBooks + 1,
      };
    case RENT_BOOK:
      return {
        ...state,
        totalBooks: state.totalBooks - 1,
        rentedBooks: state.rentedBooks + 1,
      };
    default:
      return state;
  }
};

export default BookReducer;
