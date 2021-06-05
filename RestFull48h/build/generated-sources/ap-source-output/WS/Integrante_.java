package WS;

import WS.Equipo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2021-06-04T00:49:25")
@StaticMetamodel(Integrante.class)
public class Integrante_ { 

    public static volatile SingularAttribute<Integrante, String> apellidos;
    public static volatile SingularAttribute<Integrante, Integer> dorsal;
    public static volatile SingularAttribute<Integrante, Equipo> nombreEquipo;
    public static volatile SingularAttribute<Integrante, String> nombre;
    public static volatile SingularAttribute<Integrante, String> dni;

}