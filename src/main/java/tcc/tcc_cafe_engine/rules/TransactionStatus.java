package tcc.tcc_cafe_engine.rules;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class TransactionStatus {

    private String returnMessage;
    private enum messages {
        APPROVE,
        REPROVE,
        MESSAGE
    }
}
