package operator;

import java.util.List;
import java.util.StringJoiner;

/**
 * created by Kimone
 * date 2020/8/29
 */
public class InOperator implements Operator {

    @Override
    public String generateSQL(String attributeName, boolean isString, List limitValues) {
        StringJoiner joiner = new StringJoiner(", ");
        limitValues.forEach(value->{
            if(isString) joiner.add("'"+value+"'");
            else joiner.add(String.valueOf(value));
        });
        String rightHand = String.format("(%s)", joiner.toString());
        return attributeName + " in " + rightHand;
    }
}
