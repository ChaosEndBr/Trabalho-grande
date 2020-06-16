package Testador;

import java.util.Scanner;

public class arvorebts {
	  public int num;
      public arvorebts dir, esq;
 
     
public static arvorebts inserir(arvorebts aux, int num) {
          if (aux == null) {
              aux = new arvorebts();
              aux.num = num;
              aux.esq = null;
              aux.dir = null;
   
          } else if (num < aux.num) {
              aux.esq = inserir(aux.esq, num);
          } else {
              aux.dir = inserir(aux.dir, num);
          }
          return aux;
      }

public static String imprimir(arvorebts aux) {
	String retorno;
	retorno = "(";
    if (aux != null) {
    	retorno += "C" + aux.num; 
        retorno += imprimir(aux.esq);
        retorno += imprimir(aux.dir);
    }
    retorno += ")";
    return retorno;
}

public static boolean localizar(arvorebts aux, int num, boolean loc) {
    if (aux != null && loc == false) {
        if (aux.num == num) {
            loc = true;
        } else if (num < aux.num) {
            loc = localizar(aux.esq, num, loc);
        } else {
            loc = localizar(aux.dir, num, loc);
        }
    }
    return loc;
}

public static arvorebts excluir(arvorebts aux, int num) {
    arvorebts p, p2, r = null;
    if (aux.num == num) {
        if (aux.esq == aux.dir) {
            return null;
        } else if (aux.esq == null) {
            return aux.dir;
        } else if (aux.dir == null) {
            return aux.esq;
        } else {
            p2 = aux.dir;
            p = aux.dir;
            while (p.esq != null) {
            	r = p;
                p = p.esq;
            }
            aux.num = p.num;
            p = null;
            r.esq = null;
            return aux;
        }
    } else if (aux.num < num) {
        aux.dir = excluir(aux.dir, num);
    } else {
        aux.esq = excluir(aux.esq, num);
    }
    return aux;
}

/*public static void main(String[] args) {
    
	Scanner entrada = new Scanner(System.in);
	arvorebts a = null;
    int n = entrada.nextInt();
	
    for(int i = 0; i < n; i++){
    	a = inserir(a, entrada.nextInt());
    }
    int num = entrada.nextInt();
    if( localizar(a, num, false)){
    	a.excluir(a, num);
    }
    else{
    	inserir(a, num);
    }
    System.out.println(imprimir(a));
}*/
}
