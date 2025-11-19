import java.util.List;

public class BrechaHabilidades {

    private Usuario usuario;
    private List<Habilidad> habilidadesFaltantes;

    public BrechaHabilidades(Usuario usuario, List<Habilidad> habilidadesFaltantes) {
        this.usuario = usuario;
        this.habilidadesFaltantes = habilidadesFaltantes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Habilidad> getHabilidadesFaltantes() {
        return habilidadesFaltantes;
    }
}