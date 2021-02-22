package fun.imore.json2j.service;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import java.util.List;

@Data
public class Entity {
    @JsonSetter("a")
    private Integer a;
    @JsonSetter("b")
    private String b;
    @JsonSetter("contents")
    private Object contents;
    @JsonSetter("lists")
    private List<Object> lists;
}
