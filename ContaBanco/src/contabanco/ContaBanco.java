package contabanco;
public class ContaBanco {
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    public ContaBanco(int numConta, String tipo, String dono) {
        this.numConta = numConta;
        this.tipo = tipo;
        this.dono = dono;
    }

    public int getNumConta() {
        return numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDono() {
        return dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public void abrirConta(){
        if(!this.status){
            this.status = true;
            if(tipo.toUpperCase().compareTo("CC")==0){
                this.saldo=50;
            }
            else if(tipo.toUpperCase().compareTo("CP")==0){
                this.saldo=150;
            }
            else{
                this.saldo=0;
            }
        }
    }
    public void fecharConta(){
        if(this.status){
            if(this.saldo!=0){
                System.out.println("O saldo da conta não é nulo.");
                if(this.saldo>0)
                    System.out.println("Há R$"+this.saldo+"ainda em conta");
                else
                    System.out.println("Há um débito de "+this.saldo+"a ser pago");
            }
        }
    }
    public void depositar(float d){
        if(this.status){
            this.saldo+=d;
        }
    }
    public void sacar(float s){
        if(this.status){
            if(this.saldo>=s)
                this.saldo-=s;
            else
                System.out.println("Não há saldo suficiente para a operação");
        }
    }
    public void pagarMensal(){
        if(this.status){
            if(tipo.toUpperCase().compareTo("CC")==0){
                this.saldo-=12;
            }
            else if(tipo.toUpperCase().compareTo("CP")==0){
                this.saldo-=20;
            }
                   
        }
    }
    
    
    public static void main(String[] args) {
        ContaBanco c1 = new ContaBanco(123837563,"cp","Carlos Alberto");
        c1.abrirConta();
        c1.depositar(100f);
        System.out.println(c1.getNumConta());
        System.out.println(c1.getTipo());
        System.out.println(c1.getDono());
        System.out.println(c1.getSaldo());
    }
    
}
