public interface Vector<T> {
    int size();
    boolean isEmpty();
    T elemAtRank(int rank);
    T replaceAtRank(int rank, T element);
    void insertAtRank(int rank, T element);
    T removeAtRank(int rank);
}
