package implement;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalculateDividends {

	public static void main(String[] args) throws Exception {  

		try {
			Map<String, Integer> winMap = new HashMap<>();
			Map<String, Integer> placeMap = new HashMap<>();
			Map<String, Integer> exactaMap = new HashMap<>();
			int winSum = 0, placeSum = 0, exactaSum = 0;

			Scanner sc = new Scanner(System.in);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();	          
				String[] arr = line.split(":");
				if(arr[0].equals("Bet")) {
					switch(arr[1]) {
					case "W": // WIN 
						if(winMap.containsKey(arr[2])) {
							winMap.put(arr[2], winMap.get(arr[2]) + Integer.valueOf(arr[3]));
						} else {
							winMap.put(arr[2], Integer.valueOf(arr[3]));
						}

						winSum += Integer.valueOf(arr[3]);
						break;
					case "P": // PLACE
						if(placeMap.containsKey(arr[2])) {
							placeMap.put(arr[2], placeMap.get(arr[2]) + Integer.valueOf(arr[3]));
						} else {
							placeMap.put(arr[2], Integer.valueOf(arr[3]));
						}

						placeSum += Integer.valueOf(arr[3]);
						break;
					case "E": // EXACTA
						if(exactaMap.containsKey(arr[2])) {
							exactaMap.put(arr[2], exactaMap.get(arr[2]) + Integer.valueOf(arr[3]));
						} else {
							exactaMap.put(arr[2], Integer.valueOf(arr[3]));
						}

						exactaSum += Integer.valueOf(arr[3]);
						break;
					default:
						throw new Exception("invalid product, not one of Win, Place, Exacta");
					}
				} else if(arr[0].equals("Result")) {					
					// calculate the WIN product
					if(!winMap.isEmpty() && winSum != 0) {
						double winPool = (double)winSum * 0.85;
						
						double winDividend = winMap.containsKey(arr[1]) && winMap.get(arr[1]) != 0 ?
								winPool / (double)winMap.get(arr[1]) : 0;
						System.out.println("Win:"+ arr[1] + ":$" + String.format("%.2f", winDividend));
					}
					// calculate the PLACE product
					if(!placeMap.isEmpty() && placeSum != 0) {
						double placePool = (double)placeSum * 0.88 / 3;
						
						double placeFirstDividend = placeMap.containsKey(arr[1]) && placeMap.get(arr[1]) != 0 ? 
								placePool / (double)placeMap.get(arr[1]) : 0;
						double placeSecondDividend = placeMap.containsKey(arr[2]) && placeMap.get(arr[2]) != 0 ? 
								placePool / (double)placeMap.get(arr[2]) : 0;
						double placeThridDividend = placeMap.containsKey(arr[3]) && placeMap.get(arr[3]) != 0 ? 
								placePool / (double)placeMap.get(arr[3]) : 0;			
						System.out.println("Place:"+ arr[1] + ":$" + String.format("%.2f", placeFirstDividend));
						System.out.println("Place:"+ arr[2] + ":$" + String.format("%.2f", placeSecondDividend));
						System.out.println("Place:"+ arr[3] + ":$" + String.format("%.2f", placeThridDividend));
					}					
					// calculate the EXACTA product
					if(!exactaMap.isEmpty() && exactaSum != 0) {
						double exactaPool = (double) exactaSum * 0.82;
						
						double exactaFirstTwoDividend = exactaMap.containsKey(arr[1]+","+arr[2]) && exactaMap.get(arr[1]+","+arr[2]) != 0 ? 
								exactaPool / (double)exactaMap.get(arr[1]+","+arr[2]) : 0;
						System.out.println("Exacta:" + arr[1]+","+arr[2] + ":$" + String.format("%.2f", exactaFirstTwoDividend));
					}
				} 
			}			
			sc.close();
		} catch (Exception e) {
			e.getStackTrace();
			throw new Exception(e.getMessage());
		}
	}	
}
