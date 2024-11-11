package utillity;

import com.thoughtworks.gauge.BeforeStep;
import com.thoughtworks.gauge.ExecutionContext;
import com.thoughtworks.gauge.Logger;
import java.util.Collections;
import java.util.List;


public class LogInfo {

    @BeforeStep
    public void beforeStep(ExecutionContext context) {
        String stepText = context.getCurrentStep().getText();
        List<Object> parameters = Collections.singletonList(context.getCurrentStep().getDynamicText());

        StringBuilder logMessage = new StringBuilder("Start Step: " + stepText);
        if (!parameters.isEmpty()) {
            logMessage.append(" | Parametreler: ");
            for (Object param : parameters) {
                logMessage.append(param.toString()).append(" ");
            }
        }
        Logger.info(logMessage.toString().trim());
    }

//    @AfterStep
//    public void afterStep(ExecutionContext context) {
//        String stepText = context.getCurrentStep().getText();
//        Logger.info("Biten step: " + stepText);
//    }
}
