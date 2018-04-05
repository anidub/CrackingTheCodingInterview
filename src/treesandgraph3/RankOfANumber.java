package treesandgraph3;
/**
 * Imagine you are reading in a stream of integers. Periodically, you wish to be able to
 * look up the rank of a number x (the number of values less than or equal to x). Implement
 * the data structures and algorithms to support these operations. That is, implement
 * the method track(int x), which is called when each number is generated,
 * and the methodgetRankOf'Number (int x), which returns the number of values
 * less than or equal to x (not including x itself).
 *
 *Time complexity : O(logN)
 *
 *https://github.com/yashrajrs/AlgosAndDSInJava/blob/master/src/main/java/practice/problemSolving/sortingAndSearching/RankOfNode_11_8.java
 *
 *Think of implementing Delete method for tree!!!!
 */
public class RankOfANumber {	
	RankNode root = null;
	
	public int getRank(int number){
		if(root == null) return -1;
		return root.getRankOfNumber(number);
	}
	
	public void insert(int data){
        if (root == null){
            root = new RankNode(data);
        }else{
            root.insert(data);
        }
    }
	public class RankNode{
		int data;
		RankNode left;
		RankNode right;
		int leftSize;
		
		public RankNode(int data){
			this.data = data;
		}

		public void insert(int data){
			if(data < this.data){
				if(left != null){
					left.insert(data);	
				}else{
					left = new RankNode(data);
				}
				leftSize++;
			}else{
				if(right != null){
					right.insert(data);
				}else{
					right = new RankNode(data);
				}
			}
		}
		
		
		public int getRankOfNumber(int number){
			if(number == data){
				return leftSize;
			}else if(number < data){
				if(left == null) return -1;
				else return left.getRankOfNumber(number);
			}else{
				int rightRank;
				if(right == null) return rightRank = -1;
				else rightRank = right.getRankOfNumber(number);
				return leftSize + 1 + rightRank;
			}
		}
	}
	public static void main(String[] args) {
		RankOfANumber rankOfNode = new RankOfANumber();
        rankOfNode.insert(20);
        rankOfNode.insert(15);
        rankOfNode.insert(25);
        rankOfNode.insert(10);
        rankOfNode.insert(23);
        rankOfNode.insert(5);
        rankOfNode.insert(13);
        rankOfNode.insert(24);

        System.out.println(rankOfNode.getRank(20));
        System.out.println(rankOfNode.getRank(10));
        System.out.println(rankOfNode.getRank(5));
        System.out.println(rankOfNode.getRank(2));
        System.out.println(rankOfNode.getRank(24));
	}
}