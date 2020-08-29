package enums;

/**
 * created by Kimone
 * date 2020/8/29
 */
public enum OperatorEnum {
    Equal{
        @Override
        public String getOperatorClassname() {
            return "operator.EqualOperator";
        }
    },
    NotEqual{
        @Override
        public String getOperatorClassname() {
            return "operator.NotEqualOperator";
        }
    },
    In{
        @Override
        public String getOperatorClassname() {
            return "operator.InOperator";
        }
    },
    Like{
        @Override
        public String getOperatorClassname() {
            return "operator.LikeOperator";
        }
    },
    Null{
        @Override
        public String getOperatorClassname() {
            return "operator.NullOperator";
        }
    },
    NotNull{
        @Override
        public String getOperatorClassname() {
            return "operator.NotNullOperator";
        }
    };



    public abstract String getOperatorClassname();
}
