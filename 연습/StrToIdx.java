import java.util.*;

public class StrToIdx {
    public static void main(String[] args) {
        // ArrayList<Integer> list = new ArrayList();
        var li = new ArrayList();
        String str = "abracadabra";
        String p = "abr";
        
        // var list = idxPattern_(str, p);
        // Collections.sort(list);
        // System.out.println(list);

        // var li = strIdxP(str, p, 0);
        // Collections.sort(li);
        System.out.println(li);

    }

    private static ArrayList<Optional<Integer>> strIdx(String s, String p, int i) {
        
        if(s.length() == 0) return new ArrayList();
        if(p.length() == 0) return new ArrayList();
        else if(s.length() < p.length()) return new ArrayList();
        else { //>=
            if (s.indexOf(p) != -1) {
                var dif = (p.length() -1);
                var s_ = s.replaceFirst(p, "*");
                li.add(s.indexOf(p));
                var li = strIdx(s, p, i + dif);
                return li;
            }  
            else return new ArrayList();
        }
    }

    public static ArrayList<Optional<Integer>> strIdxP(String s, String p, int i) {
        return strIdx(s, p, 0);
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
}

/*
idxPattern("abracadabra", "abr") -> 0
idxPattern("*bracadabra", "abr") -> 7
idxPattern("*bracad*bra", "abr") -> new Arrayist()
[] -> [].add(7) -> [7] -> [7].add(0) -> [7, 0]
*/

// String 하나와 패턴(String) 을 받으면, 패턴이 시작하는 모든 인덱스를 String 에서 찾으시오. 
// 예를 들어, “abracadabra” 라는 String 과 “abr” 이라는 패턴이 주어지면, [0, 7]을 반환해야 합니다.
// getNumericValue
// 같은 문자열이 있을 떄, 없을 때,
// 있으면 list에 추가 하고 list를 반환