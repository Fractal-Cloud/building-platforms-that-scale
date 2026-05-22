package cloud.fractal.book.ccoe;

import cloud.fractal.book.BoundedContext;
import cloud.fractal.book.Component;
import cloud.fractal.book.Environment;
import cloud.fractal.book.fractal.components.customworkload.GitCustomWorkload;
import cloud.fractal.book.fractal.components.customworkload.faas.CustomFunctionWorkload;
import cloud.fractal.book.fractal.components.customworkload.paas.CustomPaaSWorkload;
import cloud.fractal.book.livesystem.LiveSystem;
import cloud.fractal.book.livesystem.components.customworkload.faas.LambdaFunction;
import cloud.fractal.book.livesystem.components.customworkload.paas.ElasticBeanstalkApplication;
import cloud.fractal.book.values.KebabCaseString;

public class AwsThreeTierApplication extends LiveSystem<ThreeTierApplication> {
    public AwsThreeTierApplication(BoundedContext.Id boundendContextId, KebabCaseString name, String displayName, String description, Environment.Id environmentId) {
        var fractal = new ThreeTierApplication(
                boundendContextId,
                displayName,
                description,
                new ThreeTierApplication.Interface() {

                    @Override
                    public ThreeTierApplication.Interface withDatabase(Component component) {
                        return this;
                    }

                    @Override
                    public ThreeTierApplication.Interface withFunctionWorkload(CustomFunctionWorkload component) {
                        if (!(component instanceof LambdaFunction)) {
                            throw new IllegalArgumentException("Only Lambda Functions are supported");
                        }
                        return this;
                    }

                    @Override
                    public ThreeTierApplication.Interface withPaaSWorkload(CustomPaaSWorkload component) {
                        if (!(component instanceof ElasticBeanstalkApplication)) {
                            throw new IllegalArgumentException("Only Elastic Beanstalk Applications are supported");
                        }
                        return this;
                    }

                });
        super(new Id(boundendContextId, name), displayName, description, environmentId, fractal);
    }

    public ThreeTierApplication.Interface getOperations() {
        return this.getFractal().getOperations();
    }
}
