package com.andy;

import com.andy.ds.LinkList;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Test t=new Test();

        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(t.maxArea(height));
    }

    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int max=-1;
        while(i<j){
            max=Math.max(max,Math.min(height[i],height[j])*(j-i));
            if(height[i]<height[j])
            i++;
            else
            j--;

        }
        return max;

    }

    //leetcode 3. Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int right=0;
        int len=0;
        int max=0;

        StringBuffer sb=new StringBuffer();

        for (; right <s.length(); right++) {
            while(sb.toString().indexOf(s.charAt(right))>=0) {
                left++;
                sb.delete(0,1);
            }

                sb.append(s.charAt(right));
                len=sb.length();


            max= Math.max(len,max);

        }
        return max;

    }


//4. Median of Two Sorted Arrays
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] merged = new int[m + n];

        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        // remaining elements
        while (i < m) merged[k++] = nums1[i++];
        while (j < n) merged[k++] = nums2[j++];

        int len = m + n;

        if (len % 2 == 1) {
            return merged[len / 2];
        } else {
            return (merged[len / 2 - 1] + merged[len / 2]) / 2.0;
        }
    }
 //20. Valid Parentheses
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<Character>();
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)=='{'||s.charAt(i)=='('||s.charAt(i)=='[')
                stack.push(s.charAt(i));
           else{
               if(stack.isEmpty()) return false;
                char top = stack.pop();

                if ((s.charAt(i) == ')' && top != '(') ||
                        (s.charAt(i) == '}' && top != '{') ||
                        (s.charAt(i) == ']' && top != '[')) {
                    return false;
                }

                }
            }
        return stack.isEmpty();

    }
//27. Remove Element
    public int removeElement(int[] nums, int val) {
        int slow=0;
        int fast=0;
        int count=0;
        for (int i = 0; i< nums.length ; i++) {
            if(nums[fast]!=val){
                fast++;
            }else{
                nums[slow]=nums[fast];
                slow++;
                count++;
            }
        }
        return count;

    }
    //
    public int removeDuplicates(int[] nums) {
        int slow=0;

        int count=1;
        for (int i = 0; i< nums.length ; i++) {
            if(nums[i]==nums[slow]){
            }else{
                slow++;
                nums[slow]=nums[i];

                count++;
            }
        }
        return count;
    }
    public class ListNode {
      int val;
     ListNode next;
     ListNode() {}ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tmp=new ListNode();
        ListNode head=tmp;

        while (list1!=null && list2!=null) {

            if (list1.val <= list2.val) {
                tmp.next = list1;

                list1= list1.next;

            }else{
                tmp.next = list2;
                list2=list2.next;
            }
            tmp=tmp.next;
        }

        // remaining elements
        while (list1!=null)  {tmp.next = list1;list1= list1.next;  tmp=tmp.next;}
        while (list2!=null) { tmp.next = list2;list2= list2.next;  tmp=tmp.next;}
        return head.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res=new ListNode();
        ListNode head=res;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for (ListNode node : lists) {
            if (node != null) {
                heap.add(node);
            }
        }


        while(!heap.isEmpty()){
            ListNode node = heap.poll();
            res.next=node;
            res=res.next;
            if(node.next!=null)
            {
                heap.add(node.next);
            }
        }
        return head.next;
    }

    //46
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();

        List<Integer> tmp=new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        permutationHelper(res,tmp,nums,used);
        return res;
    }
    void permutationHelper(List<List<Integer>> res,List<Integer> tmp,int[]nums,boolean[] used){
        if(tmp.size()==nums.length)
            res.add(new ArrayList<>(tmp));

        for (int i = 0; i <nums.length ; i++) {
            if(used[i]) continue;
            tmp.add(nums[i]);
            used[i]=true;
            permutationHelper(res,tmp,nums,used);
            tmp.remove(tmp.size()-1);
            used[i]=false;

        }
    }

    //permute_swap_for 实现_
    public List<List<Integer>> permute_swap(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, res);
        return res;
    }

    private void dfs(int[] nums, int pos, List<List<Integer>> res) {
        if (pos == nums.length) {
            List<Integer> path = new ArrayList<>();
            for (int n : nums) path.add(n);
            res.add(path);
            return;
        }

        for (int i = pos; i < nums.length; i++) {
            swap(nums, pos, i);           // 选择：把 nums[i] 放到 pos
            dfs(nums, pos + 1, res);      // 递归：处理下一个位置
            swap(nums, pos, i);           // 撤销：还原
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    // 用递归代替 for (int i = pos; i < nums.length; i++)
    private void permute_swap_nofor(int[] nums, int pos, List<List<Integer>> res) {
        if (pos == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) list.add(n);
            res.add(list);
            return;
        }

        choose(nums, pos, pos, res);
    }
    private void choose(int[] nums, int pos, int i, List<List<Integer>> res) {
        if (i == nums.length) return;

        swap(nums, pos, i);
        permute_swap_nofor(nums, pos + 1, res);
        swap(nums, pos, i);

        choose(nums, pos, i + 1, res);
    }


   // 47. Permutations II
   public List<List<Integer>> permute2(int[] nums) {
       List<List<Integer>>res=new ArrayList<>();

       List<Integer> tmp=new ArrayList<>();
       boolean[] used=new boolean[nums.length];
       Arrays.sort(nums);
       permutationHelper2(res,tmp,nums,used);
       return res;
   }
   void permutationHelper2(List<List<Integer>> res,List<Integer> tmp,int[]nums,boolean[] used){
       if(tmp.size()==nums.length)
           res.add(new ArrayList<>(tmp));

       for (int i = 0; i <nums.length ; i++) {
           if(used[i]) continue;
           if(i>0&&nums[i]==nums[i-1] && !used[i - 1]) continue;
           tmp.add(nums[i]);

           used[i]=true;
           permutationHelper2(res,tmp,nums,used);
           tmp.remove(tmp.size()-1);
           used[i]=false;

       }
   }
   //314 BinaryTreeVerticalOrderTraversal

      public class TreeNode {
          int val;
          TreeNode left;
         TreeNode right;
         TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
              this.left = left;
              this.right = right;
          }
     }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<int[]>> map = new HashMap<>();

        dfs(root, 0, 0, map);

        List<Integer> cols = new ArrayList<>(map.keySet());
        Collections.sort(cols);

        List<List<Integer>> res = new ArrayList<>();

        for (int col : cols) {
            List<int[]> list = map.get(col);

            // 按 row 排序（模拟 BFS 的“上到下”）
            list.sort((a, b) -> a[0] - b[0]);

            List<Integer> tmp = new ArrayList<>();
            for (int[] pair : list) {
                tmp.add(pair[1]);
            }
            res.add(tmp);
        }

        return res;
    }

    private void dfs(TreeNode node, int row, int col,
                     Map<Integer, List<int[]>> map) {
        if (node == null) return;

        map.putIfAbsent(col, new ArrayList<>());
        map.get(col).add(new int[]{row, node.val});

        dfs(node.left, row + 1, col - 1, map);
        dfs(node.right, row + 1, col + 1, map);
    }

    //129
    public int sumNumbers(TreeNode root) {
           List<List<Integer>> res=new ArrayList<>();
        List<Integer> tmp=new ArrayList<>();
        sumNumbersHelp(root,res,tmp);
        int sum = 0;

        for (List<Integer> path : res) {
            int num = 0;
            for (int v : path) {
                num = num * 10 + v;
            }
            sum += num;
        }
        return sum;
        }
        public void sumNumbersHelp(TreeNode root,List<List<Integer>> res,List<Integer> tmp){
        if(root==null){
            //res.add(new ArrayList<>(tmp));
            return ;
        }
        tmp.add(root.val);
            if (root.left == null && root.right == null) {
                res.add(new ArrayList<>(tmp));
            } else {
                sumNumbersHelp(root.left, res, tmp);
                sumNumbersHelp(root.right, res, tmp);
            }
            tmp.remove(tmp.size()-1);


        }
     int res=0;
    public int diameterOfBinaryTree(TreeNode root) {

        if(root==null)
            return 0;
        int left=diameterOfBinaryTree(root.left);
        int right=diameterOfBinaryTree(root.right);
        int max=Math.max(left,right);
        res=max+res;
        return res;
    }
    //3. Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring_new(String s) {
int left=0;
int right=0;
int max=0;
StringBuffer sb=new StringBuffer();
        for (int i = 0; i <s.length() ; i++) {
            while (sb.indexOf(String.valueOf(s.charAt(i))) >= 0) {
                sb.deleteCharAt(0);
            }
sb.append(s.charAt(i));
            max=Math.max(max,sb.length());
        }

        return max;
    }
//11. Container With Most Water
    public int maxArea_new(int[] height) {
        int left=0;
        int right=height.length-1;
        int area=0;
        int max=0;
        while(left<right) {
            area=Math.min(height[right],height[left])*(right-left);
            max=Math.max(max,area);

            if(height[left]<height[right])
            {
            left++;
            }
            else {

            right--;
            }


        }
        return max;

    }

    //15. 3Sum
    /*
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer,ArrayList> map=new HashMap<>();
        int sum=0;

        for (int i = 0; i <nums.length ; i++) {
            sum+=nums[i];
            if(!map.containsKey(-sum)){

            }

            else {
                map.get(nums[i]).add(nums[i])

            }
            map.putIfAbsent(nums[i],new ArrayList<Integer>());

        }
        return null;

    }
    */
    public int maxSubArray(int[] nums) {

         int sum=nums[0];
        int max=nums[0];
        for (int i = 0; i<nums.length ; i++) {
            sum=Math.max(nums[i],sum+nums[i]);
            max=Math.max(max,sum);
        }
        return max;

    }

    //
    /*
    public String minRemoveToMakeValid(String s) {
    Stack<Character> stack= new Stack<Character>();
    StringBuffer sb=new StringBuffer();
    int i=0;
    while (i<s.length())
    {
        if(s.charAt(i)==')')
        {
            while(!stack.isEmpty()) {
                Character c = stack.peek();
                if (c != '(') {
                    sb.append(stack.pop());
                }

            }
        }
        stack.push(s.charAt(i));
        i++;
    }
    return sb.reverse().toString();
    }
*/
   // 339. Nested List Weight Sum
    interface NestedInteger {
        // Constructor initializes an empty nested list.
        //public NestedInteger();
        // Constructor initializes a single integer.
        //public NestedInteger(int value);

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // The result is undefined if this NestedInteger holds a nested list
        public Integer getInteger();
        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // The result is undefined if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
    //public int depthSum(List<NestedInteger> nestedList) {
    //    int sum=0;
    //    for (int i = 0; i <nestedList.size() ; i++) {
     //       sum+= depth(nestedList.get(i), 1);
     //   }
     //   return sum;
    //}
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = getMaxDepth_depthSumInverse(nestedList, 1);
        return dfs(nestedList, 1, maxDepth);
    }

     int getMaxDepth_depthSumInverse(List<NestedInteger> list, int depth) {
        int max = depth;

        for (NestedInteger ni : list) {
            if (!ni.isInteger()) {
                max = Math.max(max, getMaxDepth_depthSumInverse(ni.getList(), depth + 1));
            }
        }

        return max;
    }

    private int dfs(List<NestedInteger> list, int depth, int maxDepth) {
        int sum = 0;

        for (NestedInteger ni : list) {
            if (ni.isInteger()) {
                int weight = maxDepth - depth + 1;
                sum += ni.getInteger() * weight;
            } else {
                sum += dfs(ni.getList(), depth + 1, maxDepth);
            }
        }

        return sum;
    }


//1004. Max Consecutive Ones III
    public int longestOnes(int[] nums, int k) {
        int sum=0;
        int zeroCount=0;
        int left=0;
        int right=0;
        for (; right <nums.length ; right++) {
            if(nums[right]==0)
                zeroCount++;
            while(zeroCount>k){
                if(nums[left]==0){
                    zeroCount--;

                }
                left++;
            }
            sum=Math.max(sum,right-left+1);

        }
        return sum;
    }
    //leetcode34
    public int[] searchRange(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid=0;
        List<Integer> l=new ArrayList<>();
        while(left<=right){
            mid=left+(right-left)/2;
            if(nums[mid]<target){
              left=mid+1;

            }
            else if(nums[mid]>target){
                right=mid-1;

            }else{
                l.add(mid);
                break;
            }

            mid=(left+right)/2;

        }
        while((mid<nums.length-1)&&nums[mid+1]==target)
        {
            mid++;
        }
        if(!l.contains(mid))
        l.add(mid);


        int[] arr = l.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return arr;

    }

    //robber
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int sum=0;
       // int tmp;
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i <nums.length ; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);

        }
        return dp[nums.length-1];
    }

    //
    public boolean validPalindrome(String s) {
        boolean leftcheck=isPalindrome(s,s.length()/2,s.length()/2);
        boolean rightcheck=isPalindrome(s,s.length()/2,s.length()/2+1);
        return leftcheck&&rightcheck;
    }
    public boolean isPalindrome(String s,int start,int end)
    {int left=start;
        int right=end;
        while((left>0)&&(right<(s.length()-1))&&s.charAt(left)==s.charAt(right))
        {left--;
            right++;
        }
        if(left==0) return true;
        else return false;
    }

}




