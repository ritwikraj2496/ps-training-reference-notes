import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { purchase_book, rent_book } from './BookAction';

function BookContainer() {
  const { totalBooks, borrowedBooks, rentedBooks } = useSelector(state => state);
  const dispatch = useDispatch();

  return (
    <div>
      <h1>Book Container</h1>
      <p>Total Books Available: {totalBooks}</p>
      <p>Books Borrowed: {borrowedBooks}</p>
      <p>Books Rented: {rentedBooks}</p>
      <button onClick={() => dispatch(purchase_book())}>Buy Book</button>
      <button onClick={() => dispatch(rent_book())}>Rent Book</button>
    </div>
  );
}

export default BookContainer;
