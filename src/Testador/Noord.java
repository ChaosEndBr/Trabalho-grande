package Testador;

public class Noord{
		 
	    private String nome;
	    private Noord esquerda;
	    private Noord direita;
	     
	    public String getNome() { return nome; }
	    public void setNome(String nome) { this.nome = nome; } 
	    public Noord getEsquerda() { return esquerda; }
	    public void setEsquerda(Noord esquerda) { this.esquerda = esquerda; }
	    public Noord getDireita() { return direita; }
	    public void setDireita(Noord direita) { this.direita = direita; }
	     
	    public Noord(){
	        this(null, null, null);
	    }
	    public Noord(String nome){
	        this(nome, null, null);
	    }
	     
	    public Noord(String nome, Noord esquerda, Noord direita){
	        setNome(nome);
	        setEsquerda(esquerda);
	        setDireita(direita);
	    }
	     
	    @Override
	    public int hashCode() {
	        return getNome() == null ? 0 : getNome().hashCode();
	    }
	     
	    @Override
	    public boolean equals(Object obj) {
	        if (obj == null || !(obj instanceof Noord)) { return false; }
	        return ((Noord)obj).hashCode() == hashCode();
	    }
	     
	    @Override
	    public String toString() {
	        return getNome() == null ? "" : getNome();
	    }
	     
	}