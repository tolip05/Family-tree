package com.company.family.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String namePerson = br.readLine();

        List<Person>persons = new ArrayList<>();
        List<String>relationsheap = new ArrayList<>();
        String input = br.readLine();

        while (!input.equals("End")){
            if (!input.contains("-")){
                addMembers(input,persons);
                input = br.readLine();
                continue;
            }else {
                relationsheap.add(input);
            }
            input= br.readLine();
        }
        for (String s : relationsheap) {
            String[] inputArg = s.split(" - ");

            Person parent = getPerson(inputArg[0],persons);
            Person chield = getPerson(inputArg[1],persons);
            if (!parent.getChildren().contains(chield)){
                parent.getChildren().add(chield);
            }
            if (!chield.getParents().contains(parent)){
                chield.getParents().add(parent);
            }
        }
        prints(namePerson,persons);
    }

    private static void prints(String namePerson, List<Person> persons) {
        Person person = getPerson(namePerson,persons);
        System.out.println(String.format("%s %s",person.getName(),person.getBirthDay()));
        System.out.println("Parents:");
        for (Person p : person.getParents()) {
            System.out.println(String.format("%s %s",p.getName(),p.getBirthDay()));
        }
        System.out.println("Children:");
        for (Person pe : person.getChildren()) {
            System.out.println(String.format("%s %s",pe.getName(),pe.getBirthDay()));
        }
    }

    private static Person getPerson(String input, List<Person> persons) {
        if (input.contains("/")){
            return persons.stream().filter(a-> a.getBirthDay().equals(input))
                    .findFirst().orElse(null);
        }else{
            return persons.stream().filter(s-> s.getName()
                    .equals(input)).findFirst().orElse(null);
        }
    }


    private static void addMembers(String input, List<Person> persons) {
        String[]inputArgs = input.split(" ");
        String name = inputArgs[0] + " " + inputArgs[1];
        String birthday = inputArgs[2];
        Person person = new Person(name,birthday);
        persons.add(person);
    }
}
