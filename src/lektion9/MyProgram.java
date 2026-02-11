package lektion9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class MyProgram {
    private File file;
    private ArrayList cars;

    public MyProgram(){
        this.cars = new ArrayList<>();
        this.file = null;
    }
    public void run(){
        try {
            file = new File("src/lektion9/Car.txt");
            if(file.canExecute()){
                System.out.println("done");
            }
            Scanner readFile = new Scanner(file);
            while (readFile.hasNextLine()){
                String carBrand = readFile.nextLine();
                if (readFile.hasNextLine()) {
                    int year = Integer.parseInt(readFile.nextLine());
                    int milage = Integer.parseInt(readFile.nextLine());
                    cars.add(new Car(carBrand,year,milage));
                    System.out.println("model: " + carBrand + " year: " + year + " milage: " + milage);
                }
            }
            Collections.sort(cars);
            Iterator itr = cars.iterator();
            try {
                File NewFile = new File("src/lektion9/CarNew.txt");
                if(NewFile.createNewFile()){
                    System.out.println("File created: " + NewFile.getName());
                }
                FileWriter write = new FileWriter(NewFile);
                while(itr.hasNext()){
                    Car car = (Car)itr.next();
                    write.append(car.getCarBrand()+"\n" + car.getYearModel()+"\n" +car.getMilage()+"\n" );
                }
                write.close();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
            Collections.sort(cars,new CompareCar());
            Iterator itr2 = cars.iterator();
            try {
                File NewFile2 = new File("src/lektion9/CarNew2.txt");
                if(NewFile2.createNewFile()){
                    System.out.println("File created: " + NewFile2.getName());
                }
                FileWriter write2 = new FileWriter(NewFile2);
                while(itr2.hasNext()){
                    Car car = (Car)itr2.next();
                    write2.append(car.getCarBrand()+"\n" + car.getYearModel()+"\n" +car.getMilage()+"\n" );
                }
                write2.close();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
       catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
