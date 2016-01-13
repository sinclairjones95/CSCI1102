interface QueueADT<T> {
   public void enqueue(T item);
   public T dequeue();
   public boolean isEmpty();
   public void clear();
}
