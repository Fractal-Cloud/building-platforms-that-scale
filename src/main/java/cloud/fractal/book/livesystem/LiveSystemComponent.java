package cloud.fractal.book.livesystem;

import cloud.fractal.book.Component;

public interface LiveSystemComponent extends Component {
    Status getStatus();

    enum Status {
        INSTANTIATING,
        ACTIVE,
        MUTATING,
        DELETING,
        FAILED
    }
}