class CollectionException extends Exception {
    public CollectionException(String msg) {
         super(msg);
    }
}

interface Collection {
    static final String ERR_MSG_EMPTY = "Collection is empty.";
    static final String ERR_MSG_FULL = "Collection is full.";

    boolean isEmpty();
    boolean isFull();
    int size();
    String toString();
}

interface Stack<T> extends Collection {
    T top() throws CollectionException;
    void push(T x) throws CollectionException;
    T pop() throws CollectionException;
}

interface Sequence<T> extends Collection {
    static final String ERR_MSG_INDEX = "Wrong index in sequence.";
    T get(int i) throws CollectionException;
    void add(T x) throws CollectionException;
}

class ArrayDeque<T> implements Stack<T>, Sequence<T> {
    private static final int DEFAULT_CAPACITY = 64;

    private T[] a;
    private int front, back, size;

    public ArrayDeque() throws CollectionException{
        a = (T[])(new Object[DEFAULT_CAPACITY]);
        front = 0;
        back = 0;
        size = 0;
    }

    private int next(int i){
        return (i+1)%DEFAULT_CAPACITY;
    }

    private int prev(int i){
        return (DEFAULT_CAPACITY+i-1)%DEFAULT_CAPACITY;
    }

    //Collection

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean isFull() {
        return size==DEFAULT_CAPACITY;
    }

    @Override
    public int size() {
        return size;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        if (size > 0){
            sb.append(a[front].toString());
        }
        for (int i = 0; i < size - 1; i++){
            sb.append(", " + a[next(front+i)].toString());
        }
        sb.append("]");
        return sb.toString();
    }

    //Stack

    @Override
    public T top() throws CollectionException {
        if (isEmpty()){
            throw new CollectionException(ERR_MSG_EMPTY);
        }
        return a[prev(back)];
    }

    @Override
    public void push(T x) throws CollectionException {
        if (isFull()){
            throw new CollectionException(ERR_MSG_FULL);
        }
        a[back] = x;
        back = next(back);
        size++;
    }

    @Override
    public T pop() throws CollectionException {
        if (isEmpty()){
            throw new CollectionException(ERR_MSG_EMPTY);
        }
        back = prev(back);
        T o = a[back];
        a[back] = null;
        size--;
        return o;
    }

    //Sequence

    public int index(int i){
        return (front+i)%DEFAULT_CAPACITY;
    }

    @Override
    public T get(int i) throws CollectionException {
        if (isEmpty()){
            throw new CollectionException(ERR_MSG_EMPTY);
        }
        if (i < 0 || i >= size){
            throw new CollectionException(ERR_MSG_INDEX);
        }
        return a[index(i)];
    }

    @Override
    public void add(T x) throws CollectionException {
        push(x);
    }

}

public class Naloga1 {

    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    // STACK OPERATIONS
    static Stack<String> main_stack = new ArrayDeque<>();
    static Stack<String> help_stack = new ArrayDeque<>();
    // static Stack<String> stack1 = new ArrayDeque<>();
    // static Stack<String> stack2 = new ArrayDeque<>();
    // static Stack<String> stack3 = new ArrayDeque<>();
    // static Stack<String> stack4 = new ArrayDeque<>();
    // static Stack<String> stack5 = new ArrayDeque<>();
    // static Stack<String> stack6 = new ArrayDeque<>();
    // static Stack<String> stack7 = new ArrayDeque<>();

    // static Sequence<Stack<String>> sekvenca;
    static Sequence<Stack<String>> sekvenca = new ArrayDeque();

    public static void naprajSekvenca(){
        for (int i = 0; i < 42; i++){
            Stack<String> stack = new ArrayDeque<>();
            sekvenca.add(stack);
        }
    }
    
    // OPERATIONS ON MAIN STACK
    public static void echo() throws CollectionException {
        if (sekvenca.get(0).isEmpty()){
            System.out.println(" ");
        } else {
            System.out.println(main_stack.top());
        }
    }

    public static void pop() throws CollectionException {
        main_stack.pop();
    }

    public static void dup() throws CollectionException {
        String x = main_stack.top();
        main_stack.push(x);
    }

    public static void dup2() throws CollectionException {
        String y = main_stack.pop();
        String x = main_stack.pop();
        main_stack.push(x);
        main_stack.push(y);
        main_stack.push(x);
        main_stack.push(y);
    }

    public static void swap() throws CollectionException {
        String y = main_stack.pop();
        String x = main_stack.pop();
        main_stack.push(y);
        main_stack.push(x);
    }

    // OPERATIONS ON MAIN STACK (x -> y)
    public static void char_stack() throws CollectionException {
        int x = Integer.parseInt(main_stack.pop());
        char a = (char)x;
        main_stack.push(Character.toString(a));
    }

    public static void even() throws CollectionException {
        int x = Integer.parseInt(main_stack.pop());
        if (x % 2 == 0){
            main_stack.push("1");
        } else {
            main_stack.push("0");
        }
    }

    public static void odd() throws CollectionException {
        int x = Integer.parseInt(main_stack.pop());
        if (x % 2 != 0){
            main_stack.push("1");
        } else {
            main_stack.push("0");
        }
    }

    public static void faktoriel() throws CollectionException {
        int x = Integer.parseInt(main_stack.pop());
        int y = 1;
        for (int i = 1; i <= x; i++){
            y *= i;
        }
        main_stack.push(String.valueOf(y));
    }

    public static void len() throws CollectionException {
        String x = main_stack.pop();
        main_stack.push(String.valueOf(x.length()));
    }

    // ARITHMETIC OPERATIONS
    public static void not_equal() throws CollectionException {
        int y = Integer.parseInt(main_stack.pop());
        int x = Integer.parseInt(main_stack.pop());
        if (x != y){
            main_stack.push("1");
        } else {
            main_stack.push("0");
        }
    }

    public static void smaller() throws CollectionException {
        int y = Integer.parseInt(main_stack.pop());
        int x = Integer.parseInt(main_stack.pop());
        if (x < y){
            main_stack.push("1");
        } else {
            main_stack.push("0");
        }
    }
    
    public static void smaller_equal() throws CollectionException {
        int y = Integer.parseInt(main_stack.pop());
        int x = Integer.parseInt(main_stack.pop());
        if (x <= y){
            main_stack.push("1");
        } else {
            main_stack.push("0");
        }
    }

    public static void equal() throws CollectionException {
        int y = Integer.parseInt(main_stack.pop());
        int x = Integer.parseInt(main_stack.pop());
        if (x == y){
            main_stack.push("1");
        } else {
            main_stack.push("0");
        }
    }

    public static void bigger() throws CollectionException {
        int y = Integer.parseInt(main_stack.pop());
        int x = Integer.parseInt(main_stack.pop());
        if (x > y){
            main_stack.push("1");
        } else {
            main_stack.push("0");
        }
    }

    public static void bigger_equal() throws CollectionException {
        int y = Integer.parseInt(main_stack.pop());
        int x = Integer.parseInt(main_stack.pop());
        if (x >= y){
            main_stack.push("1");
        } else {
            main_stack.push("0");
        }
    }

    public static void addition() throws CollectionException {
        int y = Integer.parseInt(main_stack.pop());
        int x = Integer.parseInt(main_stack.pop());
        main_stack.push(String.valueOf(x + y));
    }

    public static void subtraction() throws CollectionException {
        int y = Integer.parseInt(main_stack.pop());
        int x = Integer.parseInt(main_stack.pop());
        main_stack.push(String.valueOf(x - y));
    }

    public static void multiplication() throws CollectionException {
        int y = Integer.parseInt(main_stack.pop());
        int x = Integer.parseInt(main_stack.pop());
        main_stack.push(String.valueOf(x * y));
    }

    public static void division() throws CollectionException {
        int y = Integer.parseInt(main_stack.pop());
        int x = Integer.parseInt(main_stack.pop());
        main_stack.push(String.valueOf(x / y));
    }

    public static void module() throws CollectionException {
        int y = Integer.parseInt(main_stack.pop());
        int x = Integer.parseInt(main_stack.pop());
        main_stack.push(String.valueOf(x % y));
    }

    public static void unite() throws CollectionException {
        String y = main_stack.pop();
        String x = main_stack.pop();
        main_stack.push((x + y));
    }

    public static void random() throws CollectionException {
        int y = Integer.parseInt(main_stack.pop());
        int x = Integer.parseInt(main_stack.pop());
        if (x >= y){
            main_stack.push(String.valueOf(y + (int)(Math.random() * ((x - y) + 1))));
        } else {
            main_stack.push(String.valueOf(x + (int)(Math.random() * ((y - x) + 1))));
        }
    }

    // OPERATIONS THEN/ELSE
    static boolean b;
    public static void then() throws CollectionException {
        int x = Integer.parseInt(main_stack.pop());
        if (x != 0){
            b = true;
        } else {
            b = false;
        }
    }

    public static void else_stack() throws CollectionException {
        if (b == true){
            b = false;
        } else {
            b = true;
        }
    }

    // public static void question() throws CollectionException {
    //     if (b == true){
    //         b = false;
    //     } else {
    //         b = true;
    //     }
    // }
    
    // OPERATIONS ON ALL STACKS
    public static void print() throws CollectionException {
        String niz = "";
        while(!main_stack.isEmpty()){
            String x = main_stack.pop();
            help_stack.push(x);
            niz += x + " ";
        }
        while(!help_stack.isEmpty()){
            String x = help_stack.pop();
            main_stack.push(x);
        }
        System.out.println(niz);
    }

    public static void clear() throws CollectionException {
        while(!main_stack.isEmpty()){
            main_stack.pop();
        }
    }

    public static void run() throws CollectionException {
        
    }

    public static void loop() throws CollectionException {
        
    }

    public static void fun() throws CollectionException {
        
    }

    public static void move() throws CollectionException {
        
    }

    public static void reverse() throws CollectionException {
        
    }
    
    public static void main(String[] args) throws CollectionException {
        // OVA DA GO SREDAM LOSO E, DRUGOTO GORE E OK!!!

        // ZA POVEKJE STACKOVI DA PROBAM DA GI STAVAM VO EDEN SEQUENCE
        // NESO VAKA DA VIDAM Sequence<Stack<String>>
        for (int i = 0; i < args.length; i++){
            if (isInt(args[i]) && args[i+1].equals("print")){
                print();
            }
            else if (isInt(args[i])){
                main_stack.push(args[i]);
            }
            else if (args[i].equals("echo")){
                echo();
            }
            else if (args[i].equals("pop")){
                pop();
            }
            else if (args[i].equals("dup")){
                dup();
            }
            else if (args[i].equals("dup2")){
                dup2();
            }
            else if (args[i].equals("swap")){
                swap();
            }
            else if (args[i].equals("char")){
                char_stack();
            }
            else if (args[i].equals("even")){
                even();
            }
            else if (args[i].equals("odd")){
                odd();
            }
            else if (args[i].equals("!")){
                faktoriel();
            }
            else if (args[i].equals("len")){
                len();
            }
            else if (args[i].equals("<>")){
                not_equal();
            }
            else if (args[i].equals("<")){
                smaller();
            }
            else if (args[i].equals("<=")){
                smaller_equal();
            }
            else if (args[i].equals("==")){
                equal();
            }
            else if (args[i].equals(">")){
                bigger();
            }
            else if (args[i].equals(">=")){
                bigger_equal();
            }
            else if (args[i].equals("+")){
                addition();
            }
            else if (args[i].equals("-")){
                subtraction();
            }
            else if (args[i].equals("asd")){ // IMA NEKOJ PROBLEM
                multiplication();
            }
            else if (args[i].equals("/")){
                division();
            }
            else if (args[i].equals("%")){
                module();
            }
            else if (args[i].equals(".")){
                unite();
            }
            else if (args[i].equals("rnd")){
                random();
            }
        }
    }
}
