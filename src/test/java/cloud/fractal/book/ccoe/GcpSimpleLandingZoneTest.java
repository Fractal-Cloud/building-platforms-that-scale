package cloud.fractal.book.ccoe;

import cloud.fractal.book.livesystem.LiveSystem;
import cloud.fractal.book.values.KebabCaseString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("GCP Simple Landing Zone — assembled from the SDK")
class GcpSimpleLandingZoneTest {

    @Test
    @DisplayName("builds with the expected identity and fractal binding")
    void gcpSimpleLandingZoneIsAssembled() {
        var boundedContextId = BoundedContexts.ReusableTemplates.getBoundedContextId();
        var environmentId = Environments.Test.getEnvironmentId();
        var fractal = new SimpleLandingZone(boundedContextId, compliantLiveSystems -> { });

        var landingZone = new GcpSimpleLandingZone(
                new LiveSystem.Id(boundedContextId, new KebabCaseString("gcp-landing-zone")),
                "GCP Landing Zone",
                "GCP Landing Zone",
                environmentId,
                fractal);

        assertThat(landingZone).isNotNull();
        assertThat(landingZone.getDisplayName()).isEqualTo("GCP Landing Zone");
        assertThat(landingZone.getEnvironmentId()).isEqualTo(environmentId);
        assertThat(landingZone.getFractal()).isSameAs(fractal);
        assertThat(landingZone.getId().boundedContextId()).isEqualTo(boundedContextId);
    }
}
