import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            int k=scan.nextInt();
            int n=scan.nextInt();
            List<List<Integer>>last=new ArrayList<>();
            for(int i=1;i<10;i++){
                List<Integer>al=new ArrayList<>();
                dfs(i,0,al,0,k,n,last);
            }
            for(int i=0;i<last.size();i++){
                if(last.get(i).size()==k){
                    for(int j=0;j<last.get(i).size();j++){
                        System.out.print(last.get(i).get(j));
                    }
                    System.out.println();
                }
            }
        }
    }
    public static void dfs(int here, int alnum,List<Integer>al,int total,int k,int n,List<List<Integer>>last){
        if(alnum<k&&total<n){
            al.add(here);
            total=total+here;
            for(int i=here+1;i<10;i++){
                dfs(i+here,alnum+1,al,total,k,n,last);
            }
        }else if(alnum==k&&total>=n){
            return;
        }else if(alnum<k&&total>=n){
            return;
        }else if(alnum==k&&total<n){
            return;
        }else if(alnum==k&&total==n){
            last.add(al);
        }
    }
}
