package edu.sandbox.tasks.algorithms.methoddependencies;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.StringJoiner;

// TODO: refactor solution, add comments and unit tests
/*
 * Дано N различных имен фунцкий, i-я функция зависит от функция name(1), name(2) ... name(k)
 * Выведите через пробел функции в таком порядке, чтобы каждая функция шла после всех функций, от которых она зависит.
 * Если решений несколько, выведите любое. Гарантируется, что для заданных входных данных сущетсвует хотя бы одно решение.
 *
 * Пример:
 * Ввод:
 * 3
 * main 2 foo baz
 * baz 0
 * foo 0
 *
 * Вывод:
 * baz foo main
 * ------------
 * Ввод:
 * 5
 * main 1 foo
 * foo 2 baz bar
 * baz 0
 * bar 1 brr
 * brr 0
 *
 * Вывод:
 * brr bar baz foo main
 *
 * Ограничение по времени - 1 с
 * Ограничение по памяти - 256 мб
 */
public class MethodDependenciesSolution1 {

    private static class Method {

        private String name;
        private List<Method> dependencies = new ArrayList<>();
        private boolean visited;

        public Method(String name) {
            this.name = name;
        }

        public void addDependency(Method dependency) {
            dependencies.add(dependency);
        }
    }

    public static void main(String[] args) throws IOException {
        var methods = new HashMap<String, Method>();

        try (var reader = new BufferedReader(new FileReader("input.txt"))) {

            var totalMethodsCount = Long.parseLong(reader.readLine());
            for (long methodIndex = 0; methodIndex < totalMethodsCount; methodIndex++) {

                var line = reader.readLine();
                var methodParts = line.split(" ");
                var methodName = methodParts[0];
                var methodDependenciesCount = Integer.parseInt(methodParts[1]);

                var method = methods.getOrDefault(methodName, new Method(methodName));
                for (int methodDependencyIndex = 0; methodDependencyIndex < methodDependenciesCount; methodDependencyIndex++) {
                    var methodDependencyName = methodParts[2 + methodDependencyIndex];
                    var methodDependency = methods.getOrDefault(methodDependencyName, new Method(methodDependencyName));
                    methods.put(methodDependencyName, methodDependency);

                    method.addDependency(methodDependency);
                }
                methods.put(methodName, method);
            }

        }

        var joiner = new StringJoiner(" ");
        join(methods.values(), joiner);

        System.out.println(joiner);
    }

    private static void join(Collection<Method> methods, StringJoiner joiner) {
        for (var method : methods) {
            if (!method.visited) {
                join(method, joiner);
            }
        }
    }

    private static void join(Method method, StringJoiner joiner) {
        method.visited = true;

        for (var dependency : method.dependencies) {
            if (!dependency.visited) {
                join(dependency, joiner);
            }
        }

        joiner.add(method.name);
    }
}
