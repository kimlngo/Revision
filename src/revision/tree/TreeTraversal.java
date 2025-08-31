package revision.tree;

import revision.data.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TreeTraversal {
    public static void main(String[] args) {
        TreeNode root = createTree();
        System.out.println("===== BFS Traverse =====");
        System.out.println(bfsTraverse(root));
        bfsLevelByLevel(root).forEach(System.out::println);

        System.out.println("===== DFS Traverse =====");
        System.out.println("Pre-Order: " +
                dfsPre(root).stream().map(TreeNode::toString).collect(Collectors.joining(" - ")));

        System.out.println("In-Order: " +
                dfsIn(root).stream().map(TreeNode::toString).collect(Collectors.joining(" - ")));

        System.out.println("Post-Order: " +
                dfsPost(root).stream().map(TreeNode::toString).collect(Collectors.joining(" - ")));
    }

    private static TreeNode createTree() {
        var root = new TreeNode(5);
        var three = new TreeNode(3);
        var two = new TreeNode(2);

        var eight = new TreeNode(8);
        var seven = new TreeNode(7);
        var nine = new TreeNode(9);

        root.left = three;
        root.right = eight;

        three.left = two;

        eight.left = seven;
        eight.right = nine;
        return root;
    }

    private static List<TreeNode> bfsTraverse(TreeNode root) {
        if(root == null) new ArrayList<TreeNode>();

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        List<TreeNode> result = new ArrayList<>();

        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            result.add(cur);

            if(cur.left != null) queue.add(cur.left);
            if(cur.right != null) queue.add(cur.right);
        }

        return result;
    }

    private static List<List<TreeNode>> bfsLevelByLevel(TreeNode root) {
        if(root == null) return new ArrayList<>();

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        List<List<TreeNode>> result = new ArrayList<>();

        while(!queue.isEmpty()) {
            int size = queue.size();

            List<TreeNode> level = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                level.add(cur);

                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }

            //add a separator for level
            result.add(level);
        }
        return result;
    }


    private static List<TreeNode> dfsPre(TreeNode root) {
        if(root == null) return List.of();

        List<TreeNode> result = new ArrayList<>();
        traverseDFSPre(root, result);
        return result;
    }

    private static List<TreeNode> dfsIn(TreeNode root) {
        if(root == null) return List.of();

        List<TreeNode> result = new ArrayList<>();
        traverseDFSIn(root, result);
        return result;
    }

    private static List<TreeNode> dfsPost(TreeNode root) {
        if(root == null) return List.of();

        List<TreeNode> result = new ArrayList<>();
        traverseDFSPost(root, result);
        return result;
    }


    private static void traverseDFSPre(TreeNode node, List<TreeNode> list) {
        if(node == null) return;

        list.add(node);
        traverseDFSPre(node.left, list);
        traverseDFSPre(node.right, list);
    }

    private static void traverseDFSIn(TreeNode node, List<TreeNode> list) {
        if(node == null) return;

        traverseDFSIn(node.left, list);
        list.add(node);
        traverseDFSIn(node.right, list);
    }

    private static void traverseDFSPost(TreeNode node, List<TreeNode> list) {
        if(node == null) return;

        traverseDFSPost(node.left, list);
        traverseDFSPost(node.right, list);
        list.add(node);
    }
}
