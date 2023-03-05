package pl.sda.orange2.lambda;

import pl.sda.orange2.lambda.coffeeExample.CoffeeMaker;

public class LambdaExercises {

    public static void main(String[] args) {
        BoysDontCry boy = new ChłopakiNiePłaczą();
        boy.silnoreki();

        ((ChłopakiNiePłaczą) boy).sing();

        ChłopakiNiePłaczą boy2 = new ChłopakiNiePłaczą();
        boy2.sing();

        BoysDontCry anonymousClassReference = new BoysDontCry() {
            @Override
            public void silnoreki() {
                System.out.println("Anonimowy Silnoreki: ");
            }
        };

        anonymousClassReference.silnoreki();

        BoysDontCry firstLambda = () -> {
        };
        BoysDontCry secondLambda = () -> System.out.println("Boys Dont Cry second Lambda");
        BoysDontCry thirdLambda = () -> {
            System.out.println("first");
            System.out.println("second");
        };


        System.out.println("---------------------");
        System.out.println("Coffee Time");

        CoffeeMaker myCoffeeMaker = (int water, String coffeeType) -> " Zrobione ";

        CoffeeMaker myCoffeeMaker2 = (int water, String coffeeType) -> {
            System.out.println("Preparing coffee ...");
            return " Zrobione ";
        };

        //jeżeli nadpisujemy jedną metodę to InteliJ przypilnuję nas że typy będą się zgadzały z definicją metody
        CoffeeMaker myCoffeeMaker3 = (water, coffeeType) -> coffeeType + " Coffee done ";

        String myCoffe = myCoffeeMaker3.prepare(5, "small");
        System.out.println(myCoffe);

    }
}
