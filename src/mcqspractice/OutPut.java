package mcqspractice;

import java.util.concurrent.ConcurrentHashMap;

class Output {
    public static void  main(String args[]) {
        ConcurrentHashMap<String, Integer> data = new ConcurrentHashMap<>();

        data.put("data4",400);
        data.put("Data4",400);
        data.put("data4",400);
        data.put("Data1",100);
        data.put("Data2",200);
        data.put("Data3",300);
        System.out.println(data);
        System.out.println(data.entrySet());
        System.out.println(data.keySet());




    }
}

