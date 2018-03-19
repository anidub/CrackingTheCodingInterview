package treesandgraph3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://stackoverflow.com/questions/37730601/build-groups-from-a-directed-graph-dictionary
 */
public class groupsFlattened {

	public static void main(String[] args) {
	    HashMap<String, List<String>> hmap = new HashMap<String,List<String>>();
        List<String> l1 = new ArrayList<String>();
        List<String> l2 = new ArrayList<String>();
        List<String> l3 = new ArrayList<String>();
        List<String> l4 = new ArrayList<String>();
        List<String> l5 = new ArrayList<String>();
        l1.add("group3"); l1.add("group5"); l1.add("user8"); l1.add("user2");
        l2.add("group1"); l2.add("user9");
        l3.add("group4"); l3.add("user5");
        l4.add("user1"); l4.add("user3");
        l5.add("user4"); l5.add("user7");
        hmap.put("group1",l1);
        hmap.put("group2",l2);
        hmap.put("group3",l3);
        hmap.put("group4",l4);
        hmap.put("group5", l5);
       // System.out.println(hmap);
        flattenGroup(hmap);
	}
	
	public static void flattenGroup(Map<String, List<String>> groupMap){
		for(String str : groupMap.keySet()){
			System.out.println(str  + ": " +flatten(groupMap, str));
		}
	}
	
	public static List<String> flatten(Map<String, List<String>> groupMap, String group){
		List<String> groupElements = groupMap.get(group);
		if(groupElements == null)
			return Collections.emptyList();
		List<String> childrens = new ArrayList<>();
		for(int i = 0; i < groupElements.size(); i++){
			if(groupElements.get(i).startsWith("user")){
				childrens.add(groupElements.get(i));
			}else{
				childrens.addAll(flatten(groupMap, groupElements.get(i)));
			}
		}
		return childrens;
	}

}
