import java.util.Iterator;
import java.util.List;
import enums.*;
import operator.Operator;

/**
 * created by Kimone
 * date 2020/8/29
 */
public class SQLGenerator {
    public String getSql(String beQueriedEntityName, List<SingleCondition> conditions, List<ConnectorEnum> connectors)  {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("select * from "+ beQueriedEntityName.toLowerCase() + " where ");

        // 获取被查询的实体类
        Class entityClass = null;
        try {
             entityClass = Class.forName("entity."+beQueriedEntityName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Iterator<ConnectorEnum> iterator = connectors.iterator();

        // 拼接每一个查询条件
        for(SingleCondition singleCondition: conditions) {
            String operatorClassname = singleCondition.getOperatorEnum().getOperatorClassname();
            Operator operator = null;
            try {
                operator = (Operator) Class.forName(operatorClassname).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            boolean isString = false;
            try {
                Class fieldType = entityClass.getDeclaredField(singleCondition.getLeftHand()).getType();
                if(fieldType == String.class) isString = true;
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            sqlBuilder.append(operator.generateSQL(singleCondition.getLeftHand(), isString, singleCondition.getRightHand()));
            if(iterator.hasNext()) {
                ConnectorEnum connectorEnum = iterator.next();
                sqlBuilder.append(" "+connectorEnum.getConnectorName()+" ");
            }
        }
        return sqlBuilder.toString();
    }

}
