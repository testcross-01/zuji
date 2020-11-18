package top.testcross.zuji;

import java.util.UUID;

public class JustForTest {
    public static void main(String[] args) {
        String uuid= UUID.randomUUID().toString().replace("-","");

        System.out.println(uuid+" "+uuid.length());
    }
}
