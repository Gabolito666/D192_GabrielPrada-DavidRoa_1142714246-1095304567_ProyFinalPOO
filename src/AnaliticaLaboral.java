import java.util.List;

public class AnaliticaLaboral {

    private List<Habilidad> habilidadesMasDemandadas;
    private List<Habilidad> predicciones6Meses;

    public AnaliticaLaboral(List<Habilidad> habilidadesMasDemandadas, List<Habilidad> predicciones6Meses) {
        this.habilidadesMasDemandadas = habilidadesMasDemandadas;
        this.predicciones6Meses = predicciones6Meses;
    }

    public List<Habilidad> getHabilidadesMasDemandadas() { return habilidadesMasDemandadas; }
    public List<Habilidad> getPredicciones6Meses() { return predicciones6Meses; }
}