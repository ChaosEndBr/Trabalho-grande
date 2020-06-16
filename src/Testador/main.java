package Testador;

import java.util.Scanner;

import Testador.Arvoreord.MB;

public class main {
	public static void main(String[] args) {
		int opcao = 0;
		do {
			Scanner entrada = new Scanner(System.in);
			System.out.println("\n\n Crie Agora sua arvore e escolha o tipo de estrutura ");
			System.out.println("\n             =========================");
			System.out.println("             *     1 - BFS           *");
			System.out.println("             *     2 - Dijkstra      *");
			System.out.println("             *     3 - DTS           *");
			System.out.println("             *     4 - HeapSort      *");
			System.out.println("             *     5 - Ordem         *");
			System.out.println("             *     0 - Sair          *");
			System.out.println("             =========================\n");
			opcao = entrada.nextInt();

			
			switch (opcao) {
			case 1:
				System.out.print("Quantos vertices: ");
				int t = entrada.nextInt();
				grafo teste = new grafo();
				for (int cont = 0; cont < (t - 1); ) {
                    System.out.print("Adicione o vertice-> ");
                    int a = entrada.nextInt();
                    teste.addver('a');
                    System.out.print("Digite da Aresta 1 ");
                    int b = entrada.nextInt();
                    System.out.print("Digite da Aresta 2 ");
                    int c = entrada.nextInt();
                    teste.addaresta(b, c);
                    cont++;
                }
				System.out.print("escolha de onde começa: ");
				int numero = entrada.nextInt();
				teste.bfs(numero);
    			System.out.println();
    			System.out.println("_________");
    			teste.contador();
    			System.out.println("_________");
				break;
				
			case 2:
				System.out.print("Quantas Arestas: ");
				int s = entrada.nextInt();
				tercadij teste2 = new tercadij(s);
				for (int cont = 0; cont < (s - 1); ) {
					System.out.print("Vertice 1: ");
					int a = entrada.nextInt();
					System.out.print("Vertice 2: ");
					int b = entrada.nextInt();
					System.out.print("Valor da arestas: ");
					int c = entrada.nextInt();
					teste2.dis(a,b,c);
					cont++;
				}	
				break;
			
			case 3:
				 System.out.print("Quantos vertices: ");
					int d = entrada.nextInt();
					arvoredts teste3 = new arvoredts(4);
					for (int cont = 0; cont < (d - 1); ) {
						System.out.print("Vertice 1: ");
						int a = entrada.nextInt();
						System.out.print("Vertice 2: ");
	                    int b = entrada.nextInt();
						teste3.addEdge(a, b);
						cont++;
					}
					 System.out.print("escolha o comeco: ");
					 int e = entrada.nextInt();
					 teste3.DFS(e);
				break;
				
			case 4:
				System.out.print("quantidade de numeros: ");
				int h = entrada.nextInt();
				for (int cont = 0; cont < (h - 1); ) {
					int o = entrada.nextInt();
					Integer[] arr = {o};
					cont++;	
					Heapsort.Sort(arr);
				}
				break;
				
			case 5:
				System.out.print("Quantos vertices: ");
				int f = entrada.nextInt();
				Arvoreord teste4 = new Arvoreord("A");
				for (int cont = 0; cont < (f - 1); ) {
					System.out.print("Aresta 1: ");
					int a = entrada.nextInt();
					System.out.print("Aresta 2: ");
					int b = entrada.nextInt();
					System.out.print("escolha o lado: \n");
					System.out.print("escolha: 1-esquerda 2-direita ");
					teste4.PreOrdem();
					int c = entrada.nextInt();
					if(c==1) {
						teste4.AdicionarNo("a", "b",MB.esquerda);
					}else if(c==2) {
						teste4.AdicionarNo("a", "b",MB.direita);
					}else {
						return;
					}	
					cont++;
				}
				 System.out.println("Ordem de busca: " + teste4.PreOrdem());
				break;
			case 0:
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}
		} while (opcao != 0);
	}
}
