package 力扣热题;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author mxio
 *
 * https://leetcode.cn/problems/course-schedule-ii/
 */
public class _210_课程表 {

    /**
     * 方法一：拓扑排序
     *
     * 1、在开始排序前，扫描对应的存储空间（使用邻接表），将入度为 00 的结点放入队列。
     * 2、只要队列非空，就从队首取出入度为 00 的结点，将这个结点输出到结果集中，并且将这个结点的所有邻接结点（它指向的结点）的入度减 11，在减 11 以后，如果这个被减 11 的结点的入度为 00 ，就继续入队。
     * 3、当队列为空的时候，检查结果集中的顶点个数是否和课程数相等即可。
     * （思考这里为什么要使用队列？如果不用队列，还可以怎么做，会比用队列的效果差还是更好？）
     * 在代码具体实现的时候，除了保存入度为 00 的队列，我们还需要两个辅助的数据结构：
     * 1、邻接表：通过结点的索引，我们能够得到这个结点的后继结点；
     * 2、入度数组：通过结点的索引，我们能够得到指向这个结点的结点个数。
     * 这个两个数据结构在遍历题目给出的邻边以后就可以很方便地得到。
     *
     */
    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[0];
        }

        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i]  = new HashSet<>();
        }

        // [1, 0] 0 -> 1
        int[] inDegree = new int[numCourses];
        for (int[] p : prerequisites) {
            adj[p[1]].add(p[0]);
            inDegree[p[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] res = new int[numCourses];
        // 当前结果集列表里的元素个数，正好可以作为下标
        int count = 0;

        while (!queue.isEmpty()) {
            // 当前入度为0的顶点
            Integer head = queue.poll();
            res[count] = head;
            count++;

            Set<Integer> successors = adj[head];
            for (Integer nextCourse : successors) {
                inDegree[nextCourse]--;
                // 马上检测该节点的入度是否为0，如果为0，马上加入队列
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        // 如果结果集中的数量不等于节点的数量，就不能完成课程任务，这一点是拓扑排序的结论
        if (count == numCourses) {
            return res;
        }
        return new int[0];
    }

}
