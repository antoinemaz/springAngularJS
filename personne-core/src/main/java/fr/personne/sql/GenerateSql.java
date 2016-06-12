package fr.personne.sql;

import java.util.EnumSet;
import java.util.Set;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.reflections.Reflections;

import fr.anto.entities.Entity;

public class GenerateSql {

	public static void main(String[] args) {

	    MetadataSources metadata = new MetadataSources(
	            new StandardServiceRegistryBuilder()
	                    .applySetting("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect")
	                    .build());

	    Reflections reflections = new Reflections("fr.personne.entities");
	    
	    Set<Class<? extends Entity>> allClasses = 
	    	     reflections.getSubTypesOf(Entity.class);
	    
	    for (Class<? extends Entity> clazz : allClasses) {
	    	metadata.addAnnotatedClass(clazz);
		}
	    
        EnumSet<TargetType> targetTypes = EnumSet.of(TargetType.STDOUT);

        SchemaExport export = new SchemaExport();

        export.setDelimiter(";");
        export.setFormat(true);

        export.createOnly(targetTypes, metadata.buildMetadata());
	}
}