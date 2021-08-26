package y.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import y.MyJhipsterApp;

@CucumberContextConfiguration
@SpringBootTest(classes = MyJhipsterApp.class)
@WebAppConfiguration
public class CucumberTestContextConfiguration {}
