package co.com.choucair.certification.EjercicioSoap.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import java.util.List;

import static co.com.choucair.certification.EjercicioSoap.utils.enums.SoapService.ADD_NUMBERS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddNumbers implements Task {
    private List<String> values;

    public AddNumbers(List<String> values){
        this.values = values;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(ADD_NUMBERS.toString())
                        .with(request -> request
                                .header("Content-Type","text/xml")
                                .header("Accept-Encoding", "gzip,deflate")
                                .body("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n" +
                                        "   <soapenv:Header/>\n" +
                                        "   <soapenv:Body>\n" +
                                        "      <tem:Add>\n" +
                                        "         <tem:intA>"+values.get(0) +"</tem:intA>\n" +
                                        "         <tem:intB>"+values.get(1) +"</tem:intB>\n" +
                                        "      </tem:Add>\n" +
                                        "   </soapenv:Body>\n" +
                                        "</soapenv:Envelope>")
                        )
        );
    }

    public static AddNumbers with(List<String> values) {
        return instrumented(AddNumbers.class, values);
    }
}
