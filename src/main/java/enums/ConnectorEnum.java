package enums;

/**
 * created by Kimone
 * date 2020/8/29
 */
public enum ConnectorEnum {
    AND("and"), OR("or");

    private String connectorName;

    ConnectorEnum(String connectorName){
        this.connectorName = connectorName;
    }

    public String getConnectorName() {
        return connectorName;
    }
}
