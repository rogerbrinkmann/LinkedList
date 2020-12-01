public class Program {
    
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.toFirst();
        list.next();
        list.insert(5);

        listOutput(list);
        list.toLast();
        list.remove();
        listOutput(list);
    }

    public static void listOutput(LinkedList<Integer> list){
        list.toFirst();
        while(list.hasAccess()){
            System.out.println(list.current.getContent());
            list.next();
        }
    }
}
