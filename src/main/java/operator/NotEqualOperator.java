package operator;

import java.util.List;

/**
 * created by Kimone
 * date 2020/8/29
 */
public class NotEqualOperator implements Operator {
    @Override
    public String generateSQL(String attributeName, boolean isString, List limitValues) {
        Object limitValue = limitValues.get(0);
        String rightHand = isString ? String.format("'%s'", limitValue) : String.valueOf(limitValue);
        return attributeName + "<>" + rightHand;
    }
}
