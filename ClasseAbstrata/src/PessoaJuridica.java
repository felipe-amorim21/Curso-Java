public class PessoaJuridica extends Pessoa{
    private Integer numeroFuncionarios;

    public PessoaJuridica(String nome, Double rendaAnual, Integer numeroFuncionarios) {
        super(nome, rendaAnual);
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public Integer getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    public void setNumeroFuncionarios(Integer numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }

    @Override
    public Double taxes() {
        if(this.getNumeroFuncionarios() > 10){
            return (this.getRendaAnual() * 0.14);
        }
        else {
            return (this.getRendaAnual() * 0.16);
        }
    }
}
