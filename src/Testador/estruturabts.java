package Testador;

import java.util.LinkedList;
import java.util.Queue;

import java.util.Scanner;
import java.util.Scanner;

public class estruturabts {

	public char label;
	public boolean visitado;
	
	public estruturabts(char lab) {
		label=lab;
		visitado=false;
	}
}

class grafo{
	private final int mxv = 20;
	private estruturabts lista[];
	private int adj[][];
	private int numv;
	private int cont;
	private Queue<Integer> q;
	 
public grafo() {
lista = new estruturabts[mxv];
adj = new int[mxv][mxv];
numv=0;
q = new LinkedList<Integer>();
}

void addver(char lab) {
	lista[numv++] = new estruturabts(lab) ;  	
}

void addaresta(int comeco, int fim) {
	adj[comeco][fim]=1;
	adj[fim][comeco]=1;
	cont++;
}
void contador() {
	System.out.println(" " + cont + " passos");		
}
void mostrador(int m) {
	System.out.print(lista[m].label);	
}

public int getAdjuniversaldestrutura(int m) {
	for(int j=0; j<numv; j++ ) {
		if (adj[m][j]==1 && lista[j].visitado==false) {
		return j;
	}
	}
	return -1;
}

void bfs(int numero) {      
	System.out.print("Escolha onde começa: ");
	//Scanner scanner = new Scanner(System.in);
	// int numero = scanner.nextInt();
			lista[numero].visitado=true;
			mostrador(numero);
			q.add(numero);
			int v2;
			
			while(!q.isEmpty()) {
				int v1 = q.remove();
					while((v2=getAdjuniversaldestrutura(v1))!=-1) {
						lista[v2].visitado=true;
						mostrador(v2);
						q.add(v2);	
			}
		}
	}
}
