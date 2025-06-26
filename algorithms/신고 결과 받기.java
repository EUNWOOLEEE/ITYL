import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        HashMap<String, Integer> receiveMap = new HashMap<>();
        
        for (String id : id_list)
            reportMap.put(id, new HashSet<>());
        
        for (String info : report) {
            String[] splited = info.split(" ");
            reportMap.get(splited[1]).add(splited[0]);
        }
        
        for (String id : id_list) {
            ArrayList<String> people = new ArrayList(reportMap.get(id));
            if (people.size() < k)
                continue;
            for (String person : people)
                receiveMap.put(person, receiveMap.getOrDefault(person, 0) + 1);
        }
        
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++)
            if (receiveMap.containsKey(id_list[i]) == true)
                answer[i] = receiveMap.get(id_list[i]);
        
        return answer;
    }
}
