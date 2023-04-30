package testes;

public class TestaSeENumeroOuTexto {
    public static void main(String[] args) {
        String texto1 = "Texto";
        String texto2 = "1";

        try {
            int textoConvertido = Integer.parseInt(texto1);
            System.out.println("É numero");
        }catch (NumberFormatException e){
            System.out.println("Não é numero");
        }
    }
}
