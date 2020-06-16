package Testador;

import java.util.*;

public class tercadij {

    private static final int UNDEFINED = -1;
    private int vert[][];

    public tercadij(int nV) {
        vert = new int[nV][nV];
        
    	}

    public void dis(int ver1, int ver2, int dis) {
        vert[ver1][ver2] = dis;
        vert[ver2][ver1] = dis;
    }

    public void remove(int ver1, int ver2) {
        vert[ver1][ver2] = 0;
        vert[ver2][ver1] = 0;
    }

    public int custo(int ver1, int ver2) {
        return vert[ver1][ver2];
    }

    public List<Integer> viz(int ver) {
        List<Integer> viz = new ArrayList<>();
        for (int i = 0; i < vert[ver].length; i++)
            if (vert[ver][i] > 0) {
                viz.add(i);
            }
        return viz;
    }

    public List<Integer> cam(int from, int to) {

        int cust[] = new int[vert.length];
        int prev[] = new int[vert.length];
        Set<Integer> Nvis = new HashSet<>();

        cust[from] = 0;

        for (int v = 0; v < vert.length; v++) {
            if (v != from) {
                cust[v] = Integer.MAX_VALUE;
            }
            prev[v] = UNDEFINED;
            Nvis.add(v);
        }

        while (!Nvis.isEmpty()) {
            int perto = Mperto(cust, Nvis);
            Nvis.remove(perto);

            for (Integer viz : viz(perto)) {
                int totalCust = cust[perto] + custo(perto, viz);
                if (totalCust < cust[viz]) {
                    cust[viz] = totalCust;
                    prev[viz] = perto;
                }
            }

            if (perto == to) {
                return FazerCam(prev, perto);
            }
        }

        return Collections.emptyList();
    }
    int estrada(String type, Scanner in) {
    	Scanner entrada = new Scanner(System.in);
    	while (true) {
    		System.out.println(type + ":");
   
    	}
    		/*try {
    			int cidade = Integer.parseInt(line);
    			if (cidade >= 1 && cidade <= 20)
    				return cidade - 1;
    		} catch (NumberFormatException e) {
    		}
    		System.out.println("Cidade não reconhecida!");
    	}*/
    }

    private int Mperto(int[] dist, Set<Integer> Nvisitado) {
        double minDist = Integer.MAX_VALUE;
        int minIndex = 0;
        for (Integer i : Nvisitado) {
            if (dist[i] < minDist) {
                minDist = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private List<Integer> FazerCam(int[] prev, int u) {
        List<Integer> cam = new ArrayList<>();
        cam.add(u);
        while (prev[u] != UNDEFINED) {
            cam.add(prev[u]);
            u = prev[u];
        }
        Collections.reverse(cam);
        return cam;
    }

}