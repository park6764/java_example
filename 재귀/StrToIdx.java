import java.util.*;

public class StrToIdx {
    public static void main(String[] args) {
        var list = new ArrayList<Integer>(Arrays.asList());
        var list_ = new ArrayList<Integer>(Arrays.asList());
        System.out.println(merge(list, list_));
        // System.out.println(isort(list));
        
        // String str = "abracadabra";
        // String p = "abr";
        
        // var list = idxPattern_(str, p);
        // Collections.sort(list);
        // System.out.println(list);

        // System.out.println(idxPatternFor(str, p));

    }
    // powerSet : ArrayList<T> -> ArrayList<ArrayList<T>>
    public static <T> ArrayList<ArrayList<T>> powerSet(ArrayList<T> list) {
        if(list.size() == 0) {
            ArrayList<ArrayList<T>> p = new ArrayList();
            p.add(list);
            return p;
        } else {
            var n = list.get(0);
            list.remove(0);
            var p__ = powerSet(list);
            var p_ = powerSet(list); // 이전 멱집합 list - n
            p__.forEach(x -> x.add(n));
            p_.addAll(p__);
            return p_;
        }
    }

// idx : (String, String) -> ArrayList<Optional<Integer>>
    public static Optional<Integer> idx(String s, String p) { // "abracadabra" "abr"
        
        if(s.length() == 0) return Optional.empty();
        else if(s.length() < p.length()) return Optional.empty();
        else if(s.length() == p.length()) {
            if(s.equals(p)) return Optional.of(s.indexOf(p));
            else return Optional.empty();
        } else { // s.length > p.length
            if(s.indexOf(p) == -1) return Optional.empty(); // 종료조건.
            else { // 적어도 하나는 있음.
                Optional.of(s.indexOf(p)); // 출력하고싶음
                var i = s.replaceFirst(p, "*"); // 출력 후 변경
                return idx(i, p);
            }
        }
    }

    private static ArrayList<Integer> idxPattern(String s, String p, int i) { // "abracadabra" "abr"
    
        if(s.length() == 0) return new ArrayList(); // == empty
        if(p.length() == 0) return new ArrayList();
        else if(s.length() < p.length()) return new ArrayList();
        else { //>=
            if(s.indexOf(p) != -1) {
                var s__ = s.replaceFirst(p, "*");
                var diff = p.length() - 1;
                var list = idxPattern(s__, p, i+diff);

                list.add(s.indexOf(p)+i);
                return list;
            }
            else return new ArrayList();
        }
    }

    public static ArrayList<Integer> idxPattern_(String s, String p) {
        return idxPattern(s, p, 0);
    }

    public static ArrayList<Integer> idxPatternFor(String s, String p) { // "abracadabra" "abr"
    
        if(s.length() < p.length()) return new ArrayList();
        else {
            var list = new ArrayList();
            for (int index = 0; index < s.length(); index++) {
                if(s.indexOf(p, index) != -1 && !list.contains(s.indexOf(p, index))) list.add(s.indexOf(p, index));
                else continue;
            }
            return list;
        }
    }

// insert : (T, ArrayList<T>) -> ArrayList<T>
// T = integer
// n = 4
// list = {1,2 3,5}
// ex. insert(int n, ArrayList<T> list) -> list = {1,2,3,4,5}

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

    // public static ArrayList<Integer> merge(ArrayList<Integer> list, ArrayList<Integer> list_) {
    //     if(list.size() == 0) return list;
    //     if(list_.size() == 0) return list_;
    //     if(list.size() != 0 && list_.size() == 0) {
    //         var a = list.get(0);
    //         list.remove(a); // list -> n-1
    //         var li = merge(list, list_); // li -> n-1
    //         var b = li.get(0);
    //         if(li.isEmpty()) {
    //             li.add(a);
    //             return li;
    //         } else {
    //             if(a > b) {

    //             }
    //         }
    //     }
        
    // }
    /*
     {6, 4, 2, 3, 7, 1, 5}
     {4, 2, 3, 7, 1, 5}
     {2, 3, 7, 1, 5}
     {3, 7, 1, 5}
     {7, 1, 5}
     {1, 5}
     {5}

     {5, 6}
     {4, 5, 6}
     {2, 4, 5, 6}
     {2, 4, 5, 6, 3}
     {2, 4, 5, 6, 3, 7}
     {1, 2, 4, 5, 6, 3, 7}
     {1, 2, 4, 5, 6, 3, 7}
     */

     public static ArrayList<Integer> merge(ArrayList<Integer> list, ArrayList<Integer> list_) {
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

    // public static ArrayList<Integer> merge(ArrayList<Integer> list, ArrayList<Integer> list_) {
    //     if(list.size() == 0) return list;
    //     if(list_.size() == 0) return list_;
        
    //     else if(list.size() > 0 && list_.size() == 0) {
    //         var a = list.get(0);
    //         list.remove(a);
    //         var listInsert = merge(list, list_);
    //         if(!listInsert.isEmpty()) {
    //             var b = listInsert.get(listInsert.size()-1);
    //             if(a > b) {
    //                 listInsert.add(a);
    //             } else if(a < b) { 
    //                 listInsert.remove(b);
    //             } else { // 중복값을 어떻게 하면 좋을까..
    //                 listInsert.add(0, a);
    //                 listInsert.remove(b); // 아무짓도 안한건데 그걸 어떻게 해야할지 몰라섴ㅋㅋㅋ
    //             } return listInsert;
    //         } else {
    //             listInsert.add(a);
    //             return listInsert;
    //         }
    //     } else if(list_.size() > 0 && list.size() == 0) {
    //         var a = list_.get(0);
    //         list_.remove(a);
    //         var list_Insert = merge(list, list_);
    //         if(!list_.isEmpty()) {
    //             var b = list_Insert.get(list_.size()-1);
    //             if(a > b) {
    //                 list_Insert.add(a);
    //             } else if(a < b) {
    //                 list_Insert.remove(b);
    //             } else {
    //                 list_Insert.add(0, a);
    //                 list_Insert.remove(b);
    //             } return list_Insert;
    //         } else {
    //             list_Insert.add(a);
    //         } return list_Insert;
    //     } else { // 하나의 정렬된 리스트로 만들어서 반환.
    //         var listIsempy = new ArrayList<Integer>();

    //         list.addAll(list_);
    //         var a = list.get(0); // 합친 리스트의 0번
    //         list.remove(a);

    //         var listMerge = merge(list, listIsempy); // 합친 리스트와 비어있는 리스트를 받음. n-1
    //         var b = listMerge.get(listMerge.size()-1); // 합친 리스트의 마지막 값.

    //         if(!listMerge.isEmpty()) {
    //            if(a > b) {
    //             listMerge.add(a);
    //            } else if(a < b) {
    //             listMerge.remove(b);
    //            } else {
    //             listMerge.add(a);
    //             listMerge.remove(a);
    //            }
    //         } else {
    //             listMerge.add(a);
    //         }
    //         return listMerge;
    //     }
    // }
}

/*
    merge: (ArrayList<Integer>, ArrayList<Integer>) -> ArrayList<Integer>
    1. 리스트 2개를 받아서 두개를 합치는데, 반환되는 리스트는 정렬이 되어있어야 함. (순서대로 합치는 것)
 */

// String 하나와 패턴(String) 을 받으면, 패턴이 시작하는 모든 인덱스를 String 에서 찾으시오. 
// 예를 들어, “abracadabra” 라는 String 과 “abr” 이라는 패턴이 주어지면, [0, 7]을 반환해야 합니다.
// getNumericValue
// 같은 문자열이 있을 떄, 없을 때,
// 있으면 list에 추가 하고 list를 반환

