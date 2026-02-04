class Calculatearea{
    int a=0;
    public void a(int l,int b){
        a=l*b;
        System.out.println("Area of rectangle "+a);
    }
    public void a(int s){
        a=s*s;
        System.out.println("Area of square "+a);
    }
}
public class Exp02 {
    public static void main(String[] args){
        Calculatearea cal=new Calculatearea();
        cal.a(2,3);
        cal.a(2);
    }
}