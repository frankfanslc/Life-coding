package leetcode.contests.contest_130;

import leetcode.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class NextGreaterNodeInLinkedList_1019 {

    NextGreaterNodeInLinkedList_1019 nextGreaterNodeInLinkedList;
    static int size=0;

    @BeforeEach
    public void init() {
        nextGreaterNodeInLinkedList = new NextGreaterNodeInLinkedList_1019();
    }

    @Test
    public void firstPositiveNextLargerNodes() {
        int[] input = new int[]{2, 1, 5};
        ListNode head = construct(input);
        size=input.length;
        int[] res= nextGreaterNodeInLinkedList.nextLargerNodes(head);
        Arrays.deepToString(new int[][]{res});
    }

    @Test
    public void secondPositiveNextLargerNodes() {
        int[] input = new int[]{2,7,4,3,5};
        ListNode head = construct(input);
        size=input.length;
        int[] res= nextGreaterNodeInLinkedList.nextLargerNodes(head);
        Arrays.deepToString(new int[][]{res});

    }

    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> result=new ArrayList<>();
        ListNode start=head;
        ListNode forward=head.next;
        int j=0;

        while (start!=null && forward!=null){
            if(forward.val>start.val){
                result.add(forward.val);
                start=start.next;
            }else{
                forward=forward.next;
            }
            if(forward==null){
                result.add(0);
                start=start.next;
                if(start!=null)
                    forward=start.next;
            }
        }
        int[] res=new int[result.size()];
        for (int i = 0; i <result.size() ; i++) {
            res[i]=result.get(i);
        }
        return res;
    }

    private ListNode construct(int[] input) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        for (int i = 0; i < input.length; i++) {
            head.next = new ListNode(input[i]);
            head = head.next;
        }
        return temp.next;
    }
}
