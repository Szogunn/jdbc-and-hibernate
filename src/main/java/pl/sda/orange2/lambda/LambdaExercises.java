package pl.sda.orange2.lambda;

public class LambdaExercises {

    public static void main(String[] args) {
        BoysDontCry boy = new ChłopakiNiePłaczą();
        boy.silnoreki();

         ((ChłopakiNiePłaczą) boy).sing();

         ChłopakiNiePłaczą boy2 = new ChłopakiNiePłaczą();
         boy2.sing();
    }
}
