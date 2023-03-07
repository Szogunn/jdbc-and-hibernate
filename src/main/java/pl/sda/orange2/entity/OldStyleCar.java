package pl.sda.orange2.entity;


import java.util.Objects;

public class OldStyleCar {

    private final Long id;
    private final String color;
    private final String brand;
    private final String model;

    public OldStyleCar(Long id, String color, String brand, String model) {
        this.id = id;
        this.color = color;
        this.brand = brand;
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OldStyleCar that = (OldStyleCar) o;
        return Objects.equals(id, that.id) && Objects.equals(color, that.color) && Objects.equals(brand, that.brand) && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, color, brand, model);
    }

    @Override
    public String toString() {
        return "OldStyleCar{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
