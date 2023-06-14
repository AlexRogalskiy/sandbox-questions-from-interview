package edu.sandbox.seabattlecountships;

public class SeaBattleCountShipsSolution1 {

    private static final int CELL_WITH_SHIP_OR_PART = 1;
    private static final int EMPTY_CELL = 0;

    /*
     * Данное решение заключается в следующем:
     * 1. Проходим построчно матрицу
     * 2. Находим значение равное 1 т.е. CELL_WITH_SHIP_OR_PART, что означает есть либо целый корабль либо его часть
     * 3. Увеличиваем счетчик на 1
     * 4. Устанавливаем флаг isShipPartStarted в true (чтобы если мы встретим следующую единицу мы не увеличивали счетчик)
     * 5. Если встретили 0, устанавливаем isShipPartStarted в false (означает что мы готовы искать следующие корабли)
     *
     * Переходим на следующую строку, нужно учитывать вертикальное расположение кораблей:
     * 1. Сбрасываем isShipPartStarted флаг в false, чтобы начать заново учитывать расположение по горизонтали
     * 2. Если встретили CELL_WITH_SHIP_OR_PART проверяем значение ячейки в предыдущей строке, если там тоже CELL_WITH_SHIP_OR_PART, то не увеличиваем счетчик
     *    потому что мы учли его в предыдущей итерации и это часть одного корабля.
     * 3. Иначе увеличиваем счетчик и идем построчно по всей матрице с таким же алгоритмом.
     *
     *              columnIndex
     *              |
     * rowIndex -- {1, 1, 0, 0, 1, 0},
     *             {0, 0, 0, 0, 1, 0}, -- отсюда мы будем начинать проверять есть ли у соседней верхней ячейки значение 1 или 0, чтобы учесть вертикальную расстановку
     *             {1, 0, 1, 0, 1, 0},
     *             {0, 0, 0, 0, 0, 0},
     *             {1, 0, 1, 1, 1, 1},
     *             {0, 0, 0, 0, 0, 0}
     */
    public static int countShips(int[][] matrix) {
        int amountOfShips = 0;
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            boolean isShipPartStarted = false; // сбрасываем для того чтобы если предыдущая строка закончилась на 1, мы не думали что на следующей строке это продолжение коробля
            for (int columnIndex = 0; columnIndex < matrix.length; columnIndex++) {
                int cellValue = matrix[rowIndex][columnIndex]; // получаем значение текущей ячейки
                int higherCellValue = -1;
                if (rowIndex != 0) { // чтобы не проверять верхнюю ячейку на первой строке
                    higherCellValue = matrix[rowIndex - 1][columnIndex]; // получаем значение ячейки выше, в той же колонке, чтобы понять является ли текущая ячейка частью коробля выше
                }
                // если у нас ячейка равна единице и она не является следующей частью корабля не по горизонтали не повертикали
                if (cellValue == CELL_WITH_SHIP_OR_PART && !isShipPartStarted && higherCellValue != CELL_WITH_SHIP_OR_PART) {
                    // увеличиваем счетчик на 1 и устанавливаем флаг что мы нашли корабль
                    amountOfShips++;
                    isShipPartStarted = true;
                } else if (cellValue == EMPTY_CELL) { // если встретили 0, значит корабля либо нет, либо он закончился
                    isShipPartStarted = false;
                }
            }
        }
        return amountOfShips;
    }
}
