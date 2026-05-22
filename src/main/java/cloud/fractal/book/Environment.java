package cloud.fractal.book;

import cloud.fractal.book.livesystem.LiveSystemComponent;
import cloud.fractal.book.values.KebabCaseString;
import cloud.fractal.book.values.OwnerId;
import cloud.fractal.book.values.OwnerType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Environment {
    private final Id id;
    private String displayName;
    private String description;
    private final List<LiveSystemComponent> components;
    private final List<BoundedContext.Id> allowedContexts;

    public record Id(
            OwnerType ownerType,
            OwnerId ownerId,
            KebabCaseString name) { }
}