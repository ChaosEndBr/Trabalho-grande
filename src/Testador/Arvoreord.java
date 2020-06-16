package Testador;

public class Arvoreord {
	
	public enum MB {
        esquerda, direita
    }
     
    private Noord arvore;
 
    public Noord getArvore() { return arvore; }
    public void setArvore(Noord arvore) { this.arvore = arvore; }

    public Arvoreord(String raiz){
        setArvore(new Noord(raiz));
    }
     
    public void AdicionarNo(String noordPai, String Nonome, MB modo){
        if (modo == MB.direita) {
            AdicionarNoDireita(noordPai, Nonome);
        } else if (modo == MB.esquerda) {
            AdicionarNoEsquerda(noordPai, Nonome);
        }
    }
     
    public void AdicionarNoEsquerda(String noordPai, String Nonome){
        Noord noord = findNoord(getArvore(), noordPai);
        if (noord == null) { return; }
        noord.setEsquerda(new Noord(Nonome));
    }
     
    public void AdicionarNoDireita(String noordPai, String Nonome){
        Noord noord = findNoord(getArvore(), noordPai);
        if (noord == null) { return; }
        noord.setDireita(new Noord(Nonome));
    }

    private Noord findNoord(Noord noord, String nome){
        if (noord == null || nome == null || nome.isEmpty()) { return null; }
        if (noord.getNome().equals(nome)) { return noord; }
        Noord noordesquerda = findNoord(noord.getEsquerda(), nome);
        if (noordesquerda != null) { return noordesquerda; }
        return findNoord(noord.getDireita(), nome);
    }
     
    public void Clear(String raiz){
        nullnoords(getArvore());
        setArvore(new Noord(raiz));
    }

    private void nullnoords(Noord noord){
        if (noord == null) { return; }
        nullnoords(noord.getDireita());
        nullnoords(noord.getEsquerda());
        noord.setEsquerda(null); noord.setDireita(null);
        noord = null;
    }

    public String PreOrdem(){
        if (getArvore() == null) { return ""; }
        return ordem(getArvore());
    }
     
    private String ordem(Noord noord){
        if (noord == null) {return "";}
        String rt = noord.toString();
        if (noord.getEsquerda() != null) {
            rt += (rt.isEmpty() ? "" : ",") + ordem(noord.getEsquerda());
        }
        if (noord.getDireita() != null) {
            rt += (rt.isEmpty() ? "" : ",") + ordem(noord.getDireita());
        }
        return rt;
    }
         
	}

