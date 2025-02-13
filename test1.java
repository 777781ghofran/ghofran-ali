public class test1 {
    public static void main(String[] args) {
        siglylinkedlis<Integer>l=new siglylinkedlis<>();
        System.out.println(l.isEmpty());
        System.out.println(l.size());
        l.addfirst(11);
        l.addlast(23);
        l.addlast(34);
        l.addfirst(34);
        while (!l.isEmpty())
        {
            System.out.println(l.removefirst()+"\t");


        }
    }
}
