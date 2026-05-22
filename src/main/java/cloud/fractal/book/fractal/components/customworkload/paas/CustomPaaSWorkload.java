package cloud.fractal.book.fractal.components.customworkload.paas;

import cloud.fractal.book.fractal.components.customworkload.GitCustomWorkload;
import cloud.fractal.book.values.Version;

import java.util.Collection;

public abstract class CustomPaaSWorkload extends GitCustomWorkload {
    public CustomPaaSWorkload(
            Id id,
            Version version,
            String displayName,
            String description,
            Parameters parameters,
            OutputFields outputFields,
            Collection<Link> links,
            Collection<Dependency> dependencies,
            GitCustomWorkloadConfiguration configuration) {
        super(id, version, displayName, description, parameters, outputFields, links, dependencies, configuration);
    }
}
