package io.oicp.yorick61c.test;

public class Merge {

    public static void merge(int[] A, int m, int[] B, int n) {

        int i = 0, j = 0, countA = m;

        while(i + j <= A.length){

            if(i + 1 < A.length && B[j] >= A[i] && B[j] < A[i + 1]){

                move(A,i,countA++);

                A[++i] = B[j++];

            } else if ( i >= m + j){

                A[i++] = B[j++];

            }else if (B[j] < A[i]){

                move(A,i,countA++);

                A[i++] = B[j++];

            }
            else{

                i++;

            }
        }

    }
    public static void move(int[] A, int index, int len){

        while(len > index)

            A[len] = A[--len];

    }

    public static void main(String[] args) {


        int[] A = {1,2,3,0,0,0};

        int[] B = {2,5,6};

        merge(A,3,B,3);

        for (int a: A) {

            System.out.println(a);
        }
    }
}
