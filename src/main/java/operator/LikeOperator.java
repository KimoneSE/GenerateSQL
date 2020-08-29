package operator;

import java.util.List;

/**
 * created by Kimone
 * date 2020/8/29
 */
public class LikeOperator implements Operator {
    @Override
    public String generateSQL(String attributeName, boolean isString, List limitValues) {
        String rightHand = String.format("'%s'", limitValues.get(0));
        return attributeName + " like " + rightHand;
    }
}
