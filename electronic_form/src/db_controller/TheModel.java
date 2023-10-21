/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_controller;


import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 1bestcsharp.blogspot.com
 */
public class TheModel extends AbstractTableModel {

    private String[] columns;
    private Object[][] rows;

    public TheModel() {
    }

    public TheModel(Object[][] data, String[] columnName) {
        this.rows = data;
        this.columns = columnName;
    }


    public int getRowCount() {
        return this.rows.length;
    }

    public int getColumnCount() {
        return this.columns.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.rows[rowIndex][columnIndex];
    }

    public String getColumnName(int col) {
        return this.columns[col];
    }
}
