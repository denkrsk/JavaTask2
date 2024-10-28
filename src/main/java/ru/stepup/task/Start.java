package ru.stepup.task;

//import ru.stepup.payments.mobile.Student;


import java.util.*;
import java.util.stream.Collectors;

public class Start {
    public static void main(String[] args) {
//       Реализуйте удаление из листа всех дубликатов
        List<String> listDubl = new ArrayList<>(Arrays.asList("Иванов", "Петров", "Скворцов", "Иванов"));
//        System.out.println(listDubl);
        Set<String> set = new LinkedHashSet<>(listDubl);
        List<String> listNoDubl = new ArrayList<>(set);
        System.out.println(listNoDubl);
//        Найдите в списке целых чисел 3-е наибольшее число (пример: 5 2 10 9 4 3 10 1 13 => 10)
        List<Integer> listInt = new ArrayList<>(Arrays.asList(5, 2, 10, 9, 4, 3, 10, 1, 13));
        listInt.sort(Comparator.reverseOrder());
        System.out.println(listInt.get(2));
//        Найдите в списке целых чисел 3-е наибольшее «уникальное» число (пример: 5 2 10 9 4 3 10 1 13 => 9, в отличие от прошлой задачи здесь разные 10 считает за одно число)
        Set<Integer> setInt = new LinkedHashSet<>(listInt);
        listInt = new ArrayList<>(setInt);
        listInt.sort(Comparator.reverseOrder());
        System.out.println(listInt.get(2));
//        Имеется список объектов типа Сотрудник (имя, возраст, должность), необходимо получить список имен 3 самых старших сотрудников с должностью «Инженер», в порядке убывания возраста
        Sotrudnik sotr1 = new Sotrudnik("Иванов", 35, "Инженер");
        Sotrudnik sotr2 = new Sotrudnik("Петров", 23, "Тестировщик");
        Sotrudnik sotr3 = new Sotrudnik("Сидоров", 33, "Инженер");
        Sotrudnik sotr4 = new Sotrudnik("Путин", 41, "Инженер");
        Sotrudnik sotr5 = new Sotrudnik("Медведев", 31, "Инженер");
        Sotrudnik sotr6 = new Sotrudnik("Лукашенко", 55, "Инженер");
        List<Sotrudnik> sotrudnikList = Arrays.asList(sotr1, sotr2, sotr3, sotr4, sotr5, sotr6);
        System.out.println(sotrudnikList.toString());
        List<Sotrudnik> sotrudnikList1 = sotrudnikList.stream().filter(p->p.getWorkPosition().equals("Инженер"))
                .sorted(Comparator.comparing(Sotrudnik::getAge).reversed())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(sotrudnikList1.toString());
//         Имеется список объектов типа Сотрудник (имя, возраст, должность), посчитайте средний возраст сотрудников с должностью «Инженер»
        OptionalDouble averAge = sotrudnikList.stream().filter(p->p.getWorkPosition().equals("Инженер"))
                .mapToDouble(a -> a.getAge()).average();
        System.out.println(averAge);
//        Найдите в списке слов самое длинное
        listDubl.sort(Comparator.comparing(String::length, Comparator.reverseOrder()));
        System.out.println(listDubl.get(0));
//        Имеется строка с набором слов в нижнем регистре, разделенных пробелом. Постройте хеш-мапы, в которой будут хранится пары: слово - сколько раз оно встречается во входной строке
        String string = "строка с набором слов в нижнем регистре разделенных пробелом постройте хеш мапы в которой будут хранится пары слово сколько раз оно встречается во входной строке";
        HashMap<String, Integer> hashMap = new HashMap<>();
        Arrays.stream(string.split(" ")).forEach(str->hashMap.put(str, (int) Arrays.stream(string.split(" ")).filter(p->p.equals(str)).count()));
        System.out.println(hashMap.toString());
//         Отпечатайте в консоль строки из списка в порядке увеличения длины слова, если слова имеют одинаковую длины, то должен быть сохранен алфавитный порядок
        List<String> stringList = new ArrayList<>(List.of(string.split(" ")));
        stringList.sort(Comparator.comparing(String::length).thenComparing(String::compareTo));
        System.out.println(stringList);
//        Имеется массив строк, в каждой из которых лежит набор из 5 строк, разделенных пробелом, найдите среди всех слов самое длинное, если таких слов несколько, получите любое из них
        String[] strings = {"dsvds vrver verre", "wfwgergerger rgfreg rgeer", "reg"};
        String wordMax = "";
//        for(String str: strings){
//            String[] words = str.split(" ");

//            Arrays.sort(words, Comparator.comparing(String::length, Comparator.reverseOrder()));
//            wordMax = words[0].length() > wordMax.length() ? words[0] : wordMax;
//        }
//        System.out.println(wordMax);
        wordMax = String.valueOf(Arrays.stream(Arrays.stream(strings).collect(Collectors.joining(" ")).split(" ")).max(Comparator.comparing(String::length)));
//        System.out.println(String.join(" ", strings));
        System.out.println(wordMax);
    }
}
