package pl.sda.orange2.lambda.coffeeExample;

@FunctionalInterface
public interface CoffeeMaker {

    String prepare(int water, String coffeeType);
}
