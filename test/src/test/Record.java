package test;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Record {
	
	private String id;
	private String name;
	private String address; 
	private String zip;
	private boolean isInvalid = Boolean.FALSE;
	
	public Record() {
		
	}
	
	public Record(String id, String name, String address, String zip) {
		this.id = id;
		this.setName(name);
		this.setAddress(address);
		this.setZip(zip);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		if(null == this.name || this.name.isBlank()) {
			this.isInvalid = true;
		}
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
		if(null == this.address || this.address.isBlank()) {
			this.isInvalid = true;
		}
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
		if(null == this.zip ||this.zip.length() != 5 || !RecordHelper.isNumeric(this.zip)) {
			this.isInvalid = true;
		}
	} 
	
	public boolean isInvalid() {
		return isInvalid;
	}
	public void setInvalid(boolean isInvalid) {
		this.isInvalid = isInvalid;
	}
	
	public String uniqueAttributes() {
		  return name+address+zip;
	}
	
	public static List<Record> getDuplicates(final List<Record> recordList) {
		  return getDuplicatesMap(recordList).values().stream()
		      .filter(duplicates -> duplicates.size() > 1)
		      .flatMap(Collection::stream)
		      .collect(Collectors.toList());
		}

		private static Map<String, List<Record>> getDuplicatesMap(List<Record> recordList) {
		  return recordList.stream().collect(Collectors.groupingBy(Record::uniqueAttributes));
		}

		public static List<Record> findInvalidIds(Collection<Record> baseCollection) {
		    Predicate<Record> streamsPredicate = record -> record.isInvalid(); 

		    return baseCollection.stream()
		      .filter(streamsPredicate)
		      .collect(Collectors.toList());
		}
}
