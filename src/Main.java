import java.util.Scanner;

class CalculadoraProfessor {
    private String regime;
    private double valorAReceber;

    //Classe de armazenamento do regime para validação da escolha
    public CalculadoraProfessor(String regime) {
        this.regime = regime;
    }

    //Classe que recebe os dados e realiza o cálculo
    public void calculaValorAReceber() {
        Scanner input = new Scanner(System.in);
        boolean regimeValido = false; //Por fazer a entrada ser uma String, foi necessário a validação em boolean para criar o loop de escolha

        while (!regimeValido) {
            if (regime.equals("1")) { // CLT
                System.out.print("Digite o salário mensal do professor: ");
                double salario = input.nextDouble();
                valorAReceber = salario;
                regimeValido = true;
            } else if (regime.equals("2")) { // Horista
                System.out.print("Digite o número de horas trabalhadas pelo professor: ");
                double horasTrabalhadas = input.nextDouble();
                System.out.print("Digite o valor da hora de trabalho: ");
                double valorHora = input.nextDouble();
                valorAReceber = horasTrabalhadas * valorHora;
                regimeValido = true;
            } else if (regime.equals("3")) { // PJ
                System.out.print("Digite o valor do contrato do professor: ");
                double valorContrato = input.nextDouble();
                valorAReceber = valorContrato;
                regimeValido = true;
            } else {
                System.out.println("Regime de pagamento inválido. Digite novamente: ");
                regime = input.nextLine();
            }
        }

        input.close(); // Fecha o Scanner após o cálculo
    }

    //Classe que armazena o valor a receber
    public double getValorAReceber() {
        return valorAReceber;
    }
}

//Classe que identifica o Professor e chama as demais classes
class Professor {
    private String nome;
    private CalculadoraProfessor calculadora;

    public Professor(String nome, String regime) {
        this.nome = nome;
        calculadora = new CalculadoraProfessor(regime);
    }

    //Chamando o calculo e atribuindo os dados a Professor
    public void calculaValorAReceber() {
        calculadora.calculaValorAReceber();
    }

    public void imprimirValorAReceber() {
        System.out.println("Nome do professor: " + nome);
        System.out.println("Valor a receber: " + calculadora.getValorAReceber());
    }
}

//Classe inicial do codigo com as demais classes separadas sendo chamadas
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o nome do professor: ");
        String nome = input.nextLine();

        System.out.println("Digite o regime de pagamento: ");
        System.out.println("1 - CLT");
        System.out.println("2 - Horista");
        System.out.println("3 - PJ");
        String regime = input.nextLine();

        Professor professor = new Professor(nome, regime);
        professor.calculaValorAReceber();
        professor.imprimirValorAReceber();

        input.close();
    }
}
