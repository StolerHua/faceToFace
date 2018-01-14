package hello;
import java.util.Arrays;

public class MyStringBuffer {
    private static int capacity;
    private int count;
    private char[] value;

    static {
        capacity = 16;
    }
    private MyStringBuffer(){
        value = new char[capacity];
        count = 0;
    }
    private void appendNull(){
        expand(value,count+4);
        "null".getChars(0,4,value,count);
        count +=4;
    }
    private void expand(char []oldValue,int length){
        value = Arrays.copyOf(oldValue,Math.min(capacity,length));
    }

    private void append(String str){
        int len = str.length();
        if (len == 0)
            appendNull();
        expand(value,len+count);
        str.getChars(0,len,value,count);
        count +=len;
    }

    @Override
    public String toString() {
        return new String(value);
    }

    public static void main(String[] args) {
        MyStringBuffer mysb = new MyStringBuffer();
        mysb.append("");
        System.out.println(mysb.toString());
        mysb.append("hello world.");
        System.out.println(mysb.toString());
    }
}
