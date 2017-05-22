/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    boolean checkBST(Node root) {
        if (root == null){
            // base case
            return true;
        }
        // check if root is not greater than left and root is not less than right
        if(root.left != null && maxChildValue(root.left) > root.data) {
            return false;
        }
        if(root.right != null && maxChildValue(root.right) < root.data) {
            return false;
        }
        return checkBST(root.left) && checkBST(root.right);
    }

   // calculate the maximum value of child node
   int maxChildValue(Node node){
       if(node == null){
           return -1;
       }
       // get max value of left child
       int leftMaxValue = node.left == null ? -1 : maxChildValue(node.left);
       // get max value of right child
       int rightMaxValue = node.right == null ? -1 : maxChildValue(node.right);
       //return the max of node.data, left child or right child
       int maxValue = node.data > leftMaxValue ? node.data : leftMaxValue;
       
       maxValue = maxValue > rightMaxValue ? maxValue : rightMaxValue;
       return maxValue;
   }
