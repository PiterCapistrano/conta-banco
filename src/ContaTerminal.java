import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.Random;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
       // TODO: conhecer e importar a classe Scanner
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        String numeroContaFormatado = "";
        String agenciaFormatada = "";

        boolean contaValida = false;
        while (!contaValida) {
            try{  
        
       // Exibir as mensagens para o nosso usuário
       System.out.println("Por favor, digite o número da Conta!");
       // Obter pela scanner os valores digitados no terminal
       int numeroConta = scanner.nextInt();
       String numeroContaString = String.valueOf(numeroConta);
       numeroContaFormatado = formatarNumeroConta(numeroContaString);
       contaValida = true; // Sai do loop se for bem-sucedido
   } catch (InputMismatchException e) {
       System.out.println("Número da conta deve ser numérico. Tente novamente.");
       scanner.nextLine(); // Limpa o buffer do scanner
   } catch (AgenciaInvalidaException e) {
       System.err.println("A quantidade de dígitos do número da conta deve ser igual a 4.");
   }
}

    boolean agenciaValida = false;
    while (!agenciaValida) {
        try{
            System.out.println("Por favor, digite o número da Agência!");
            int agencia = scanner.nextInt();
            String agenciaString = String.valueOf(agencia);
            agenciaFormatada = formatarAgencia(agenciaString);
            agenciaValida = true; // Sai do loop se for bem-sucedido
        } catch (InputMismatchException e) {
            System.out.println("Número da agência deve ser numérico. Tente novamente.");
            scanner.nextLine(); // Limpa o buffer do scanner
        } catch (AgenciaInvalidaException e) {
            System.err.println("A quantidade de dígitos da agência deve ser igual a 4.");
        }
    }

        System.out.println("Por favor, digite o seu nome!");
        String nome = scanner.next();

        System.out.println("Por favor, digite o seu sobrenome!");
        String sobrenome = scanner.next();

        double saldo = new Random().nextDouble(5000.00);
        String saldoFormatado = String.format("%.2f", saldo);

       // Exibir a mensagem conta criada
       System.out.println("Conta criada com sucesso!");
       System.out.println("Número da Conta: " + numeroContaFormatado);
       System.out.println("Número da Agência: " + agenciaFormatada);
       System.out.println("Nome do Titular da Conta: " + nome + " " + sobrenome);
       System.out.println("Saldo: " + saldoFormatado  + " R$");

    }
    static String formatarNumeroConta (String conta) throws AgenciaInvalidaException{
        if (conta.length() != 4) 
            throw new AgenciaInvalidaException();

        // Formata o número da conta no formato XXXX
        return conta.substring(0, 4);
    }

    static String formatarAgencia (String agencia) throws AgenciaInvalidaException{
        if (agencia.length() != 4)
            throw new AgenciaInvalidaException();

        // Formata a agência no formato XXX-X
        return agencia.substring(0, 3) + "-" + agencia.charAt(3);
    }
}
