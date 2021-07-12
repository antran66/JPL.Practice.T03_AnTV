/*
 * Copyright 2019 Fresher Academy
 * @author AnTV5
 * @date Nov 19, 2019
 * @version 1.0
*/
package fa.training.problem01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CarManagement {
	private List<Car> cars = new ArrayList<>();
	
	public List<Car> getCars(){
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	public void readFile() throws IOException, NumberFormatException{
		String fileName = "cars.txt";
		
		try(Stream<String> stream = Files.lines(Paths.get(fileName),StandardCharsets.UTF_8)){
			stream.forEach(line ->{
				Car car = new Car();
				String strCars[] = line.split(",");
				
				for(int i =0; i<strCars.length; i++) {
					//System.out.print(strCars[i]+" "+i);
					
					car.setLicenseNumber(strCars[0]);
					car.setModel(strCars[1]);
					car.setYear(Integer.parseInt(strCars[2]));
					car.setBrand(strCars[3]);
					car.setColor(strCars[4]);
				}
				cars.add(car);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(cars != null) {
			System.out.println("------LIST CARS------");
			for (Car car : cars) {
				System.out.println(car);
			}
		}
	}
	
	public List<Car> findByLicense(String license){
		List<Car> findCar = new ArrayList<>();

		if(cars != null) {
			for (Car car : cars) {
				if(car.getLicenseNumber().equals(license)) {
					findCar.add(car);
				}
			}
		}
		
		return findCar;
	}
	
	public Map<Integer, List<Car>> classifyByYear(){
		
		return null;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		CarManagement carManagement = new CarManagement();
		
		carManagement.readFile();
		
		List<Car> findCar = new ArrayList<>();
		findCar = carManagement.findByLicense("34-34567");
		
		if(findCar != null) {
			for (Car car : findCar) {
				System.out.println("---------hava find car------------");
				System.out.println(car);
			}
		}else {
			System.out.println("not fond");
		}
		
	}
}
