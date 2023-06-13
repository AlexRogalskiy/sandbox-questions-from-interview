package edu.sandbox.seabattlecountships;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

// You can start this example via JMH IDEA plugin
@Fork(1)
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class SeaBattleCountShipsSolutionsBenchmark {

    private int[][] matrix;

    @Setup
    public void setup() {
        matrix = new int[][]{
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0}
        };
    }

    /*
     * JMH Results:
     * Iteration   1: 33,723 ns/op - среднее время выполнения
     * Iteration   2: 33,815 ns/op
     * Iteration   3: 33,647 ns/op
     * Iteration   4: 33,714 ns/op
     * Iteration   5: 33,763 ns/op
     */
    @Benchmark
    public int seaBattleCountShipsSolution1Test() {
        return SeaBattleCountShipsSolution1.countShips(matrix);
    }

    /*
     * JMH Results:
     * Iteration   1: 418,086 ns/op
     * Iteration   2: 419,995 ns/op
     * Iteration   3: 418,102 ns/op
     * Iteration   4: 420,627 ns/op
     * Iteration   5: 419,199 ns/op
     */
    @Benchmark
    public int seaBattleCountShipsSolution2Test() {
        return SeaBattleCountShipsSolution2.countShips(matrix);
    }
}
