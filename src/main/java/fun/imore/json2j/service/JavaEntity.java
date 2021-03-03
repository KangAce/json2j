package fun.imore.json2j.service;

import cn.hutool.core.collection.CollectionUtil;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class JavaEntity {
    private String packName;
    private List<String> imports;
    private List<String> annotations;
    private String fileName = "Entity";
    private String className = "Entity";

    /**
     * 字段
     */
    private List<FieldEntity> fields;

    public StringBuilder generate() {
        /**
         * Java文件的准备
         */
        StringBuilder stringBuilder = new StringBuilder();
        /**
         * 初始化包信息
         */
        stringBuilder.append("package ").append(packName).append(";\n");
        stringBuilder.append("\n");
        /**
         * 初始化导入信息
         */
        for (String anImport : imports) {
            stringBuilder.append("import " + anImport + ";\n");
        }
        stringBuilder.append("\n");

        /**
         * 初始化注解信息
         */
        for (String annotation : annotations) {
            stringBuilder.append(annotation + "\n");
        }
        /**
         * 初始化类信息
         */
        stringBuilder.append("public class ").append(className).append(" {\n");
        stringBuilder.append("\n");
        /**
         * 生成字段
         */
        for (FieldEntity field : fields) {
            stringBuilder.append(field.generate()).append("\n");
        }

        stringBuilder.append("}\n");
         return stringBuilder;
    }

    /**
     * Java文件的包信息
     *
     * @return
     */
    public JavaEntity packName(String packName) {
        this.packName = packName;
        return this;
    }

    /**
     * import信息
     *
     * @return
     */
    public JavaEntity importAdd(String importInfo) {
        if (CollectionUtil.isEmpty(this.imports)) {
            this.imports = new ArrayList<>();
        }
        this.imports.add(importInfo);
        return this;
    }
    /**
     * import信息
     *
     * @return
     */
    public JavaEntity annotationAdd(String annotationInfo) {
        if (CollectionUtil.isEmpty(this.annotations)) {
            this.annotations = new ArrayList<>();
        }
        this.annotations.add(annotationInfo);
        return this;
    }

    /**
     * fileName
     *
     * @return
     */
    public JavaEntity fileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    /**
     * className
     *
     * @return
     */
    public JavaEntity className(String className) {
        this.className = className;
        return this;
    }

    /**
     * fieldAdd
     *
     * @return
     */
    public JavaEntity fieldAdd(FieldEntity fieldEntity) {
        if (CollectionUtil.isEmpty(this.fields)) {
            this.fields = new ArrayList<>();
        }
        this.fields.add(fieldEntity);
        return this;
    }

    /**
     * className
     *
     * @return
     */
    public JavaEntity field(List<FieldEntity> field) {
        if (CollectionUtil.isEmpty(this.fields)) {
            this.fields = new ArrayList<>();
        }
        this.fields.addAll(field);
        return this;
    }


}