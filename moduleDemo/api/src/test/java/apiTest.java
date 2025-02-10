import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.demo.ApiMain;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
@Slf4j
@SpringBootTest(classes = ApiMain.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class apiTest {
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    WebApplicationContext webApplicationContext;

//    @Autowired
//ApiController controller;
//    @Autowired
//    CoreDemo core;
//    @Autowired
//    MessageDemo msgDemo;
@BeforeEach
void setup() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
}
    @Test
    public void apiTest(){
        String uri = "/api/demo";

        JSONObject request = new JSONObject();
        String response = null;
        try {
            MvcResult result = mockMvc
                    .perform(MockMvcRequestBuilders.get(uri).content(request.toString())
                            .accept(MediaType.APPLICATION_JSON))
                    .andReturn();
            log.info("result.getResponse: " + result.getResponse().getContentAsString());


            log.info("response: " + response);

        } catch (Exception e) {

            log.error("testGetUserKYC error", e);
        }






    }
}
