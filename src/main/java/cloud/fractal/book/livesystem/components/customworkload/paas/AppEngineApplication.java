package cloud.fractal.book.livesystem.components.customworkload.paas;

import cloud.fractal.book.fractal.Offer;
import cloud.fractal.book.fractal.Provider;
import cloud.fractal.book.fractal.components.customworkload.paas.CustomPaaSWorkload;
import cloud.fractal.book.livesystem.LiveSystemComponent;
import cloud.fractal.book.values.InfrastructureDomain;
import cloud.fractal.book.values.PascalCaseString;
import cloud.fractal.book.values.ServiceDeliveryModel;
import cloud.fractal.book.values.Version;

import java.util.Collection;

public class AppEngineApplication extends CustomPaaSWorkload implements LiveSystemComponent {
    public final static Offer.Type TYPE = new Offer.Type(InfrastructureDomain.CUSTOM_WORKLOAD, ServiceDeliveryModel.PAAS, new PascalCaseString("AppEngineApplication"));
    private final Status status;

    public AppEngineApplication(
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
        status = Status.INSTANTIATING;
    }

    @Override
    public Provider getProvider() {
        return Provider.GCP;
    }

    @Override
    public Offer.Type getType() {
        return TYPE;
    }

    @Override
    public LiveSystemComponent getInstantiatingLiveSystemComponent() {
        return this;
    }

    @Override
    public Status getStatus() {
        return status;
    }
}
