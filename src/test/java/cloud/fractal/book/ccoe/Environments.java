package cloud.fractal.book.ccoe;

import cloud.fractal.book.Environment;
import cloud.fractal.book.values.KebabCaseString;
import cloud.fractal.book.values.OwnerType;
import lombok.Getter;

import static cloud.fractal.book.ccoe.Constants.CCOE_OWNER_ID;

@Getter
public enum Environments {
    Production(new KebabCaseString("production")),
    Test(new KebabCaseString("test"));

    private final Environment.Id environmentId;

    Environments(KebabCaseString name) {
        this.environmentId = new Environment.Id(OwnerType.ORGANIZATIONAL, CCOE_OWNER_ID, name);
    }
}
