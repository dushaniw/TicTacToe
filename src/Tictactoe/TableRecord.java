/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tictactoe;

import java.util.ArrayList;

/**
 *
 * @author Uer
 */
public class TableRecord {
    
    ArrayList<Record> recordValues = new ArrayList<Record>();
	
	public void addRecord(Record recode){
		this.recordValues.add(recode);
	}
	public ArrayList<Record> getTableRecord(){
		return this.recordValues;
	}
    
}
