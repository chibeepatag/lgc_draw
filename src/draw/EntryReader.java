/**
 * 
 */
package draw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Branch;
import model.Entry;
import model.Prize;

/**
 * @author ChibeePatag
 *
 */
public class EntryReader {

	public Map<Branch, List<Entry>> read_entries(String filename) {
		Map<Branch, List<Entry>> entries = new HashMap<Branch, List<Entry>>();
		File csvFile = new File(filename);
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(csvFile));
			String sCurrentLine;
			reader.readLine(); // read header
			while ((sCurrentLine = reader.readLine()) != null) {				
				String[] lineArray = sCurrentLine.split(",");
				if(lineArray[6].trim().length() > 0){
					Entry entry = new Entry(lineArray);
					List<Entry> branch_entry = entries.get(entry.getBranch());
					if(null == branch_entry){
						branch_entry = new ArrayList<Entry>();
						branch_entry.add(entry);
						entries.put(entry.getBranch(), branch_entry);
					}else{
						branch_entry.add(entry);
					}
				}				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}finally{
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		}
		
		
		return entries;
	}
	
	public Map<String, List<Prize>> getPrizes(String prizeFileName){
		Map<String, List<Prize>> prizes = new HashMap<String, List<Prize>>();
		prizes.put("All", new ArrayList<Prize>());
		prizes.put("Store", new ArrayList<Prize>());
		File prizeFile = new File(prizeFileName);
		
		BufferedReader reader = null;		
		
		try {
			reader = new BufferedReader(new FileReader(prizeFile));
			String sCurrentLine;
			reader.readLine(); // read header
			while ((sCurrentLine = reader.readLine()) != null) {				
				String[] lineArray = sCurrentLine.split(",");				
				Prize prize = new Prize(lineArray[0], lineArray[1], Integer.parseInt(lineArray[2]));
				prizes.get(prize.getPrize_level()).add(prize);			
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}finally{
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		}
		
		return prizes;
	}

}
