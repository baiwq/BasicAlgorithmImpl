package com.bwq.medium
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 实现两数相加
 */
public class TheTwoTogether {
    public static void main(String[] args)
    {
        System.out.print('开始环境测试');
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1.首先将链表数据拼接成非负的整数

        // 2.两数实现累加

        // 3.将累加后的数据再逆序写到输出链表中

        //summary：上面的思路没法进行下去
        //  发现无论是int还是long都会存在溢出，无法完成所有测试案例。
        /**
         * 一种思路：按照链表的结构逐位相加
         * 1.预定义节点数据，位移的节点数据
         * 2.遍历的条件就是最长的链表,短链表补零就好
         * 3.定义进位值（相加%10,除以10取整），节点值（相加/10 除以10取余）
         */
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1!=null||l2!=null){
           int x1 = l1==null ? 0 : l1.val;
           int x2 = l2==null ? 0 : l2.val;

           // 计算两数相加的值，再加上进位值
            int sum = x1 + x2 + carry;

            carry = sum % 10;
            sum = sum / 10;

            cur.next = new  ListNode(sum);
            cur = cur.next;

            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
        }

        if(carry==1){
            cur.next = new ListNode(carry);
        }
        return carry;
    }

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
}