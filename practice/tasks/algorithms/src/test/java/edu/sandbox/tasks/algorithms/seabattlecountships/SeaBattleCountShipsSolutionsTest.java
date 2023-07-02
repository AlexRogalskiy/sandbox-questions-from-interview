package edu.sandbox.tasks.algorithms.seabattlecountships;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * Условие задачи:
 * Есть матрица размером NxN, состоящая из 0 и 1, отражающая расположение кораблей на поле морского боя.
 * Имеются следующие условия:
 * 1. Кораблей может быть любое количество
 * 2. Размер кораблей - от 1x1 до 1xN
 * 3. Корабли никак не соприкасаются друг с другом. (между ними должен быть 0)
 * 4. Корабли располагаются горизонтально и вертикально
 *
 * Необходимо подсчитать количество кораблей.
 * Пример, имеется матрица 6x6:
 *  {1, 1, 0, 0, 1, 0},
 *  {0, 0, 0, 0, 1, 0},
 *  {1, 0, 1, 0, 1, 0},
 *  {0, 0, 0, 0, 0, 0},
 *  {1, 0, 1, 1, 1, 1},
 *  {0, 0, 0, 0, 0, 0}
 *
 * Ответ в данном случае будет равен 6.
 */
class SeaBattleCountShipsSolutionsTest {

    /*
     * JMH Results:
     * Iteration   1: 33,723 ns/op - среднее время выполнения
     * Iteration   2: 33,815 ns/op
     * Iteration   3: 33,647 ns/op
     * Iteration   4: 33,714 ns/op
     * Iteration   5: 33,763 ns/op
     */
    @ParameterizedTest
    @ArgumentsSource(MatrixArgumentProvider.class)
    void seaBattleCountShipsSolution1Test(int[][] matrix, int expectedResult) {
        var actualResult = SeaBattleCountShipsSolution1.countShips(matrix);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    /*
     * JMH Results:
     * Iteration   1: 418,086 ns/op
     * Iteration   2: 419,995 ns/op
     * Iteration   3: 418,102 ns/op
     * Iteration   4: 420,627 ns/op
     * Iteration   5: 419,199 ns/op
     */
    @ParameterizedTest
    @ArgumentsSource(MatrixArgumentProvider.class)
    void seaBattleCountShipsSolution2Test(int[][] matrix, int expectedResult) {
        var actualResult = SeaBattleCountShipsSolution2.countShips(matrix);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
