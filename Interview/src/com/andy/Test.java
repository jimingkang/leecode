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
}


