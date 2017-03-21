package hello;

/**
 * Created by qianghao on 3/2/17.
 */

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Optional;
import java.util.PriorityQueue;

public class EmplyeePredicates {

    public static Predicate<Employee> isAdultMale() {
        return p -> p.getAge() > 21 && p.getGender().equalsIgnoreCase("M");
    }

    public static Predicate<Employee> isAdultFemale() {
        return p -> p.getAge() > 18 && p.getGender().equalsIgnoreCase("F");
    }

    public static Predicate<Employee> isAgeMoreThan(Integer age) {
        return p -> p.getAge() > age;
    }

    public static List<Employee> filterEmployees(List<Employee> employees, Predicate<Employee> predicate) {
        return employees.stream().filter(predicate).collect(Collectors.<Employee>toList());
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(1,23,"M","Rick","Beethovan");
        Employee e2 = new Employee(2,13,"F","Martina","Hengis");
        Employee e3 = new Employee(3,43,"M","Ricky","Martin");
        Employee e4 = new Employee(4,26,"M","Jon","Lowman");
        Employee e5 = new Employee(5,19,"F","Cristine","Maria");
        Employee e6 = new Employee(6,15,"M","David","Feezor");
        Employee e7 = new Employee(7,68,"F","Melissa","Roy");
        Employee e8 = new Employee(8,79,"M","Alex","Gussin");
        Employee e9 = new Employee(9,15,"F","Neetu","Singh");
        Employee e10 = new Employee(10,45,"M","Naveen","Jain");

        List<Employee> employees = new ArrayList<Employee>();
        employees.addAll(Arrays.asList(new Employee[]{e1,e2,e3,e4,e5,e6,e7,e8,e9,e10}));

        System.out.println(filterEmployees(employees, isAdultMale()));

        System.out.println(filterEmployees(employees, isAdultFemale()));

        System.out.println(filterEmployees(employees, isAgeMoreThan(35)));

        //Employees other than above collection of "isAgeMoreThan(35)" can be get using negate()
        System.out.println(filterEmployees(employees, isAgeMoreThan(35).negate()));

        long count = employees.stream().filter(p -> p.getAge()>35).count();
        System.out.println("Number of above 35 is:" + count);

        List<Integer> integers = Arrays.asList(1,22,13,4,15,6,17,8,19);
        IntSummaryStatistics stats = integers.stream().mapToInt((x) ->x).summaryStatistics();
        System.out.println("Highest number is :" + stats.getMax());
        System.out.println("Lowest number is :" + stats.getMin());
        System.out.println("Sum of all numbers is :" + stats.getSum());
        System.out.println("Average of all numbers is :" + stats.getAverage());

        Optional<String> longName = employees.stream().filter(p -> p.getAge()>35).sorted((o1,o2)->o1.getAge()-o2.getAge()).map(e -> e.getFirst().toUpperCase()).reduce((o1,o2) -> o1 + "#" + o2);
        System.out.println(longName.get());

        int sumresult = employees.stream().collect(Collectors.summingInt(Employee::getAge));
        System.out.println("Total Age: " + sumresult);

        employees.stream().min((o1,o2) -> o1.getAge() - o2.getAge()).ifPresent(System.out::println);

        /*
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Current DateTime : " + currentTime);

        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1:" + date1);


        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();

        System.out.println("Month: " + month +" day: " + day +"seconds: " + seconds);

        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);

        //12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3: " + date3);

        //22 hour 15 minutes
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);

        //parse a string
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);
        */

        PriorityQueue<Employee> empqueue = new PriorityQueue<>(10, (o1, o2) -> o1.getAge() - o2.getAge());
        for(Employee e : employees)
            empqueue.add(e);
        while (!empqueue.isEmpty())
            System.out.println(empqueue.poll());
        }
    }
