package testedois;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//Crie um sistema para sortear aleatoriamente 10 números de 0 a 99 sem repetir, onde
//ela irá aguardar o usuário informa outros 15 números sem repetir para analisar e informa
//quantos números a pessoa acertou e quantos números ela errou.

public class Testedois {

	public static void main(String[] args) {
		int[] v = gerarVetor(10);
		
		Scanner ler = new Scanner (System.in);
		int x[] = new int [15];
		
		for (int c = 0; c < x.length; c++) {
			System.out.println("Digite um numero de 0 a 99 :  ");
			x[c] = ler.nextInt();

		}
		
		int [] c = intersecao(v, x);
		int  mais = acertou(c);
		int errou = 15 - mais;
		
		
		//Console
		System.out.println("");
		System.out.printf("Voce acertou %d", mais );
		System.out.printf(" e errou %d", errou );
		System.out.println("");
		System.out.println("");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("");
		System.out.println("E os numeros sorteados foram  :  ");
		System.out.println(Arrays.toString(v));
		System.out.println("E os numeros escolhidos foram :  ");
		System.out.println(Arrays.toString(x));
		
		

	}

	//Somar quanros numeros acertou
	private static int acertou(int[] c) {
		int maior = 0;
		
		for (int i = 1; i < c.length; i++) {
			if (c[i] > c[maior]) {
				maior=i;
			}
		}
		
		return maior;
	}

	//fazer a interseção dos vetores
	private static int[] intersecao(int[] v, int[] x) {
		int []aux = new int [v.length + x.length];
		int k = 0;
		int t = 0;
		
		for (int i = 0; i < v.length; i++ )
			for(int j=0; j < x.length; j++){
				if (v[i] == x[j])
					aux[k++] = t+=1;
		}
		
		int []c = new int [k];
		for (int i = 0; i < k; i++)
			c[i] = aux [i];
		
		return c;
	}

	//vetor que gera os numeros aleatorios de 0 á 99
	private static int[] gerarVetor(int tam) {
		int[] vetor = new int [tam];
		Random gerador = new Random();
		
		boolean iguais = false;
		for (int i = 0; i < vetor.length; i++)
			for (int j = 0; j < vetor.length; j++){
			vetor[i] = gerador.nextInt(100);
			if (i!=j) {
				if (vetor[i] == vetor[j] ) {
					iguais = true;
				}
				if (iguais) {
					return gerarVetor(tam);
				}
			}
		}
	return vetor;
	}

}
