package mcqspractice;

class Data <T extends Number> {
    T t;
    public static void main(String[] args) {
        Data q = new Data<Integer>();
        q.t = Float.valueOf(1);
        System.out.println(q.t);
    }
}