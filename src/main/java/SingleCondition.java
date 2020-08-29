import java.util.List;
import enums.OperatorEnum;

/**
 * created by Kimone
 * date 2020/8/29
 * 单个查询条件
 */
public class SingleCondition<T> {

    private String leftHand;

    private OperatorEnum operatorEnum;

    private List<T> rightHand;

    public SingleCondition(String leftHand, OperatorEnum operatorEnum, List<T> rightHand) {
        this.leftHand = leftHand;
        this.operatorEnum = operatorEnum;
        this.rightHand = rightHand;
    }

    public String getLeftHand() {
        return leftHand;
    }

    public void setLeftHand(String leftHand) {
        this.leftHand = leftHand;
    }

    public OperatorEnum getOperatorEnum() {
        return operatorEnum;
    }

    public void setOperatorEnum(OperatorEnum operatorEnum) {
        this.operatorEnum = operatorEnum;
    }

    public List<T> getRightHand() {
        return rightHand;
    }

    public void setRightHand(List<T> rightHand) {
        this.rightHand = rightHand;
    }


}
