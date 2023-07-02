package edu.sandbox.tasks.projectreactor;

import lombok.Data;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Random;

// TODO: solve this task
/*
 * Eсть сущность Огурец, имеет поля:
 * 1. Размер
 *
 * Есть сущность Банка, имеет поля:
 * 1. Лист огурцов (находищяеся огурцы в банке)
 * 2. Максимальный объем банки (сколько всего помещается огурцов)
 *
 * Необходимо написать метод, который на вход принимает Flux огурцов и возвращает Flux банок.
 * Данный метод должно сгруппировать огурцы по банкам
 *
 * Примечание:
 * 1. если цельный огурец не влазит в банку, отрезать от огурца столько, сколько сможет поместиться в эту банку
 */
public class BoxesWithCucumbersSolution1 {

    @Data
    class Cucumber {
        private int size;

        public Cucumber() {
            this.size = new Random().nextInt(20, 50);
        }
    }

    @Data
    class Box {
        private int capacity;
        private List<Cucumber> cucumbers;

        public Box() {
            this.capacity = new Random().nextInt(20, 50);
        }
    }

    public static void main(String[] args) {
    }

    private Flux<Box> transform(Flux<Cucumber> cucumbersFlux) {
        return null;
    }
}