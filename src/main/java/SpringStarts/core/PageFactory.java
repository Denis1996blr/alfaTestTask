package SpringStarts.core;

import SpringStarts.pages.BasePage;
import io.appium.java_client.AppiumDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class PageFactory {


/*    public static <T extends BasePage> T initElements(AppiumDriver driver, Class<T> pageClass) {
        T page = instantiatePage(pageClass);
        initElements(driver, page);
    }

    private static <T extends BasePage> T instantiatePage(Class<T> pageClass) {
        try {
            Constructor<T> constructor = pageClass.getConstructor();
            return constructor.newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }

    private static <T extends BasePage> void initElements(AppiumDriver driver, T page) {
        initFields(page, page.getClass().getDeclaredFields(), driver);
    }


    private static void initFields(Object page, Field[] fields, AppiumDriver driver) {
        for(Field field: fields){
            try{
                Class<?> fieldClass = field.getType();
            }
        }
    }*/
}