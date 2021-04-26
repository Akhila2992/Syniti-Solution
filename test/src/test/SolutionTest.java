package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SolutionTest {

	@Test
		public void checkForDuplicates() {
			Record record1 = new Record("eac04","Strum","1522 lbanum ave","23294");
			Record record2 = new Record("bcc78","Strum","1522 lbanum ave","23294");
			List<Record> list = new ArrayList<Record>();
			list.add(record1);
			list.add(record2);
			List<Record> expectedRecords = new ArrayList<Record>();
			expectedRecords.add(record1);
			expectedRecords.add(record2);
			List<Record> actualRecords = Record.getDuplicates(list);
			assertEquals(expectedRecords,actualRecords);
		}
	
	@Test
	public void checkForNonDuplicates() {
		Record record1 = new Record("eac04","Strum","1522 lbanum ave","23294");
		Record record2 = new Record("bcc78",null,"1522 lbanum ave","23294");
		List<Record> list = new ArrayList<Record>();
		list.add(record1);
		list.add(record2);
		List<Record> expectedRecords = new ArrayList<Record>();
		List<Record> actualRecords = Record.getDuplicates(list);
		assertEquals(expectedRecords,actualRecords);
	}
	
	@Test
	public void checkForInvalidIds() {
		Record record1 = new Record("eac04","Strum","1522 lbanum ave","23294");
		Record record2 = new Record("bcc78",null,"1522 lbanum ave","23294");
		Record record3 = new Record("bcc78","Strum"," ","23294");
		List<Record> list = new ArrayList<Record>();
		list.add(record1);
		list.add(record2);
		list.add(record3);
		List<Record> expectedRecords = new ArrayList<Record>();
		expectedRecords.add(record2);
		expectedRecords.add(record3);
		List<Record> actualRecords = Record.findInvalidIds(list);
		assertEquals(expectedRecords,actualRecords);
	}
	
	@Test
	public void checkForValidIds() {
		Record record1 = new Record("eac04","Strum","1522 lbanum ave","23294");
		Record record2 = new Record("bcc78","Cece","1522 lbanum ave","23294");
		List<Record> list = new ArrayList<Record>();
		list.add(record1);
		list.add(record2);
		List<Record> expectedRecords = new ArrayList<Record>();
		List<Record> actualRecords = Record.findInvalidIds(list);
		assertEquals(expectedRecords,actualRecords);
	}
	
	@Test
	public void checkForInvalidZip() {
		Record record1 = new Record("eac04","Strum","1522 lbanum ave","23294");
		Record record2 = new Record("bcc78","Cece","1522 lbanum ave","23294");
		Record record3 = new Record("bcc78","Cece","1522 lbanum ave","232946");
		Record record4 = new Record("bcc78","Cece","1522 lbanum ave","223vsdf");
		List<Record> list = new ArrayList<Record>();
		list.add(record1);
		list.add(record2);
		list.add(record3);
		list.add(record4);
		List<Record> expectedRecords = new ArrayList<Record>();
		expectedRecords.add(record3);
		expectedRecords.add(record4);
		List<Record> actualRecords = Record.findInvalidIds(list);
		assertEquals(expectedRecords,actualRecords);
	}
}
