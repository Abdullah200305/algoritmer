package lektion9;

public class Car implements Comparable<Car>{
    private String carBrand;
    private int yearModel;
    private int milage;

    public Car(String carBrand,int yearModel,int milage) {
        this.carBrand = carBrand;
        this.yearModel = yearModel;
        this.milage = milage;
    }

    public int getYearModel() {
        return yearModel;
    }

    public int getMilage() {
        return milage;
    }

    public String getCarBrand() {
        return carBrand;
    }

    @Override
    public int compareTo(Car other) {
        return this.carBrand.compareTo(other.carBrand);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carBrand='" + carBrand + '\'' +
                ", yearModel=" + yearModel +
                ", milage=" + milage +
                '}';
    }
}
