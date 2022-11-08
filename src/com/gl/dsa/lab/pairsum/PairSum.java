package com.gl.dsa.lab.pairsum;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PairSum {

	// Recursive function to insert a node into a Binary Search Tree
	public static Node insert(Node root, int node) {
		// if the root is null, create a new node and return it
		if (root == null) {
			return new Node(node);
		}

		// if the given node is less than the root node, recur for the left subtree
		if (node < root.data) {
			root.left = insert(root.left, node);
		}

		// if the given node is more than the root node, recur for the right subtree
		else {
			root.right = insert(root.right, node);
		}

		return root;
	}

	// Function to find a pair with a given sum in the Binary Search Tree
	public static boolean findPairSum(Node root, int target, Set<Integer> set) {
		// base case
		if (root == null) {
			return false;
		}

		// return true if pair is found in the left subtree; otherwise, continue
		// processing the node
		if (findPairSum(root.left, target, set)) {
			return true;
		}

		// if a pair is formed with the current node, print the pair and return true
		if (set.contains(target - root.data)) {
			System.out.println("Pair found (" + (target - root.data) + ", " + root.data + ")");
			return true;
		}

		// insert the current node's value into the set
		else {
			set.add(root.data);
		}

		// search in the right subtree
		return findPairSum(root.right, target, set);
	}

	public static void main(String[] args) {
		System.out.println("******************************************************************");
		System.out.println("Welcome to the pair sum binary search tree assignment solution");
		System.out.println("******************************************************************");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the size of binary search tree elements");
		int size = sc.nextInt();
		int bstArr[] = new int[size];
		System.out.println("Please enter the elements of binary search tree elements");
		for (int i = 0; i < size; i++) {
			bstArr[i] = sc.nextInt();
		}
		Node root = null;
		for (int key : bstArr) {
			root = insert(root, key);
		}
		System.out.println("Please enter the sum for which pair node has to be searched\n");
		// find pair with the given sum
		int sum = sc.nextInt();
		// create an empty set
		Set<Integer> set = new HashSet<>();

		if (!findPairSum(root, sum, set)) {
			System.out.println("For the given sum, pair does not exist");
		}
	}

}
