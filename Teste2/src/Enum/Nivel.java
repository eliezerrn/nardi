package Enum;

public enum Nivel {
    JUNIOR (1, "Junior"),
    PLENO (2, "Pleno"),
    SENIOR (3, "Senior");

    Nivel(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public final Integer id;

    public final String descricao;

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return  id + " - " +  descricao;
    }
}
