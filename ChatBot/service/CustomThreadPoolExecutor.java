package chatbot.service;

import chatboot.model.Message;
import chatboot.model.Query;
import chatbot.model.Response;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
/*Chatbot */
import javax.management.Query;
import SingleWriteMultipleReadLock.ConcurrentHashMap;

public class CustomThreadPoolExecutor {
    private Map<String, Queue<Message>> userIdToQueries;
    private Map<String, Queue<Message>> userIdToResponses;
    private final Thread[] workerThreads;
    private Map<Integer, Integer> userIdToIdx;
    private int index;

    public CustomThreadPoolExecutor(Integer poolSize) {
        this.userIdToIdx = new ConcurrentHashMap();
        this.workerThreads = new Thread[poolSize];
        this.index = 0;
        startThreads();
    }

    public boolean addNewUser(String user_id, Instant requestedTs) {
        Queue<Message> qries = new PriorityQueue<>(Comparator.comparingLong(Message::getTs));
        qries.add(new Query(user_id, requestedTs, 1));
        userIdToRequest.put(user_id, qries);
        System.out.println("New User !!! - " + user_id);
        return true;
    }

    public synchronized boolean addQueryToQueue(String userId, Instant ts) {
        if (!userIdToQueries.containsKey(userId)) {
            return addNewUser(userId, ts);
        } else {
            /*
             * if (getTotalElapsedRequest(userName) < rateLimitPerMinute) {
             * LinkedList<Request> tmp = userIdToRequest.get(userName);
             * tmp.add(new Request(ts, 1));
             * userIdToRequest.put(userName, tmp);
             * return true;
             * }
             * else {
             * boolean actionTaken = false;
             * for (int i = 0; i < userIdToRequest.get(userName).size(); i++) {
             * Duration duration =
             * Duration.between(userIdToRequest.get(userName).get(i).getTs(), ts);
             * if (duration.getSeconds() >= 60) {
             * userIdToRequest.get(userName).remove(i);
             * actionTaken = true;
             * }
             * else {
             * break;
             * }
             * }
             * // case 1 - if some entries are older than 1 minute evict those and insert
             * new entry
             * // and return true
             * if (actionTaken) {
             * LinkedList<Request> tmp = userIdToRequest.get(userName);
             * tmp.add(new Request(ts, 1));
             * userIdToRequest.put(userName, tmp);
             * return true;
             * }
             * // case 2 - if all entries are within 1 minute,
             * // then rate has been breached and return false
             * return false;
             * }
             */
        }
    }

    public void startThreads() {
        for (int i = 0; i < workerThreads.length; i++) {
            int finalI = i;
            // find out userID which has
            // 1.Most number of pending queries.
            // 2.Earliest qries.
            workerThreads[i] = new Thread(() -> consume(finalI));
            workerThreads[i].start();
        }
    }

    private void consume(String userId, Integer threadId) {
        while (true) {
            Runnable task;
            System.out.println("Thread: " + threadId + " is trying to acquire lock");
            PriorityQueue<Message> qrysByUser = userIdToQueries.get(userId);
            synchronized (qrysByUser) {
                System.out.println("Thread: " + threadId + " has acquired lock");
                while (index == 0) {
                    System.out.println("Thread: " + threadId + " is waiting");
                    try {
                        tasksQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                index--;
                System.out.println("Thread: " + threadId + " is consuming task at index: " + index);
                task = tasksQueue.get(index);
            }
            task.run();
        }
    }
}