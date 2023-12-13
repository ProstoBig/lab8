package lab8;

class StorageCellException extends Exception {
    public StorageCellException(String s) {
        super(s);
    }
}
class StorageCell {
    private int x;
    private int y;
    private Object items;

    public StorageCell(int x, int y) {
        this.x = x;
        this.y = y;
        this.items = null;
    }

    public void storeItem(Object item) throws StorageCellException {
        if (this.items != null) {
            throw new StorageCellException("Ця комірка вже зайнята.");
        }
        this.items = item;
        System.out.println("Предмет " + item + " у комірці " + this.x + "-" + this.y + ".");
    }
}
class StorageCamera {
    private int rows;
    private int columns;
    private StorageCell[][] cells;

    public StorageCamera(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.cells = new StorageCell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.cells[i][j] = new StorageCell(i + 1, j + 1);
            }
        }
    }

    public void storeItem(int row, int column, Object item) throws StorageCellException {
        if (!(1 <= row && row <= this.rows) || !(1 <= column && column <= this.columns)) {
            throw new StorageCellException("Некоректні координати комірки.");
        }
        this.cells[row - 1][column - 1].storeItem(item);
    }
}