package edu.sandbox.seabattlecountships;

public class SeaBattleCountShipsSolution2 {

    private static class Cell {
        private int value;
        private boolean checked = false;

        public Cell(int value) {
            this.value = value;
            if (value == 0) {
                this.checked = true;
            }
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }
    }

    /*
     * Данное решение заключается в следующем:
     * 1. Из матрицы чисел создаем матрицу объектов, с полями для значения колонки и флагом была ли колонка проверена
     * 2. Нули можно поставить сразу же в checked = true, потому что они не будут означать начало корабля
     * 3. После чего прохождение будет по всей матрице
     * 4. Как только мы нашли 1 и она не checked, означает что мы нашли корабль
     * 5. Начинаем учитывать горизонтальное и вертикальное положение. Проходимся циклом по горизонтали и вертикали
     * 6. Если нашли 1 то устанавливает ее в checked, чтобы она не была учитана для других кораблей.
     *
     *              columnIndex
     *              |
     * rowIndex -- {1, 1, 0, 0, 1, 0},
     *             {0, 0, 0, 0, 1, 0},
     *             {1, 0, 1, 0, 1, 0},
     *             {0, 0, 0, 0, 0, 0},
     *             {1, 0, 1, 1, 1, 1},
     *             {0, 0, 0, 0, 0, 0}
     */
    public static int countShips(int[][] matrix) {
        Cell[][] checkedMatrix = new Cell[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                checkedMatrix[i][j] = new Cell(matrix[i][j]);
            }
        }

        int amountOfShips = 0;
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrix.length; columnIndex++) {

                Cell cell = checkedMatrix[rowIndex][columnIndex];
                if (cell.value == 1 && !cell.checked) {
                    amountOfShips++;
                    for (int verticalIndex = rowIndex + 1; verticalIndex < matrix.length; verticalIndex++) {
                        var verticalCell = checkedMatrix[verticalIndex][columnIndex];
                        if (verticalCell.value == 1) {
                            verticalCell.checked = true;
                        } else {
                            break;
                        }
                    }

                    for (int horizontalIndex = columnIndex; horizontalIndex < matrix.length; horizontalIndex++) {
                        var horizontalCell = checkedMatrix[rowIndex][horizontalIndex];
                        if (horizontalCell.value == 1) {
                            horizontalCell.checked = true;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        return amountOfShips;
    }
}
