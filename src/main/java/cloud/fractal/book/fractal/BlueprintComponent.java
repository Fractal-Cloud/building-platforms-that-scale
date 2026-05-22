package cloud.fractal.book.fractal;

import cloud.fractal.book.ComponentBase;
import cloud.fractal.book.values.InfrastructureDomain;
import cloud.fractal.book.values.PascalCaseString;
import cloud.fractal.book.values.ServiceDeliveryModel;
import cloud.fractal.book.values.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
public class BlueprintComponent extends ComponentBase
{
    private final List<Service> services;
    private final Type type;

    public BlueprintComponent(
            Id id,
            Version version,
            Type type,
            String displayName,
            String description,
            Parameters parameters,
            OutputFields outputFields,
            List<Link> links,
            List<Dependency> dependencies,
            List<Service> services)
    {
        super(id,  version, displayName, description, parameters, outputFields, links, dependencies);
        this.type = type;
        this.services = services;
    }

    public record Dependency(
            Type componentType,
            Id id) implements ComponentBase.Dependency { }

    @Getter
    @AllArgsConstructor
    public static class Service {
        private Type type;
        private List<Offer> offers;

        public record Type(
                InfrastructureDomain domain,
                ServiceDeliveryModel serviceDeliveryModel,
                PascalCaseString name) implements ComponentBase.Type { }
    }
}