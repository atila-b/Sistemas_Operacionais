public class ThreadLeitura implements Runnable{
    private String nome;
    int index;
    Lista arraylist;

    public ThreadLeitura(String nome, Lista arraylist, int index){
        this.nome = nome;
        this.arraylist = arraylist;
        this.index = index;
    }

    @Override
    public void run(){
        String resultado;
        try{
            resultado = this.arraylist.get(this.index);
            System.out.printf("Elemento lido no index %d = '%s'%n", this.index, resultado);
        }catch(Exception e){
            System.out.println("Este index nao existe, impossivel ler");
        }

    }

}