import { BUY_BOOK, RENT_BOOK } from "./BookTypes";

export const purchase_book = () => {
  return {
    type: BUY_BOOK,
  };
};

export const rent_book = () => {
  return {
    type: RENT_BOOK,
  };
};
