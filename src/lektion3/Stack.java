package lektion3;

public interface Stack<E> {
    E push(E obj);
    E peek();
    E pop();
    int size();
    E peek(int n);
    E flush();
    boolean empty();
}
