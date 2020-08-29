package operator;

import java.util.List;

/**
 * created by Kimone
 * date 2020/8/29
 */
public class NotNullOperator implements Operator {
    @Override
    public String generateSQL(String attributeName, boolean isString, List limitValues) {
        return attributeName + " is not null";
    }
}
