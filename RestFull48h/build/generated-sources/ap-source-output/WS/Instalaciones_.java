package WS;

import WS.Partidos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2021-06-05T18:02:42")
@StaticMetamodel(Instalaciones.class)
public class Instalaciones_ { 

    public static volatile CollectionAttribute<Instalaciones, Partidos> partidosCollection;
    public static volatile SingularAttribute<Instalaciones, String> direccion;
    public static volatile SingularAttribute<Instalaciones, Integer> id;
    public static volatile SingularAttribute<Instalaciones, String> nombre;
    public static volatile SingularAttribute<Instalaciones, Integer> capacidad;

}