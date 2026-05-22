package cloud.fractal.book.fractal.components.storage.paas;

import cloud.fractal.book.fractal.Offer;
import cloud.fractal.book.values.InfrastructureDomain;
import cloud.fractal.book.values.PascalCaseString;
import cloud.fractal.book.values.ServiceDeliveryModel;
import cloud.fractal.book.values.Version;

import java.util.List;

public abstract class ObjectStorage extends Offer {
    public final static Offer.Type TYPE = new Offer.Type(InfrastructureDomain.STORAGE, ServiceDeliveryModel.PAAS, new PascalCaseString("ObjectStorage"));
    public final static Version VERSION = new Version(1,0,0);

    public ObjectStorage(
            Id id,
            String displayName,
            String description,
            Parameters parameters,
            OutputFields outputFields,
            List<Link> links,
            List<Dependency> dependencies)
    {
        super(id, VERSION, displayName, description, parameters, outputFields, links, dependencies);
    }

    @Override
    public Type getType() {
        return TYPE;
    }
}
