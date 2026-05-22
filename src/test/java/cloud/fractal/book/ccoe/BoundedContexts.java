package cloud.fractal.book.ccoe;

import cloud.fractal.book.BoundedContext;
import cloud.fractal.book.values.KebabCaseString;
import cloud.fractal.book.values.OwnerType;
import lombok.Getter;

import static cloud.fractal.book.ccoe.Constants.CCOE_OWNER_ID;

@Getter
enum BoundedContexts {
    ReusableTemplates(new KebabCaseString("reusable-templates"));

    private final BoundedContext.Id boundedContextId;

    BoundedContexts(KebabCaseString name) {
        this.boundedContextId = new BoundedContext.Id(OwnerType.ORGANIZATIONAL, CCOE_OWNER_ID, name);
    }
}
