package api;

import com.obprado.Application;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.Before;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

public abstract class AcceptanceTest {
    public static final int PORT = 8080;
    public static final String HOST = "http://localhost:" + PORT;
    protected HttpResponse response;
    protected String responseBody;
    private ConfigurableApplicationContext application;

    @Before
    public void setUp() throws Exception {
        application = SpringApplication.run(Application.class);
    }

    @After
    public void tearDown() throws Exception {
        application.close();
    }

    protected void whenWeMakeAGetRequestTo(final String uri) throws IOException {
        HttpUriRequest httpUriRequest = new HttpGet(HOST + uri);
        response = HttpClientBuilder.create().build().execute(httpUriRequest);
        responseBody = EntityUtils.toString(response.getEntity());
    }
}
