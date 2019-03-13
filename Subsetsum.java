import java.util.*;
class Main {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int a[]=new int[n];
    for(int i=0;i<n;i++){
      a[i]=sc.nextInt();
    }
    int k=sc.nextInt();
    int c[]=new int[n];
    for(int i=0;i<n;i++){
      c[i]=0;
    }
    for(int i=0;i<n;i++){
      c[0]=a[i];
      subsetSum(a,c,1,k,i+1);
    }
  }
  public static void subsetSum(int a[],int c[],int in,int k,int x){
    for(  int i=x;i<a.length;i++){
      System.out.println(a[i]);
            for(int j=0;j<c.length;j++){
              System.out.print(c[j]+" ");
          }
      if(place(c,a[i])){
          c[in]=a[i];
          int sum=0;
          for(int j=0;j<c.length;j++){
              sum=sum+c[j];
              System.out.print(c[j]+" ");
          }
          System.out.println(sum);
          if(sum==k){
            for(int j=0;j<c.length;j++)
            System.out.print(c[j]+" ");
            System.out.println();
          }
          if(in==a.length-1){}
          else{
            subsetSum(a,c,in+1,k,i+1);
            c[in+1]=0;
          }
      }
    }
  }
  public static boolean place(int c[],int v){
    System.out.println(v);
    for(int i=0;i<c.length;i++){
      if(c[i]==v){
        return false;
      }
    }
    return true;
  } 
}
