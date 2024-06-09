package SpringStarts.scope;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.SimpleThreadScope;

import java.util.Objects;

public class AppiumDriverScope extends SimpleThreadScope {

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object o = super.get(name, objectFactory);
        var sessionId = ((RemoteWebDriver)o).getSessionId();
        if(Objects.isNull(sessionId)){
            System.out.println("TEST " + name);
            super.remove(name);
            o = super.get(name, objectFactory);
        }
        return o;
    }
    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
    }
}
