package tcc.tcc_cafe_engine.handler;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import tcc.tcc_cafe_engine.model.CustomerModel;
import tcc.tcc_cafe_engine.model.dto.CafeDTO;
import tcc.tcc_cafe_engine.rules.email.EmailRulesHandler;
import org.apache.http.client.methods.HttpPost;

import java.io.IOException;


public class CafeRulesHandler {

    private CafeDTO DTOHandler(CustomerModel customer){
        var dto = new CafeDTO();

        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        dto.setDocument(customer.getDocument());
        dto.setCreditCard(customer.getCreditCard());
        dto.setAddress(customer.getAddress());
        dto.setAge(customer.getAge());
        dto.setTransactionValue(customer.getTransactionValue());

        return dto;
    }

    public void cafeEngineHandler(CustomerModel customer) throws IOException {

        var dto = this.DTOHandler(customer);

        dto.setTransactionStatus(EmailRulesHandler.reproveByEmail(customer).toString());

        var gson = new Gson();
        var jsonRequest = gson.toJson(dto);

        var entity = new StringEntity(
                jsonRequest,
                ContentType.APPLICATION_JSON
        );

        HttpClient httpCLient = HttpClientBuilder.create().build();
        var request = new HttpPost("http://localhost:8080/customer/engine");
        request.setEntity(entity);

        HttpResponse response = httpCLient.execute(request);
        System.out.println(response.getStatusLine().getStatusCode());
        response.setEntity(entity);
    }
}
