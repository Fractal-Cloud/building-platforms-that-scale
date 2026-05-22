package cloud.fractal.book.devteam;

import cloud.fractal.book.ccoe.AwsSimpleLandingZone;
import cloud.fractal.book.ccoe.AwsThreeTierApplication;
import cloud.fractal.book.ccoe.Environments;
import cloud.fractal.book.values.KebabCaseString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Sales App — Dev Team consumes a CCoE Fractal")
class SalesAppTest {

    @Test
    @DisplayName("assembles the Sales App LiveSystem against the AWS Landing Zone")
    void salesAppIsAssembledFromCcoeFractals() {
        var environmentId = Environments.Test.getEnvironmentId();

        var landingZone = AwsSimpleLandingZone.getLandingZone(environmentId);
        var salesApp = new AwsThreeTierApplication(
                BoundedContexts.Sales.getBoundedContextId(),
                new KebabCaseString("sales-app"),
                "Sales App",
                "Sales application",
                environmentId);

        landingZone.getOperations().withCompliantLiveSystems(List.of(salesApp));

        assertThat(landingZone.getEnvironmentId()).isEqualTo(environmentId);
        assertThat(salesApp.getDisplayName()).isEqualTo("Sales App");
        assertThat(salesApp.getEnvironmentId()).isEqualTo(environmentId);
        assertThat(salesApp.getId().boundedContextId())
                .isEqualTo(BoundedContexts.Sales.getBoundedContextId());
        assertThat(salesApp.getOperations()).isNotNull();
    }
}
