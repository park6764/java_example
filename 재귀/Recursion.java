import java.util.*;
import java.util.function.*;

public class Recursion {
    public static void main(String[] args) {
        // var list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
        // System.out.println(reverse(list));

        // LinkedList<Integer> list4 = new LinkedList(3, new LinkedList(4, new LinkedList(5, new LinkedList(6, new LinkedList(null, null)))));
        
        // var list5 = reverse_(list4);
        // // list5.print();

        // var list6 = filter(i -> i % 2 == 0, list4);
        // list6.print();

        ArrayList<Integer> l = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 7, 9));
        var l_ = new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 6, 7, 8)); // 3, 5, 7
        System.out.println(intersection(l, l_));
    }

    // filter : ((T -> Boolean), LinkedList<T>) -> LinkedList<T>
    public static <T> LinkedList<T> filter(Function<T, Boolean> p, LinkedList<T> l) {
        if(l.isEmpty()) return l;
        else {
            var el = l.element;
            var n = l.next;
            if(!p.apply(el)) return filter(p, n);
            else return new LinkedList(el, filter(p, n));
        }
    }

    public static <T> LinkedList<T> reverse_(LinkedList<T> l) {
        return reverse__(l, new LinkedList(null, null));
    }

    //l1을 뒤집고, 그 뒤에 l2를 이어붙인다. 
    private static <T> LinkedList<T> reverse__(LinkedList<T> l1, LinkedList<T> l2) {
        if(l1.isEmpty()) return l2;
        else {
            var el = l1.element;
            var n = l1.next;
            var l_ = new LinkedList(el, l2);
            var result = reverse__(n, l_);
            return result;
        }
    }

    // reverse (x:xs) = reverse xs ++ [x]
    // reverse__ xs ys = reverse xs ++ ys
    public static <T> LinkedList<T> reverse(LinkedList<T> l) {
        if(l.isEmpty()) return l; // l = [1, 2, 3, 4, 5] -> l = [5, 4, 3, 2, 1]
        else {
            var el = l.element; // 5     1
            var n = l.next; // []       [2, 3, 4, 5]
            var l_ = reverse(n);
            var result = addToEnd(el, l_); // [5, 4, 3, 2, 1]
            return result;
        }
    }

    public static <T> LinkedList<T> addToEnd(T a, LinkedList<T> l) {
        if(l.isEmpty()) return new LinkedList(a, l); // [*, b]
        else { // l == [*, b]
            var el = l.element; // *
            var n = l.next; // []
            var l_ = addToEnd(a, n); // [a]
            var result = new LinkedList(el, l_); // [*, a]
            return result;
        }
    }

    private static ArrayList<Integer> insert(int n, ArrayList<Integer> list) {
        if(list.size() == 0) {
            list.add(n);
            return list;
        } else {
            var a = list.get(0);
            if(a >= n) {
                list.add(0, n);
                return list;
            } else { // a < n -> 1 < 4
                list.remove(a);
                var list_ = insert(n, list);
                list_.add(0, a);
                return list_;
            }
        }
    }

    public static ArrayList<Integer> isort(ArrayList<Integer> list) {
        if(list.size() == 0) return list; // []
        else { // list.size() >= 1
            var a = list.get(0); // (x:xs)
            list.remove(a); // 이전 list 정렬 x n-1
            var list_ = isort(list); // 정렬 o n-1
            return insert(a, list_);
        }
    }

    // 정렬되어 있는 2개 리스트를 받아서 정렬된 1개의 리스트 반환
    private static ArrayList<Integer> merge(ArrayList<Integer> list, ArrayList<Integer> list_) {
        if(list.isEmpty()) return list_;
        if(list_.isEmpty()) return list;
        else {
            var a = list.get(0);
            var b = list_.get(0);
            // list = { 3 4 5 6 7 } a
            // list_= { 2 4 6 8 10 } b
            // []
            if(a > b) {
                list_.remove(b);
                var result = merge(list, list_);
                result.add(0, b);
                return result;
            } else {
                list.remove(a);
                var result = merge(list, list_);
                result.add(0, a);
                return result;
            }
        }
    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> list) {
        if(list.isEmpty()) return list;
        else if(list.size() == 1) return list;
        else {
            int l = list.size() / 2; 
            ArrayList<Integer> ls = list.subList(0, l);
            ArrayList<Integer> rs = list.subList(l, list.size());

            return merge(mergeSort(ls), mergeSort(rs));
        }
    }

     // append : (ArrayList<T>, ArrayList<T>) -> ArrayList<T>
     public static <T> ArrayList<T> append(ArrayList<T> list, ArrayList<T> list_) {
        if(list.isEmpty()) return list_;
        if(list_.isEmpty()) return list;
        else {
            var a = list.get(0);
            list.remove(a);
            var result = append(list, list_);
            result.add(0, a);
            return result;
        }
    }

    public static ArrayList<Integer> intersection(ArrayList<Integer> a, ArrayList<Integer> b) {
        var result = new ArrayList();
        for(var x : a) {
            for (var y : b) {
                if (x == y) {
                    result.add(x);
                } else {
                    continue;
                }
            }
        }
        return result;
    }

    public static <T extends Comparable<T>> ArrayList<T> intersection_(ArrayList<T> list, ArrayList<T> list_) {
        if(list.isEmpty()) return new ArrayList();
        if(list_.isEmpty()) return new ArrayList();
        else {
            var a = list.get(0);
            if(elem(a, list_)) {
                ArrayList<T> l = list.clone();
                l.remove(a);
                var result = intersection_(l, list_);
                result.add(a);
                return result;
            } else {
                ArrayList<T> l = list.clone();
                l.remove(a);
                return intersection_(l, list_);
            }
        }
    }
    // elem :: forall a. Eq a => a -> [a] -> Bool
    // 주어진 원소가 리스트 안에 있는지 여부를 반환
    public static <T extends Comparable<T>> Boolean elem(T a, ArrayList<T> list) {
        if(list.isEmpty()) return false;
        else {
            var n = list.get(0);
            if(a.compareTo(n) == 0) return true;
            // a - n
            else {
                ArrayList<T> l = list.clone(); // 값 복제.
                l.remove(n);
                return elem(a, l);
            }
        }
    }
}



class LinkedList<T> {
    public final Optional<LinkedItem<T>> item;

    public LinkedList(Optional<LinkedList<T>.LinkedItem<T>> item) {
        this.item = item;
    }

    public static <T> LinkedList<T> empty() {
        return new LinkedList(Optional.empty());
    }

    public static <T> LinkedList<T> cons(T item, LinkedList<T> rest) {
        return new LinkedList(Optional.of(new LinkedItem(item, rest)));
    }

    public Boolean isEmpty() {
        return item.isEmpty();
    }

    private static class LinkedItem<T> {
        public final T item;
        public final LinkedList<T> rest;

        public LinkedItem(T item, LinkedList<T> rest) {
            this.item = item;
            this.rest = rest;
        }
    }
}
