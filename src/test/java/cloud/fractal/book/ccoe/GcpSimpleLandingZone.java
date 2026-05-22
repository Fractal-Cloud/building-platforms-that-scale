package cloud.fractal.book.ccoe;

import cloud.fractal.book.Component;
import cloud.fractal.book.ComponentBase;
import cloud.fractal.book.Environment;
import cloud.fractal.book.fractal.components.security.paas.CertificateAuthorityComponent;
import cloud.fractal.book.livesystem.LiveSystem;
import cloud.fractal.book.livesystem.components.security.paas.GcpCasCertificateAuthority;

public class GcpSimpleLandingZone extends LiveSystem<SimpleLandingZone> {
    public GcpSimpleLandingZone(
            Id id,
            String displayName,
            String description,
            Environment.Id environmentId,
            SimpleLandingZone fractal)
    {
        super(id, displayName, description, environmentId, fractal);
    }

    public static CertificateAuthorityComponent getCertificateAuthorityComponent(Component.Id id, String displayName, String description, CertificateAuthorityComponent.Subject subject) {
        return new GcpCasCertificateAuthority(
                id,
                displayName,
                description,
                new ComponentBase.Parameters(),
                new GcpCasCertificateAuthority.Configuration(subject));
    }
}
