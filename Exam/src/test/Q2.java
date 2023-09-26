package test;

import java.util.*;

public class Q2 {
    private static int count;
    public static void main(String[] args) {
        //2 7 11 15
        //2
        //9
//-1 0 1 2 -1 -4
//3
//0
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(scanner.nextLine());
        int target = Integer.parseInt(scanner.nextLine());

//        int[] nums = new int[]{-1,0,1,2,-1,-4};
//        int k = 3;
//        int target = 0;
        boolean[] visit = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        //排序一下 方便把太大的及时排除
        Arrays.sort(nums);
        backtrack(nums,k,target,0,0,visit,0,path,res);
        HashSet<String> set = new HashSet<>();
        for (List<Integer> list : res) {
            StringBuilder sb = new StringBuilder();
            list.sort((a,b) -> a - b);
            for (Integer integer : list) {
                sb.append(integer+"");
            }
            set.add(sb.toString());
        }
        System.out.println(set.size());

    }
    private static void backtrack(int[] nums, int k, int target, int level, int sum,
                                  boolean[] visit, int start,List<Integer> path,List<List<Integer>> res){
        if (level == k){
            //结束,如果sum等于target，count++
            if (sum == target){
                count++;

                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
//            if (i > 0 && nums[i-1] == nums[i]){//剪枝操作，为了去重
//                continue;
//            }

            if (visit[i] == true ){//已经被选了
                continue;
            }
            visit[i] = true;
            path.add(nums[i]);
            backtrack(nums, k, target, level+1, sum+nums[i], visit,start+1,path,res);
            visit[i] = false;
            path.remove(path.size()-1);
        }
    }
}
