package pract3;

import java.util.*;

public class MySet implements Set {

    int size;
    Set<Object> synSet;
    public MySet(){
        this.synSet = new HashSet<>();
    }
    public MySet(int size){
        this.size=size;
        this.synSet = new HashSet<>(size);
    }
    @Override
    public synchronized int size() {
        return synSet.size();
    }

    @Override
    public  synchronized boolean isEmpty() {
        return synSet.isEmpty();
    }

    @Override
    public synchronized boolean contains(Object o) {
        return synSet.contains(o);
    }

    @Override
    public synchronized Iterator iterator() {
        return synSet.iterator();
    }

    @Override
    public synchronized Object[] toArray() {
        return new Object[0];
    }

    @Override
    public synchronized boolean add(Object o) {

        synchronized (o){
            System.out.println(Thread.currentThread()+" get started");
            return synSet.add(o);
        }

    }


    public synchronized boolean add1(Object o) {


        System.out.println(Thread.currentThread()+" get started");
        return synSet.add(o);


    }

    @Override
    public synchronized boolean remove(Object o) {
        return synSet.remove(o);
    }

    @Override
    public synchronized boolean addAll(Collection c) {
        return synSet.addAll(c);
    }

    @Override
    public synchronized void clear() {

    }

    @Override
    public synchronized boolean removeAll(Collection c) {
        return synSet.removeAll(c);
    }

    @Override
    public synchronized boolean retainAll(Collection c) {
        return synSet.retainAll(c);
    }

    @Override
    public synchronized boolean containsAll(Collection c) {
        return synSet.containsAll(c);
    }

    @Override
    public synchronized Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
