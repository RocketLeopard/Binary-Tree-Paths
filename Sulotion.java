class Solution {
    private ArrayList<String> resultList = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return resultList;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        printPaths(root, arrayList);

        return resultList;
    }

    private void printPaths(TreeNode root, List<Integer> arrayList) {
        arrayList.add(root.val);

        if (root.left == null && root.right == null) {
            resultList.add(arrayToString(arrayList, "->"));
        }

        if (root.left != null) {
            printPaths(root.left, arrayList);
        }
        if (root.right != null) {
            printPaths(root.right, arrayList);
        }

        arrayList.remove(arrayList.size() - 1);
    }

    public String arrayToString(List<Integer> list, String join) {
        StringBuilder sb = new StringBuilder();
        int listLen = list.size();
        for (int i = 0; i < listLen; i++) {
            sb.append(list.get(i) + join);
        }

        int sbLen = sb.length();
        int joinLen = join.length();
        sb.delete(sbLen - joinLen, sbLen);

        return sb.toString();
    }
}
