package test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Solution{
	
	//Read the entries from the json file
	public List<Record> readJson() {
		try {
			ObjectMapper objMapper = new ObjectMapper();
			Record[] dataRecords = objMapper.readValue(new File("src/test/data.json"), Record[].class);
			return Arrays.asList(dataRecords);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public void printInvalidRecords(List<Record> printIds) {
		for(Record record : printIds)
			System.out.println(record.getId());
	}
	
	public static void main(String args[]) {
		
		Solution solution = new Solution();
		List<Record> records= solution.readJson();
		List<Record> invalidIds =  new ArrayList<Record>();
		if(!records.isEmpty()) {
			List<Record> duplicates = Record.getDuplicates(records);
			List<Record> inIds = Record.findInvalidIds(records);
			invalidIds.addAll(duplicates);
			invalidIds.addAll(inIds);
		}
		solution.printInvalidRecords(invalidIds);
	}
	
}