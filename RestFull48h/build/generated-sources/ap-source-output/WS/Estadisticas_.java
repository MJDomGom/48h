package WS;

import WS.Partidos;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2021-06-04T00:49:25")
@StaticMetamodel(Estadisticas.class)
public class Estadisticas_ { 

    public static volatile SingularAttribute<Estadisticas, Integer> amarillas;
    public static volatile SingularAttribute<Estadisticas, Integer> rojas;
    public static volatile SingularAttribute<Estadisticas, Integer> azules;
    public static volatile SingularAttribute<Estadisticas, Partidos> idPartido;
    public static volatile SingularAttribute<Estadisticas, Integer> id;
    public static volatile SingularAttribute<Estadisticas, Integer> golesTot;
    public static volatile SingularAttribute<Estadisticas, Integer> tirosPuerta;

}