package operator;

import java.util.List;

/**
 * created by Kimone
 * date 2020/8/29
 */
public interface Operator {

    /**
     *
     * @param attributeName 属性名称
     * @param isString 属性类型是否为String
     * @param limitValues
     * @return
     */
    String generateSQL(String attributeName, boolean isString, List limitValues);

}
