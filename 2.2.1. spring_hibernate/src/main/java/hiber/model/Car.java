package hiber.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

//@Component
@Entity
@Table(name = "car")
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column
    String model;

    @Column
    int series;

    //@OneToOne(/*mappedBy = "User"*/) // ?? Car
    //@MapsId
//    private User user;


    public Car( String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Car() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }


    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}
