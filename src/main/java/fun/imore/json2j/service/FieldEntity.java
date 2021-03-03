package fun.imore.json2j.service;

import cn.hutool.core.collection.CollectionUtil;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class FieldEntity {
    private List<String> annotations;
    private String scope;
    /**
     * 这里可能要改成实体类，可以存放类型的包信息等，方便生成的时候直接添加到import中
     */
    private JavaEntity type;
    private String fieldName;

    public FieldEntity annotationAdd(String annotations){
        if (CollectionUtil.isEmpty(this.annotations)) {
            this.annotations = new ArrayList<>();
        }
        this.annotations.add(annotations);
        return this;
    }
    public StringBuilder generate(){
        StringBuilder stringBuilder = new StringBuilder();
        /**
         * 设置字段注解
         */
        for (String annotation : annotations) {
            stringBuilder.append("    ").append(annotation).append("\n");
        }

        /**
         * 设置字段作用域
         */
        stringBuilder.append("    private ").append(type.getClassName()).append(" ").append(fieldName).append(";\n");

        return stringBuilder;
    }
}
