import com.talentoproductivo.model.AnaliticaLaboral;
import com.talentoproductivo.model.Habilidad;
import java.util.List;

public interface AnalizadorDatos {
    AnaliticaLaboral generarAnaliticaMercado();
    List<Habilidad> predecirHabilidadesFuturas();
}