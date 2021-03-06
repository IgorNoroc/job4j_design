package ru.job4j.srp.parsers.hr;

import ru.job4j.srp.Employee;
import ru.job4j.srp.parsers.Parse;

import java.util.List;
import java.util.StringJoiner;

public class HrXml implements Parse {
    @Override
    public String parse(List<Employee> list) {
        StringJoiner sb = new StringJoiner(System.lineSeparator());
        sb.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
                .add("<employees>");
        list.sort((o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary()));
        for (Employee employee : list) {
            sb.add("<employee>")
                    .add(String.format("<name>%s</name>", employee.getName()))
                    .add(String.format("<salary>%s</salary>", employee.getSalary()));
        }
        sb.add("</employee>");
        return sb.toString();
    }
}
