package com.example.sf;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 算法题
 */
public class SfExample {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int A[]={33,24,21,34,98};
		Scanner input=new Scanner(System.in);
		System.out.println("请输入一个数：");
		int num=input.nextInt();//输入一个正整数
		System.out.println("输入的数字是："+num);
		
		while(num>0)
	    {
	    	System.out.println("请输入n");
	    	int n=input.nextInt();//输入一个正整数
	    	System.out.println("请输入k");
	    	int k=input.nextInt();//输入一个正整数
	        for(int i=0;i<n;i++)
	        	System.out.println(A[i]);
	         k--;
	        while(k==1)
	        	nextPermutation(A);
	        for(int i=0;i<n;i++)
	        {
	            if(i==0)
	            	System.out.println(" ");
	            System.out.println(A[i]);
	        }
	        System.out.println("\n");
	    }
	}
	
	public static void nextPermutation(int[] num)  
    {  
        if(num.length <= 1)  
            return ;  
        for(int i = num.length - 2; i >= 0; i--)  
        {  
            if(num[i] < num[i+1])  
            {  
                int j;  
                for(j = num.length - 1; j >= i; j--)  
                    if(num[i] < num[j])  
                        break;  
                // swap the two numbers.  
                num[i] = num[i] ^ num[j];  
                num[j] = num[i] ^ num[j];  
                num[i] = num[i] ^ num[j];  
                //sort the rest of arrays after the swap point.  
                Arrays.sort(num, i+1, num.length);  
                return ;  
            }  
        }  
        //reverse the arrays.  
        for(int i = 0; i < num.length / 2; i++)  
        {  
            int tmp = num[i];  
            num[i] = num[num.length - i - 1];  
            num[num.length - i - 1] = tmp;  
        }  
    }
}
