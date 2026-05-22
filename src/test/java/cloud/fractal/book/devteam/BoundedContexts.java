package cloud.fractal.book.devteam;

import cloud.fractal.book.BoundedContext;
import cloud.fractal.book.values.KebabCaseString;
import cloud.fractal.book.values.OwnerType;
import lombok.Getter;

import static cloud.fractal.book.devteam.Constants.DEV_TEAM_OWNER_ID;

@Getter
enum BoundedContexts {
    Sales(new KebabCaseString("sales"));

    private final BoundedContext.Id boundedContextId;

    BoundedContexts(KebabCaseString name) {
        this.boundedContextId = new BoundedContext.Id(OwnerType.ORGANIZATIONAL, DEV_TEAM_OWNER_ID, name);
    }
}
