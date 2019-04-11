
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * Class used to load and parse my csv file
 * @author Avatar LeFevre
 * MCIT 591
 * Assignment Five
 * FlightsReaders class
 */

public class FlightsReaders {
	// hard coded flights data
	public static final String fileName = "flights_small.csv";
	
	
	public FlightsReaders() {
		
	}
	// method used to read in all needed values
	public Flights getDataFromLine(String line) {
		String[] values = line.split(",");
		Integer dom = Integer.parseInt(values[0]);
		Integer dow = Integer.parseInt(values[1]);
		LocalDate fd = parseDate(values[2]);
		String uc = values[3];
		String tn = values[4];
		Integer oapid = Integer.parseInt(values[5]);
		String o = values[6];
		String osn = values[7];
		Integer dapid = Integer.parseInt(values[8]);
		String dest = values[9];
		String destSN = values[10];
		Integer depT = !isEmpty(values[11]) ? Integer.parseInt(values[11]) : null;
		Integer depD = !isEmpty(values[12]) ? Integer.parseInt(values[12]) : null;
		Integer woff = !isEmpty(values[13]) ? Integer.parseInt(values[13]) : null;
		Integer won = !isEmpty(values[14]) ? Integer.parseInt(values[14]) : null;
		Integer arrT = !isEmpty(values[15]) ? Integer.parseInt(values[15]) : null;
		Integer arrD = !isEmpty(values[16]) ? Integer.parseInt(values[16]) : null;
		Boolean can = Integer.parseInt(values[17]) == 1 ? Boolean.TRUE : Boolean.FALSE;
		String cc = !isEmpty(values[18]) ? values[18]: null;
		Boolean div = Integer.parseInt(values[19]) == 1 ? Boolean.TRUE : Boolean.FALSE;
		Integer airT = !isEmpty(values[20]) ? Integer.parseInt(values[20]) : null;
		Integer dist = Integer.parseInt(values[21]);
		
		return new Flights(dom, dow, fd, uc, tn, oapid, o, osn, dapid, dest, destSN, depT, depD, woff, won, arrT, arrD, can, cc, div, airT, dist);
	}
	
	public static boolean isEmpty(String value) {
		return value == null || value.isEmpty();
	}
	
	public static LocalDate parseDate(String value) {
		String[] values = value.split("/");
		return LocalDate.of(Integer.parseInt(values[2]), Integer.parseInt(values[0]), Integer.parseInt(values[1]));
	}
	
	public ArrayList<Flights> loadFltData(String fileName) {
		ArrayList<Flights> listOfFlights = new ArrayList<>();
		File f  = new File(fileName);
		Scanner sc;
		try {
			sc = new Scanner(f);
			sc.nextLine();
			while(sc.hasNextLine()) {
				String rowData = sc.nextLine();
				Flights values = getDataFromLine(rowData);
				listOfFlights.add(values);
				
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfFlights;
	}
	
	public static void main(String[] args) {

	}


}
