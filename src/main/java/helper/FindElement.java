package helper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.openqa.selenium.By;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class FindElement {
    private static Map<String, ElementInfo> elementMapList;

    static {
        initElementInfo();
    }

    private FindElement() {}

    private static void initElementInfo() {
        Gson gson = new Gson();
        List<ElementInfo> elementInfoList;
        elementInfoList = gson.fromJson(new InputStreamReader(Objects.requireNonNull(FindElement.class.getResourceAsStream("/elements.json"))),
                        new TypeToken<List<ElementInfo>>() {}.getType());
        elementMapList = new HashMap<>();
        for (ElementInfo elementInfo : elementInfoList) {
            elementMapList.put(elementInfo.getKey(), elementInfo);
        }
    }

    public static By getElementInfoToBy(ElementInfo elementInfo) {
        By by = null;
        if (elementInfo.getType().equals("css")) {
            by = By.cssSelector(elementInfo.getValue());
        } else if (elementInfo.getType().equals("id")) {
            by = By.id(elementInfo.getValue());
        } else if (elementInfo.getType().equals("xpath")) {
            by = By.xpath(elementInfo.getValue()); }
        return by;
    }


    public static ElementInfo getElementInfo(String key) {
        return elementMapList.get(key);
    }

    public static By getElementInfoToBy(String key) {
        return getElementInfoToBy(getElementInfo(key));
    }

    public static By getDynamicElementInfoToBy(String key, String text){
        By dynamicElement = getElementInfoToBy(getElementInfo(key));
        String dynamicElementSelector = dynamicElement.toString().split(": ")[1];
        String newSelector = String.format(dynamicElementSelector,text);
        By byElement;
        if (dynamicElement instanceof By.ByCssSelector){
            byElement = By.cssSelector(newSelector);
        }else {
            byElement = By.xpath(newSelector);
        }
        return byElement;
    }
}


