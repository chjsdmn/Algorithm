package com.algdat.uke41;

public class CircularBuffer {
    char[] buffer;
    int size;
    int head;
    int tail;
    int count;

    CircularBuffer(int size){  //构造器
        this.buffer = new char[size];
        this.size = size;
        this.head = 0;
        this.tail = 0;
        this.count = 0;

    }
    void addBack(char x){
        if((count + 1) > size){   //如果buffer里字符的数量已经等于size了，再addBack的话（count+1）就报错
            throw new IndexOutOfBoundsException();
        }
        buffer[tail] = x;
        tail = (tail  + 1) % size;  //加入一个元素后，tail移动到的位置，因为是一个循环，所以这样写
        count++;
    }
    char popFront(){
        if(count <= 0){    //如果buffer已经空了的话，再pop的话，就报错
            throw new IndexOutOfBoundsException();
        }
        char y = buffer[head];
        head = (head + 1) % size;  //删除 一个元素后，head移动到的位置，因为是一个循环，所以这样写
        count--;
        return y;
    }
    int count(){
        return count;
    }
    public static void main(String[] args) {
        CircularBuffer circularBuffer = new CircularBuffer(6);
        String a = "abcdefghijklmnopqrstuvwxyzøåæ";
        char[] values = a.toCharArray();  //将字符串转换成字符数组
        //int length = circularBuffer.count();  不能在这里叫这个function，因为这时候的长度为0
        for(int i = 0; i < values.length;){  //不在这里写每次变化的条件，放在最下面写
            for(int j = 0; j < 6; j ++){
                if(values.length > (j + i)) {
                    circularBuffer.addBack(values[j + i]); //表示每次添加6个元素
                }
            }
            while (circularBuffer.count() > 0){   //必须在这里叫这个function，才是此时buffer的长度
                System.out.print(circularBuffer.popFront());  //打印出依次删掉的char
            }
            i+=6;  //下次添加从6开始的6个元素
            System.out.println();
        }

    }
}
