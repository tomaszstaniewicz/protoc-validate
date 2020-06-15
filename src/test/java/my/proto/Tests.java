package my.proto;

import com.google.protobuf.Message;
import io.envoyproxy.pgv.ReflectiveValidatorIndex;
import io.envoyproxy.pgv.ValidationException;
import io.envoyproxy.pgv.ValidatorIndex;
import io.grpc.examples.helloworld.HelloRequest;
import java.util.Arrays;
import org.junit.Test;

public class Tests {

    @Test
    public void testIfValidationWorks() throws ValidationException {
        HelloRequest message = HelloRequest.newBuilder()
            //.addAllField1(Arrays.asList("text1", "text2"))
            .build();

        validate(message);
    }

    private static void validate(Message message) throws ValidationException {
        ValidatorIndex index = new ReflectiveValidatorIndex();
        // Assert that a message is valid
        index.validatorFor(message.getClass()).assertValid(message);
    }

}
