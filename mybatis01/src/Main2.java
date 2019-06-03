import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            String str=scan.nextLine();
            int m=Integer.valueOf(str.split(" ")[0]);
            int n=Integer.valueOf(str.split(" ")[1]);
            Good[]data=new Good[m];
            for(int i=0;i<m;i++){
                data[i]=new Good();
                String tem=scan.nextLine();
                String[]h=tem.split(" ");
                data[i].former=h[0];
                if(h[1].equals("*")==false){
                    data[i].be=data[i].be+h[1];
                }
                if(h[2].equals("*")==false){
                    data[i].be=data[i].be+h[2];
                }
            }
            get(data,m,n);
        }
    }
    public static void get(Good[]data,int m,int n){
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(i!=j){
                    if(data[i].be.contains(data[j].former)){
                        data[i].be+=data[j].be;
                    }
                }
            }
        }
        String ans="";
        for(int i=0;i<m;i++){
            Set<Character> set=new HashSet<>();
            for(int j=0;j<data[i].be.length();j++){
                set.add(data[i].be.charAt(j));
            }
            if(set.size()>=n){
                ans+=data[i].former;
            }
        }
        if(ans.length()==0){
            System.out.println("None");
        }else{
            System.out.print(ans.charAt(0));
            for(int i=1;i<ans.length();i++){
                System.out.print(" "+ans.charAt(i));
            }
            System.out.println();
        }
    }
}
class Good{
    String former;
    String be="";
}
