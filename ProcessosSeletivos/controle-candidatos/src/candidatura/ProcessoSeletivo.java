package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
	
	static double salarioBase = 2000.00;
	
	public static void main (String[] args) {
		selecaoCandidatos();
		imprimirSelecionados();
		String [] candidatos = {"Felipe", "Marcia", "Junior", "Erick","Marcela"};
		for(String candidato:candidatos) {
			entrandoEmContato(candidato);
		}
	}
	
	static void imprimirSelecionados() {
		String [] candidatos = {"Felipe", "Marcia", "Junior", "Erick","Marcela"};
		
		System.out.println("A lista de candidatos selecionados");
		
		for(int indice=0; indice< candidatos.length; indice++) {
			System.out.println("O candidato nº" + (indice+1) + " é o candidato(a) " + candidatos[indice]);
		}
		
		for(String candidato:candidatos) {
			System.out.println("O candidato(a) " + candidato + " foi selecionado");
		}
		
	}
	
	static void entrandoEmContato(String candidato) {
		
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;		
		boolean atendeu=false;
		
		do {
			atendeu = atender();
			continuarTentando =!atendeu;
			
			if(continuarTentando)
				tentativasRealizadas++;
			else
				System.out.println("Contato realizado com sucesso");	
		}
		while(continuarTentando && tentativasRealizadas<3);
		
		if(atendeu)
			System.out.println("Conseguimos contato com " + candidato + " com " + tentativasRealizadas + " tentativas");
		else
			System.out.println("Não conseguimos contato com " + candidato +" em " + tentativasRealizadas + " tentativas");
	}
	
	static boolean atender() {
		return new Random().nextInt(3)==1;
	}
	
	static void selecaoCandidatos() {
		String [] candidatos = {"Felipe", "Marcos","Julia", "Marcela", "Maria", "Carlos","João","Erick","Marcia","Junior"};
		
		int candidatosSelecionados = 0;
		int candidatoAtual = 0;
		
		while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
			double salarioDesejado = valorPretendido();
			String candidato = candidatos[candidatoAtual];
			System.out.println("O candidato(a) " + candidato + " solicitou este valor de salário " + salarioDesejado);
			if(salarioBase>= salarioDesejado) {
				System.out.println("O candidato(a) " + candidato + " foi selecionado para a vaga");
				candidatosSelecionados++;
			}else {
				System.out.println("O candidato(a) " + candidato + " não foi selecionado");
			}
			candidatoAtual++;
		}
		
	}
	
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);	
	}
	
	static void analisarCandidato(Double salarioDesejado) {
		
		if (salarioDesejado < salarioBase) {
			System.out.println("Ligar para o candidato");
		} else if(salarioDesejado == salarioBase) {
			System.out.println("Ligar para o candidato com contra proposta");
		} else {
			System.out.println("Aguardando outros candidatos");
		}
	
	}
}
