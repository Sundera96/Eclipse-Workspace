import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class DivideAndConquerProblems {

	public static void main(String[] args) {
//		int[] arr = {1,2,3,4,5};
//		System.out.println(binarySearchIndexAndValue(arr, 0, arr.length-1));
		
//		DivideAndConquerProblems divideAndConquer = new DivideAndConquerProblems();
//		Point[] points = {divideAndConquer.new Point(2,1),divideAndConquer.new Point(4,4),divideAndConquer.new Point(1,2),divideAndConquer.new Point(6,3)};
//		
//		Arrays.sort(points,new Comparator<Point>() {
//			@Override
//			public int compare(DivideAndConquerProblems.Point o1, DivideAndConquerProblems.Point o2) {
//				if(o1.x<o2.x) {
//					return -1;
//				}else if(o1.x>o2.x) {
//					return 1;
//				}else {
//					return 0;
//				}
//			}
//		});
		
//		System.out.println(divideAndConquer.closestDistance(points, 0,points.length-1));
//		divideAndConquer.distance(divideAndConquer.new Point(2,1),divideAndConquer.new Point(4,4));
		int[] arr = {1,3,5,7,2,4,6,8};
		DivideAndConquerProblems divideAndConquer = new DivideAndConquerProblems();
//		System.out.println(divideAndConquer.maxSumOfSubArray(arr, 0, arr.length-1));
//		arr = divideAndConquer.shuffleArray(arr,0,arr.length-1);
//		for(int val:arr) {
//			System.out.println(val);
//		System.out.println(divideAndConquer.exponentialValue(9,10));

		int[][] input =  {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
		//{{0,2147483647,2147483647}};
		//{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
		List<List<Integer>> list = divideAndConquer.getSkyline(input);
		System.out.println(list);
	}
	
	public static int binarySearchIndexAndValue(int[] arr, int low, int high) {
		if(low>high) {
			return -1;
		}
		int mid = (low+high)/2;
		if(mid>arr[mid]) {
			return binarySearchIndexAndValue(arr,low,mid-1);
		}else if(mid<arr[mid]) {
			return binarySearchIndexAndValue(arr,mid+1,high);
		}else {
			return mid;
		}
	}
	
	/************************************************************/ //Find the closest distance from list of points *************************
	private class Point{
		int x;
		int y;
		Point(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	
	
	public long closestDistance(Point[] points,int low, int high) {
		if(low>=high) {
			return Long.MAX_VALUE/2;
		}
		int mid = (low+high)/2;
		long leftClosestDistance = closestDistance(points,low,mid);
		long rightClosestDistance = closestDistance(points,mid+1,high);
		long delta = Math.min(leftClosestDistance, rightClosestDistance);
		Point[] strip = new Point[points.length];
		int stripIndex = 0;
		for(int index=low;index<=mid;index++) {
			if(points[mid].x-points[index].x<delta) {
				strip[stripIndex++]=points[index];
			}
		}
		for(int index=mid+1;index<=high;index++) {
			if(points[index].x-points[mid].x<delta) {
				strip[stripIndex++]=points[index];
			}
		}
				
		Arrays.sort(strip,0,stripIndex,new Comparator<Point>() {
			@Override
			public int compare(DivideAndConquerProblems.Point o1, DivideAndConquerProblems.Point o2) {
				if(o1.y<o2.y) {
					return -1;
				}else if(o1.y>o2.y) {
					return 1;
				}else {
					return 0;
				}
			}
		});
		
		for(int index=0;index<stripIndex;index++) {
			for(int compareIndex=index+1;compareIndex<stripIndex&&Math.abs(strip[index].y-strip[compareIndex].y)<delta;compareIndex++) {
				delta = Math.min(delta,distance(strip[index],strip[compareIndex]));
			}
		}
		return delta;
	}

	private long distance(Point point1, Point point2) {
		return (long) (Math.pow(point1.x-point2.x,2)+Math.pow(point1.y-point2.y,2));
	}
	
	/************************************************************/ //Find the closest distance from list of points *************************

	
	public int maxSumOfSubArray(int[] array, int low, int high) {
		if(low==high) {
			return array[low];
		}
		int mid = (low+high)/2;
		int leftMaxSum = maxSumOfSubArray(array, low, mid);
		int rightMaxSum = maxSumOfSubArray(array,mid+1,high);
		int sum=0;
		int leftSum=0;
		int rightSum=0;
		for(int index=mid;index>=0;index--) {
			sum+=array[index];
			leftSum = Math.max(leftSum,sum);
		}
		sum=0;
		for(int index=mid+1;index<=high;index++) {
			sum+=array[index];
			rightSum = Math.max(rightSum,sum);
		}
		return max(leftMaxSum,rightMaxSum,leftSum+rightSum);
	}

	private int max(int sum1, int sum2, int sum3) {
		if(sum1>sum2&&sum1>sum3) {
			return sum1;
		}else {
			if(sum2>sum3)
				return sum2;
			return sum3;
		}
	}
	
/********************************Given an array a1 a2 a3 a4 b1 b2 b3 b4 convert it to array a1 b1 a2 b2 a3 b3 a4 b4
 ******************************************************/
	
	public int[] shuffleArray(int[] arr, int low, int high) {
		if(low==high) {
			return arr;
		}
		int midIndex = (low+high)/2;
		int swapIndexLeft = (low+midIndex)/2+1;
		int swapIndexRight = midIndex+1;
		for(;swapIndexLeft<midIndex+1;swapIndexLeft++) {
			int temp = arr[swapIndexLeft];
			arr[swapIndexLeft]=arr[swapIndexRight];
			arr[swapIndexRight++]=temp;
		}
		shuffleArray(arr, low, midIndex);
		shuffleArray(arr, midIndex+1, high);
		return arr;
	}
	
/**********find the value of exponential expressions in log(n) time***********/
	
	public BigInteger exponentialValue(int n, int k) {
		if(k==1) {
			return BigInteger.valueOf(n);
		}
		BigInteger temp = exponentialValue(n,k/2);
		if(k%2==0) {
			temp = temp.multiply(temp);
		}else if(k>0) {
			temp=temp.multiply(temp).multiply(BigInteger.valueOf(n));
		}
		return temp;
	}

	public List<List<Integer>> getSkyline(int[][] buildings) {
		int longestCoordinate = maxOfRight(buildings);
		boolean run = true;
		int counter = 0;
		List<List<Integer>> listOfList = new LinkedList<List<Integer>>();
		HashSet<Integer> set = new HashSet<Integer>();
		int prevHeight = -1;
		int vacantIndex = -1;
		while(run) {
			int leftIndex = counter*1000;
			int rightIndex = (++counter)*1000-1;
			if(leftIndex>longestCoordinate||leftIndex<0) {
				break;
			}
			int[] maxHeightArr = new int[1000];
			for(int buildingIndex=0;buildingIndex<buildings.length;buildingIndex++) {
				int start = buildings[buildingIndex][0];
				int end = buildings[buildingIndex][1];
				int height = buildings[buildingIndex][2];
				if(leftIndex<=start||leftIndex<=end) {
					for(int index=start;index<end&&index<=rightIndex;index++) {
						if(maxHeightArr[index%1000]<height) {
							maxHeightArr[index%1000]=height;
						}
					}
				}
			}
			for(int index=0;index<maxHeightArr.length-1;index++) {
				if(maxHeightArr[index]==0) {
					if(vacantIndex==index-1||vacantIndex==-1) {
						vacantIndex=index;
						continue;
					}
					vacantIndex=index;
					List<Integer> list = new LinkedList<Integer>();
					list.add(index);
					list.add(maxHeightArr[index]);
					listOfList.add(list);
					set.clear();
				}else {
					if(prevHeight==-1||maxHeightArr[index]!=prevHeight&&set.add(maxHeightArr[index])) {
						List<Integer> list = new LinkedList<Integer>();
						list.add(index);
						list.add(maxHeightArr[index]);
						set.add(maxHeightArr[index]);
						listOfList.add(list);
						vacantIndex=-2;
					}
				}
				prevHeight=maxHeightArr[index];
			}
		}
		return listOfList;
	}

	private int maxOfRight(int[][] buildings) {
		int max = 0;
		for(int index=0;index<buildings.length;index++) {
			if(max<buildings[index][1]) {
				max = buildings[index][1];
			}
		}
		return max;
	}
}
