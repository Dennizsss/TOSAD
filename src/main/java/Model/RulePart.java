package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Wik on 08/01/2017.
 */
public class RulePart {
    private Integer Id;
    private String name;
    private String tableName;
    private String columnName;
    private Integer notTag;
    private String operator;
    private String value;
    private String valueType;
    private Integer min;
    private Integer max;
    private String otherColumn;
    private String otherTable;
    private String ruleType;

    private String condition;
    private Integer sequence;

    public RulePart() {

    }

    public RulePart(Integer id, String name, String tableName, String columnName, Integer notTag, String operator, String value, String valueType, Integer min, Integer max, String otherColumn, String otherTable, String ruleType) {
        this(id, name, tableName, columnName, notTag, operator, value, valueType, min, max, otherColumn, otherTable, ruleType, null, null);
    }

    public RulePart(Integer id, String name, String tableName, String columnName, Integer notTag, String operator, String value, String valueType, Integer min, Integer max, String otherColumn, String otherTable, String ruleType, String condition, Integer sequence) {
        this.Id = id;
        this.name = name;
        this.tableName = tableName;
        this.columnName = columnName;
        this.notTag = notTag;
        this.operator = operator;
        this.value = value;
        this.valueType = valueType;
        this.min = min;
        this.max = max;
        this.otherColumn = otherColumn;
        this.otherTable = otherTable;
        this.ruleType = ruleType;
        this.condition = condition;
        this.sequence = sequence;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Integer getNotTag() {
        return notTag;
    }

    public void setNotTag(Integer notTag) {
        this.notTag = notTag;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public String getOtherColumn() {
        return otherColumn;
    }

    public void setOtherColumn(String otherColumn) {
        this.otherColumn = otherColumn;
    }

    public String getOtherTable() {
        return otherTable;
    }

    public void setOtherTable(String otherTable) {
        this.otherTable = otherTable;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}
