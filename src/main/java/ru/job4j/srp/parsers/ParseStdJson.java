package ru.job4j.srp.parsers;

import ru.job4j.srp.Employee;
import ru.job4j.srp.parsers.Parse;

import java.util.List;
import java.util.StringJoiner;

public class ParseStdJson implements Parse {
    @Override
    public String parse(List<Employee> list) {
        StringJoiner sb = new StringJoiner(System.lineSeparator());
        for (Employee employee : list) {
            sb.add("{")
                    .add(String.format("\"name\": \"%s\",", employee.getName()))
                    .add(String.format("\"hired\": \"%s\",", employee.getHired()))
                    .add(String.format("\"fired\": \"%s\",", employee.getFired()))
                    .add(String.format("\"salary\": \"%s\"", employee.getSalary()))
                    .add("}");
        }
        return sb.toString();
    }
}
