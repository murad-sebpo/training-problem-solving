package io.murad.Data_Structures_and_Java_Collections.PART_2;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueImpl {

    public static void main(String[] args) {
        Queue<String> tickets = new PriorityQueue<>();

        tickets.add("To Dhaka");
        tickets.add("To Chitagong");
        tickets.add("To Rajshahi");
        tickets.add("To Khulna");
        tickets.add("To Shylet");

        tickets.forEach(ticket->{
            System.out.println(ticket);
        });

        tickets.remove();
        // Tickets After Dequeue/remove
        tickets.forEach(ticket->{
            System.out.println(ticket);
        });

        System.out.println("Front Element: " + tickets.peek());
    }
}
