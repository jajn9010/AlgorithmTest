package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Heap {
	private int capacity = 10;
	private int size = 0;
	
	 int[] items = new int[capacity];
	 
	    private int getLeftChildIndex(int parentIndex) {
	        return 2 * parentIndex + 1;
	    }
	 
	    private int getRightChildIndex(int parentIndex) {
	        return 2 * parentIndex + 2;
	    }
	 
	    private int getParentIndex(int childIndex) {
	        return (childIndex - 1) / 2;
	    }
	 
	    private boolean hasLeftChild(int index) {
	        return getLeftChildIndex(index) < size;
	    }
	 
	    private boolean hasRightChild(int index) {
	        return getRightChildIndex(index) < size;
	    }
	 
	    private boolean hasParent(int index) {
	        return getParentIndex(index) >= 0;
	    }
	 
	    private int leftChild(int index) {
	        return items[getLeftChildIndex(index)];
	    }
	 
	    private int rightChild(int index) {
	        return items[getRightChildIndex(index)];
	    }
	 
	    private int parent(int index) {
	        return items[getParentIndex(index)];
	    }
	 
	    private void ensureExtraCapacity() {
	        if (size == capacity) {
	            items = Arrays.copyOf(items, capacity * 2);
	            capacity *= 2;
	        }
	    }
	 
	    public int peek() {
	        if (size == 0) return 0;
	        return items[0];
	    }
	 
	    public int poll() {
	        if (size == 0) return 0;
	        int item = items[0];
	        items[0] = items[size - 1];
	        items[size - 1] = 0;
	        size--;
	        heapifyDown();
	        return item;
	    }
	 
	    public void add(int item) {
	        ensureExtraCapacity();
	        items[size] = item;
	        size++;
	        heapifyUp();
	    }
	 
	    private void heapifyUp() {
	        int index = size - 1;
	        while (hasParent(index) && parent(index) > items[index]) {
	            swap(getParentIndex(index), index);
	            index = getParentIndex(index);
	        }
	    }
	 
	    private void heapifyDown() {
	        int index = 0;
	        while (hasLeftChild(index)) {
	            int smallerChildIndex = getLeftChildIndex(index);
	            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
	                smallerChildIndex = getRightChildIndex(index);
	            }
	 
	            if (items[index] < items[smallerChildIndex]) {
	                break;
	            } else {
	                swap(smallerChildIndex, index);
	                index = smallerChildIndex;
	            }
	        }
	    }
	 
	    private void swap(int smallerChildIndex, int index) {
	        int temp = items[smallerChildIndex];
	        items[smallerChildIndex] = items[index];
	        items[index] = temp;
	    }
	 
	    public void printHeap() {
	        System.out.println(Arrays.toString(items));
	    }
}

public class D1927 {
	static Heap heap = new Heap();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			int a = Integer.parseInt(br.readLine());
			
			if(a == 0) sb.append(heap.poll()).append("\n");
			else if (a > 0) heap.add(a);
		}
		System.out.println(sb);
	}
}
