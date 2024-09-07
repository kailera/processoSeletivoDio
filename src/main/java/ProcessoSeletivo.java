import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        System.out.println("Processo Seletivo");
        String[] candidatos = {"MARA", "MARCIA", "JONAS", "LEMUAL", "HUMBERTO"};
        for (String candidato:candidatos){
            entrarEmContato(candidato);
        }
    }

    static void entrarEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do{
        atendeu=atender();
        continuarTentando=!atendeu;

        if(continuarTentando){
            tentativasRealizadas++;
        }else{
            System.out.println("Contato Realizado com Sucesso");
        }
        }while(continuarTentando && tentativasRealizadas < 3);

        if(atendeu){
            System.out.println("Conseguimos contato com " + candidato +" na " + tentativasRealizadas + "tentativa");
        }else{
            System.out.println("Não conseguimos contato com  " + candidato + " . Numero de tentativas: " + tentativasRealizadas)    ;
        }
    }
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }
    static void imprimirSelecionados(){
        String[] candidatos = {"MARA", "MARCIA", "JONAS", "LEMUAL", "HUMBERTO"};
        System.out.println("Candidatos Selecionados: ");

        for(String candidato: candidatos){
            System.out.println("Candidato Selecionado: " + candidato    );
        }
    }
    static void selecaoDeCandidatos(){
        String[] candidatos = {"MARA", "MARCIA", "JONAS", "LEMUAL", "HUMBERTO", "DOISBERTO","CAMBOAO","FEIJAO", "CROPPED"};
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + "Solicitou este valor de salário: R$" + salarioPretendido);
            if(salarioBase >= salarioPretendido){
                candidatosSelecionados ++;
                System.out.println("Candidato Selecionado para Vaga");
            }
            candidatoAtual++;
        }
    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido){
            System.out.println("Ligar para Candidato");
        }else if(salarioBase == salarioPretendido){
            System.out.println("Ligar para o candidato com contra proposta");
        }else{
            System.out.println("Aguardando o resultado dos demais candidatos");
        }
    }
}
