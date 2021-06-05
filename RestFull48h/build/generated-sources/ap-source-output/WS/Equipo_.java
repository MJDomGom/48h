package WS;

import WS.Integrante;
import WS.Jugados;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2021-06-05T18:02:42")
@StaticMetamodel(Equipo.class)
public class Equipo_ { 

    public static volatile CollectionAttribute<Equipo, Jugados> jugadosCollection;
    public static volatile SingularAttribute<Equipo, String> nomCorto;
    public static volatile SingularAttribute<Equipo, String> nombre;
    public static volatile CollectionAttribute<Equipo, Integrante> integranteCollection;

}