import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            int i=0;
            Good2[]data=new Good2[10005];
            String tem=scan.nextLine();
            while(tem.contains("*")==false){
                data[i]=new Good2();
                data[i].str=tem;
                tem=scan.nextLine();
                i++;
            }
            Arrays.sort(data,0,i);
            String last=tem;
            if(get(last,data)==false){
                System.out.println(0);
            }
        }
    }
    public static boolean get(String last,Good2[]data){
        String[]tem=last.split("\\.");
        boolean flag=true;
        for(int i=0;i<data.length;i++){
            flag=true;
            String[]pi=data[i].str.split("\\.");
            for(int j=0;j<3;j++){
                if(tem[j].equals("*")==false){
                    if(tem[j].equals(pi[j])){

                    }else{
                        flag=false;
                        break;
                    }
                }
            }
            if(flag==true){
                System.out.println(data[i].str);
                return flag;
            }
        }
        return flag;
    }
}

class Good2 implements Comparable<Good2>{
    String str;

    @Override
    public int compareTo(Good2 o) {

        String[]thisstr=this.str.split("\\.");
        String[]ostr=o.str.split("\\.");
        if(thisstr[0].compareTo(ostr[0])<0){
            return 1;
        }else if((thisstr[0].compareTo(ostr[0])>0)){
            return -1;
        }
        else{
            if(thisstr[1].compareTo(ostr[1])<0){
                return 1;
            }else if((thisstr[1].compareTo(ostr[1])>0)){
                return -1;
            }else{
                if(thisstr[2].compareTo(ostr[2])<0){
                    return 1;
                }else if((thisstr[2].compareTo(ostr[2])>0)){
                    return -1;
                }else{
                    return 0;
                }
            }
        }
    }

    @Override
    public java.lang.String toString() {
        return "Good2{" +
                "str=" + str +
                '}';
    }
}
