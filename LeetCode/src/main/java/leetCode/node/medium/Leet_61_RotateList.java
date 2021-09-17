package leetCode.node.medium;

import base.ListNode;
import com.alibaba.fastjson.JSON;

/**
 * leetcode 61 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * 示例1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 *
 * 示例2：
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 */
public class Leet_61_RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode sentinel = head, temp = head;
        int length = 0, curr = 0;
        //第一次遍历，获取链表长度
        while (sentinel != null) {
            sentinel = sentinel.next;
            length++;
        }
        int mod = k % length;
        //mod为0，说明不需要旋转
        if (mod == 0) {
            return head;
        }
        ListNode firstHalf = temp, lastHalf = null;
        //第二次遍历，找到链表旋转分界点
        while (temp != null && mod > 0) {
            curr++;
            //遍历到分界点，lastHalf=当前节点的next,然后当前节点next置为null
            if (curr == length - mod) {
                lastHalf = temp.next;
                temp.next = null;
                break;
            }
            temp = temp.next;
        }
        ListNode temp2 = lastHalf;
        //第三次遍历，将lastHalf遍历到末尾，再将next指向firstHalf
        while (temp2 != null) {
            if (temp2.next == null) {
                temp2.next = firstHalf;
                break;
            }
            temp2 = temp2.next;
        }
        return lastHalf;
    }

    public static void main(String[] args) {
        Leet_61_RotateList instance = new Leet_61_RotateList();
        ListNode head = ListNode.init(new int[]{1,2,3,4,5});
        System.out.println(JSON.toJSONString(instance.rotateRight(head, 2)));
    }
}
