package org.example;

import org.example.model.QueueOfStack;
import org.example.model.StaticQueueOfStack;
import org.example.util.UtilQueueOfStack;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
        QueueOfStack queue = new StaticQueueOfStack(3);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        UtilQueueOfStack.printQueueOfStack(queue);

    }
}