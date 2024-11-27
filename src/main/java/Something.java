import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Something {

    public static int counter = 1;
    static {
        counter = 5;
    }
    public static void main(String[] args) {
        System.out.println(counter);


        // reverseInteger(123);

        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Chloe", 25),
                new Person("Jack", 30),
                new Person("Alan", 44)
        );
        Map<Integer, List<Person>> map = people.stream()
                .collect(Collectors.groupingBy(Person::getAge));
        map.forEach((age, peopleList) ->
                System.out.println("Age " + age + ", peopleList " + peopleList)
        );


        List<Sale> sales = Arrays.asList(
                new Sale("TV", 29),
                new Sale("Phone", 45),
                new Sale("TV", 30)
        );

        Map<String, Integer> mapSales = sales.stream()
                .collect(Collectors.groupingBy((Sale::getProduct),
                        Collectors.summingInt(Sale::getQuantity)));
        mapSales.forEach((product, quantity) ->
                System.out.println("Product " + product + " quantity " + quantity));


        List<String> nameAndSurnameList = Arrays.asList("Anna Kovaleva", "Alex Grachev");
        List<String> formatedList =
                nameAndSurnameList.stream().map(
                                name -> {
                                    String[] parts = name.split(" ");
                                    return parts[1] + ", " + parts[0];
                                })
                        .collect(Collectors.toList());

        formatedList.forEach(System.out::println);


        List<String> products = Arrays.asList(
                "TV:1000",
                "Phone:800"
        );

        List<ProductInfo> formattedToObject = products.stream().map(product ->{
                    String[] parts = product.split(":");
                    return new ProductInfo(parts[0], Integer.parseInt(parts[1]));
                })
                .collect(Collectors.toList());
        formattedToObject.forEach(System.out::println);

        int sumOfAllProductPrices = formattedToObject.stream()
                .map(x -> x.getPrice()).mapToInt(Integer::intValue).sum();
        System.out.println(sumOfAllProductPrices);

        formattedToObject.stream()
                .collect(Collectors.summingInt(x->x.getPrice()));


        List<Integer> list = Arrays.asList(2,1,2,4,6,7);
        list.stream().filter(x->x%2==0).map(x->x*2).forEach(System.out::println);

      //  Дан список строк. Найдите первую строку, которая начинается с буквы "A"
        //  и имеет длину больше 3 символов.

        List<String> listStr = Arrays.asList("Ad", "vsdv", "afdv");
        Optional<String> opt = listStr.stream().filter(x->x.length()>3).filter(x->x.startsWith("A")).findFirst();
        System.out.println(opt);


    }
}