package cloud.fractal.book.ccoe;

import cloud.fractal.book.Component;
import cloud.fractal.book.fractal.components.customworkload.faas.CustomFunctionWorkload;
import cloud.fractal.book.fractal.components.customworkload.paas.CustomPaaSWorkload;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Three-Tier Application Fractal — authored by CCoE")
class ThreeTierApplicationTest {

    @Test
    @DisplayName("publishes the expected type, version, and a non-null Blueprint")
    void threeTierApplicationFractalIsAuthored() {
        var boundedContextId = BoundedContexts.ReusableTemplates.getBoundedContextId();

        var fractal = new ThreeTierApplication(
                boundedContextId,
                "Three-Tier Application",
                "Reference three-tier application pattern",
                new ThreeTierApplication.Interface() {
                    @Override
                    public ThreeTierApplication.Interface withDatabase(Component component) { return this; }
                    @Override
                    public ThreeTierApplication.Interface withFunctionWorkload(CustomFunctionWorkload component) { return this; }
                    @Override
                    public ThreeTierApplication.Interface withPaaSWorkload(CustomPaaSWorkload component) { return this; }
                });

        assertThat(fractal).isNotNull();
        assertThat(fractal.getDisplayName()).isEqualTo("Three-Tier Application");
        assertThat(fractal.getVersion()).isEqualTo(ThreeTierApplication.VERSION);
        assertThat(fractal.getType()).isEqualTo(ThreeTierApplication.TYPE);
        assertThat(fractal.getBlueprint()).isNotNull();
        assertThat(fractal.getOperations()).isNotNull();
    }
}
