package lektion9;

import java.util.Comparator;

public class CompareCar implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return Integer.compare(o1.getYearModel(),o2.getYearModel());
    }
}
