package cloud.fractal.book.ccoe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("AWS Simple Landing Zone — assembled from the SDK")
class AwsSimpleLandingZoneTest {

    @Test
    @DisplayName("builds with the expected display name, environment, and Fractal type")
    void awsSimpleLandingZoneIsAssembled() {
        var environmentId = Environments.Test.getEnvironmentId();

        var landingZone = AwsSimpleLandingZone.getLandingZone(environmentId);

        assertThat(landingZone).isNotNull();
        assertThat(landingZone.getDisplayName()).isEqualTo("AWS Landing Zone");
        assertThat(landingZone.getDescription()).isEqualTo("AWS Landing Zone");
        assertThat(landingZone.getEnvironmentId()).isEqualTo(environmentId);
        assertThat(landingZone.getFractal()).isInstanceOf(SimpleLandingZone.class);
        assertThat(landingZone.getId().boundedContextId())
                .isEqualTo(BoundedContexts.ReusableTemplates.getBoundedContextId());
    }
}
