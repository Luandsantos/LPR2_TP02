package TP02;
import java.util.UUID;

public class Aluno {
    private String nome;
    private int idade;
    private String endereco;
    private UUID uuid;

    public String getNome() {
        return nome;
    }

    public void setNome(String n) {
        this.nome = n;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int i) {
        this.idade = i;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String e) {
        this.endereco = e;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID u) {
        this.uuid = u;
    }
}
