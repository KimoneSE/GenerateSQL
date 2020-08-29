import enums.ConnectorEnum;
import enums.OperatorEnum;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * created by Kimone
 * date 2020/8/29
 */
public class GenerateSQLTest {

    private SQLGenerator sqlGenerator = new SQLGenerator();

    @Test
    public void testEqual() {
        List<SingleCondition> singleConditions = new ArrayList<>();
        singleConditions.add(new SingleCondition("id", OperatorEnum.Equal, Arrays.asList("1")));
        String actualSql = sqlGenerator.getSql("Customer", singleConditions, new ArrayList<>());

        assertEquals("select * from customer where id='1'", actualSql);
    }

    @Test
    public void testNotEqual() {
        List<SingleCondition> singleConditions = new ArrayList<>();
        singleConditions.add(new SingleCondition("id", OperatorEnum.NotEqual, Arrays.asList("1")));
        String actualSql = sqlGenerator.getSql("Customer", singleConditions, new ArrayList<>());

        assertEquals("select * from customer where id<>'1'", actualSql);
    }

    @Test
    public void testIn() {
        List<SingleCondition> singleConditions = new ArrayList<>();
        singleConditions.add(new SingleCondition("companyName", OperatorEnum.In, Arrays.asList("Huawei","HTSC","Apple")));
        String actualSql = sqlGenerator.getSql("Customer", singleConditions, new ArrayList<>());

        assertEquals("select * from customer where companyName in ('Huawei', 'HTSC', 'Apple')", actualSql);
    }

    @Test
    public void testLike() {
        List<SingleCondition> singleConditions = new ArrayList<>();
        singleConditions.add(new SingleCondition("companyName", OperatorEnum.Like, Arrays.asList("HT%")));
        String actualSql = sqlGenerator.getSql("Customer", singleConditions, new ArrayList<>());

        assertEquals("select * from customer where companyName like 'HT%'", actualSql);
    }

    @Test
    public void testNull() {
        List<SingleCondition> singleConditions = new ArrayList<>();
        singleConditions.add(new SingleCondition("contactName", OperatorEnum.Null, new ArrayList()));
        String actualSql = sqlGenerator.getSql("Customer", singleConditions, new ArrayList<>());

        assertEquals("select * from customer where contactName is null", actualSql);
    }

    @Test
    public void testNotNull() {
        List<SingleCondition> singleConditions = new ArrayList<>();
        singleConditions.add(new SingleCondition("contactName", OperatorEnum.NotNull, new ArrayList()));
        String actualSql = sqlGenerator.getSql("Customer", singleConditions, new ArrayList<>());

        assertEquals("select * from customer where contactName is not null", actualSql);
    }

    @Test
    public void testMultiCondition_and() {
        List<SingleCondition> singleConditions = new ArrayList<>();
        singleConditions.add(new SingleCondition("id", OperatorEnum.Equal, Arrays.asList("1")));
        singleConditions.add(new SingleCondition("postalCode", OperatorEnum.NotEqual, Arrays.asList(3)));
        String actualSql = sqlGenerator.getSql("Customer",
                singleConditions, Arrays.asList(ConnectorEnum.AND));

        assertEquals("select * from customer where id='1' and postalCode<>3", actualSql);
    }

    @Test
    public void testMultiCondition_or() {
        List<SingleCondition> singleConditions = new ArrayList<>();
        singleConditions.add(new SingleCondition("id", OperatorEnum.Equal, Arrays.asList("1")));
        singleConditions.add(new SingleCondition("postalCode", OperatorEnum.NotEqual, Arrays.asList(3)));
        String actualSql = sqlGenerator.getSql("Customer",
                singleConditions, Arrays.asList(ConnectorEnum.OR));

        assertEquals("select * from customer where id='1' or postalCode<>3", actualSql);
    }

    @Test
    public void testMultiCondition_complex() {
        List<SingleCondition> singleConditions = new ArrayList<>();
        singleConditions.add(new SingleCondition("id", OperatorEnum.Equal, Arrays.asList("1")));
        singleConditions.add(new SingleCondition("postalCode", OperatorEnum.Equal, Arrays.asList(3)));
        singleConditions.add(new SingleCondition("companyName", OperatorEnum.In, Arrays.asList("Huawei","HTSC","Apple")));
        singleConditions.add(new SingleCondition("region", OperatorEnum.NotNull, new ArrayList()));
        String actualSql = sqlGenerator.getSql("Customer",
                singleConditions, Arrays.asList(ConnectorEnum.AND, ConnectorEnum.OR, ConnectorEnum.AND));

        assertEquals("select * from customer where id='1' and postalCode=3 or " +
                "companyName in ('Huawei', 'HTSC', 'Apple') and region is not null", actualSql);
    }

}
