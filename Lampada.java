
/**
 * Escreva a descrição da classe Lampada aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Lampada
{
    //0 desligada; 1 ligado; 2 eco
    private int modo;
    
    private final double consumoNormal = 0.1;
    private final double consumoEco = 0.05;
    private long total;
    private long stamp;
    
    public Lampada(){
        this.modo=0;
        this.total = 0;
        this.stamp=System.currentTimeMillis();
    }
    
    public Lampada(int modo, long total, long stamp){
        this.modo=modo;
        this.total=total;
        this.stamp=stamp;
    }
    
    public Lampada(Lampada l){
        this.modo=l.getModo();
        this.total=l.getTotal();
        this.stamp=l.getStamp();
    }
    
    public int getModo(){
        return this.modo;
    }
    
    public long getTotal(){
        return this.total;
    }
    
    public long getStamp(){
        return this.stamp;
    }
    
    public void setTotal(long total){
        this.total=total;
    }
    
    public void lampON(){
        this.atualizaConsumo();
        this.modo=1;
    }
    
    public void lampOFF(){
        this.atualizaConsumo();
        this.modo=0;
    }
    
    public void lampECO(){
        this.modo=2;
    }
    
    public double periodoConsumo(){
        return total;
    }
    
    public void atualizaConsumo(){
        long periodo = System.currentTimeMillis()-stamp;
        if(this.modo==1){
            this.total += consumoNormal*periodo;
        }else if(this.modo == 2){
            this.total +=consumoEco*periodo;
        }
        this.stamp = System.currentTimeMillis();
    }
    
    public Lampada clone(){
        return new Lampada(this);
    }
}
