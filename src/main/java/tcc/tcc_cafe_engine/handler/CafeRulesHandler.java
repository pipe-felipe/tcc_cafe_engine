package tcc.tcc_cafe_engine.handler;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import tcc.tcc_cafe_engine.model.CustomerModel;
import tcc.tcc_cafe_engine.model.dto.CafeDTO;
import tcc.tcc_cafe_engine.rules.email.EmailRulesDefinition;

import java.io.IOException;
import java.util.Objects;


public class CafeRulesHandler {

    private CafeDTO createDTO(CustomerModel customer) {
        var dto = new CafeDTO();

        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        dto.setDocument(customer.getDocument());
        dto.setCreditCard(customer.getCreditCard());
        dto.setAddress(customer.getAddress());
        dto.setBirthDate(customer.getBirthDate());
        dto.setAge(customer.getAge());
        dto.setTransactionValue(customer.getTransactionValue());

        return dto;
    }

    private CafeDTO executeRules(CustomerModel customer) {
        var dto = this.createDTO(customer);
        var mapResult = EmailRulesDefinition.randomRuleForTest(customer);
        dto.setTransactionStatus(mapResult.get("status"));
        dto.setTransactionMessage(mapResult.get("message"));
        return dto;
    }

    private StringEntity createJsonStringEntity(CustomerModel customer) {
        var dto = this.executeRules(customer);
        var gson = new Gson();
        var jsonRequest = gson.toJson(dto);

        return new StringEntity(
                jsonRequest,
                ContentType.APPLICATION_JSON
        );
    }

    public void sendTransactionalData(CustomerModel customer) throws IOException {

        StringEntity entity = this.createJsonStringEntity(customer);
        HttpClient httpCLient = HttpClientBuilder.create().build();

        if (Objects.equals(customer.getSentMethod(), "POST")) {
            var request = new HttpPost("http://localhost:8080/customer/engine");
            request.setEntity(entity);
            HttpResponse response = httpCLient.execute(request);
            System.out.println(response.getStatusLine().getStatusCode());
            response.setEntity(entity);
        } else {
            String url = "http://localhost:8080/customer/cafe/" + customer.getDocument();
            System.out.println(url);
            var request = new HttpPut(url);
            request.setEntity(entity);
            HttpResponse response = httpCLient.execute(request);
            System.out.println(response.getStatusLine().getStatusCode());
            response.setEntity(entity);
        }
    }
}
