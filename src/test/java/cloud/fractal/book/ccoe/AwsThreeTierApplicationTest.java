package cloud.fractal.book.ccoe;

import cloud.fractal.book.values.KebabCaseString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("AWS Three-Tier Application — assembled from the SDK")
class AwsThreeTierApplicationTest {

    @Test
    @DisplayName("builds the LiveSystem and exposes the ThreeTierApplication interface")
    void awsThreeTierApplicationIsAssembled() {
        var boundedContextId = BoundedContexts.ReusableTemplates.getBoundedContextId();
        var environmentId = Environments.Test.getEnvironmentId();

        var liveSystem = new AwsThreeTierApplication(
                boundedContextId,
                new KebabCaseString("aws-three-tier-app"),
                "AWS Three-Tier App",
                "Reference three-tier application on AWS",
                environmentId);

        assertThat(liveSystem).isNotNull();
        assertThat(liveSystem.getDisplayName()).isEqualTo("AWS Three-Tier App");
        assertThat(liveSystem.getEnvironmentId()).isEqualTo(environmentId);
        assertThat(liveSystem.getFractal()).isInstanceOf(ThreeTierApplication.class);
        assertThat(liveSystem.getOperations()).isNotNull();
    }
}
