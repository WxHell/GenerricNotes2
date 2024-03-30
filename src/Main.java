import java.util.ArrayList;
import java.util.List;
record Employee(String name) implements QueryItem{

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        return false;
    }
}
public class Main {
    public static void main(String[] args) {
        int studentCount=10;
        List<Student>students=new ArrayList<>();
        for (int i = 0;i<studentCount;i++){
            students.add(new Student());
        }
//        printList(students);
        printMoreList(students);

        List<Student2>student2=new ArrayList<>();
        for (int i = 0;i<studentCount;i++){
            student2.add(new Student2());
        }
//        printList(student2);
        printMoreList(student2);

        testList(new ArrayList<String>(List.of("Able","Barry","Charlie")));
        testList(new ArrayList<Integer>(List.of(1,2,3,4)));

        var queryList = new QueryList<>(student2);
        var matches = queryList.getMatches("Course","Python");
        printMoreList(matches);

        var students2021 = QueryList.getMatches(students,"YearStarted","2021");//Bu static ymntem
        //her zaman liste döndürür.ancak eşleşen yok ise boş döndürür.
        printMoreList(students2021);
       // QueryList<Employee> employeeList=new QueryList<>();
        // bir türün geçerli bir tür olması için tüm koşulları karşılaması gerekir.Bu employeenin Studentın bir alt
        //türü olmadığı dolayısıyla QueryList için geçerli bir tür bağımsız değişkeni olmadığı anlamında gelir.
    }

    public static void printMoreList(List<? extends Student> students) {

        for (var student : students) {
            System.out.println(student);
        }
        System.out.println();
    }

    public static void testList(List<?> list){
        for (var element : list){
            if (element instanceof String s){
                System.out.println("Strings: "+s.toUpperCase());
            }else if (element instanceof Integer i){
                System.out.println("Integer: "+i.floatValue());
            }
        }
    }
//    public static void textList(List<String> list){
//        for (var element:list){
//            System.out.println("String: "+element.toUpperCase());
//        }
//    }
//    public static void textList(List<Integer> list){
//        for (var element:list){
//            System.out.println("String: "+element.floatValue());
//        }
//    }

//    public static <T extends Student> void printList(List<T> students) {
//        for (var student : students) {
//            System.out.println(student.getYearStarted() + ": " + student);
//        }
//        System.out.println();
//    }
}
