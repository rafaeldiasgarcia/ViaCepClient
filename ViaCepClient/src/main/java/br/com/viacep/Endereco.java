package br.com.viacep;

public class Endereco {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ddd;
    private boolean erro;

    public Endereco() {
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public String getDdd() {
        return ddd;
    }

    public boolean isErro() {
        return erro;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public void setErro(boolean erro) {
        this.erro = erro;
    }

    @Override
    public String toString() {
        return "\n--- Resultado da Consulta ---\n" +
                "CEP: " + cep + "\n" +
                "Logradouro: " + logradouro + "\n" +
                "Complemento: " + (complemento.isEmpty() ? "N/A" : complemento) + "\n" +
                "Bairro: " + bairro + "\n" +
                "Cidade/UF: " + localidade + "/" + uf + "\n" +
                "DDD: " + ddd + "\n" +
                "-----------------------------\n";
    }
}