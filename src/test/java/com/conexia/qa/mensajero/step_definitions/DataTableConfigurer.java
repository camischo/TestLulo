package com.conexia.qa.mensajero.step_definitions;

import com.conexia.qa.mensajero.modelos.Usuario;
import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;

import java.util.Locale;
import java.util.Map;


/*
 * Maps datatables in feature files to custom domain objects.
 */
public class DataTableConfigurer implements TypeRegistryConfigurer {

    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry registry) {
        registry.defineDataTableType(new DataTableType(Usuario.class, new TableEntryTransformer<Usuario>() {
            @Override
            public Usuario transform(Map<String, String> entry) {
                return new Usuario(
                        entry.get("nombreEmpleado"),
                        entry.get("salarioEmpleado"),
                        entry.get("edadEmpleado"),
                        entry.get("idEmpleado")
                );
            }
        }));

    }


}