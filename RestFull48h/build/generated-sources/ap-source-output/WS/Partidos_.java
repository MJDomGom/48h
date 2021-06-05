package WS;

import WS.Estadisticas;
import WS.Instalaciones;
import WS.Jugados;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2021-06-05T18:02:42")
@StaticMetamodel(Partidos.class)
public class Partidos_ { 

    public static volatile SingularAttribute<Partidos, Date> fecha;
    public static volatile SingularAttribute<Partidos, String> resultado;
    public static volatile CollectionAttribute<Partidos, Estadisticas> estadisticasCollection;
    public static volatile CollectionAttribute<Partidos, Instalaciones> instalacionesCollection;
    public static volatile SingularAttribute<Partidos, String> visitante;
    public static volatile SingularAttribute<Partidos, Integer> idPartido;
    public static volatile CollectionAttribute<Partidos, Jugados> jugadosCollection;
    public static volatile SingularAttribute<Partidos, String> local;

}