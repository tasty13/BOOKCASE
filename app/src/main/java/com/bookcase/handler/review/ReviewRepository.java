package com.bookcase.handler.review;

import com.bookcase.vo.Review;

public class ReviewRepository {
  Review[] reviews = new Review[3];
  int length = 0;

  public void add(Review review) {
    if (this.length == this.reviews.length){
      // 1. 새 사이즈 배열 만듦
      // 2. 원래 배열 요소들 새 배열에 넣어줌
      // 3. reviews 변수에 새 배열 주소 저장해줌
      int oldSize = this.reviews.length;
      int newSize = oldSize + oldSize / 2;
      Review[] arr = new Review[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.reviews[i];
      }
      this.reviews = arr;
    }
    this.reviews[this.length++] = review;

  }

  public Review remove(int index) {
    if (index < 0 || index >= this.length) {
      return null;
    }

    Review deleted = this.reviews[index];

    for (int i = index; i<this.length-1; i++){
      this.reviews[i] = this.reviews[i + 1];
    }
    this.reviews[--this.length] = null;

    return deleted;
  }

  public Review[] toArray(){
    Review[] arr = new Review[this.length];
    for (int i = 0; i < this.length; i++) {
      arr[i] = this.reviews[i];
    }
    return arr;
  }

  public Review get(int index){
    if (index < 0 || index >= this.length) {
      return null;
    }
    return this.reviews[index];
  }

  public Review set(int index, Review review){
    if (index < 0 || index >= this.length) {
      return null;
    }
    Review old = this.get(index);
    this.reviews[index] = review;

    return old;
  }
}
