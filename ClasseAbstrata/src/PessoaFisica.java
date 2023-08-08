public class PessoaFisica extends Pessoa{
    private Double gastosSaude;

    public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
        super(nome, rendaAnual);
        this.gastosSaude = gastosSaude;
    }

    public Double getGastosSaude() {
        return gastosSaude;
    }

    public void setGastosSaude(Double gastosSaude) {
        this.gastosSaude = gastosSaude;
    }

    @Override
    public Double taxes() {
        if(this.getRendaAnual() > 20000.00){
            return (this.getRendaAnual() * 0.25) - (this.getGastosSaude() * 0.5);
        }
        else {
            return (this.getRendaAnual() * 0.15) - (this.getGastosSaude() * 0.5);
        }
    }
}
