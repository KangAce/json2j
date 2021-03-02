package fun.imore.json2j;

import fun.imore.json2j.service.ParseService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;

@SpringBootTest
class Json2jApplicationTests {
    @Resource
    private ParseService parseService;
    @Test
    void contextLoads() throws IOException {
            parseService.setPackName("fun.imore.json2j.service");
            parseService.setFilePath("F:\\workspace\\github\\json2j\\src\\main\\java\\fun\\imore\\json2j\\service\\");
            parseService.jsonText2j("{a:1,b:'true',contents:{},lists:[]}");
    }

}
