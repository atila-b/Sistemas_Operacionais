public class ThreadRemocao implements Runnable{
    private String nome;
    int index;
    Lista arraylist;

    public ThreadRemocao(String nome, Lista arraylist, int index){
        this.nome = nome;
        this.arraylist = arraylist;
        this.index = index;
    }

    @Override
    public void run(){
        try{
            this.arraylist.remover(this.index);
            System.out.printf("Index %d removido%n", this.index);
        }catch(Exception e){
            System.out.printf("Index %d nao existe, impossivel remover%n", this.index);
        }
    }
}