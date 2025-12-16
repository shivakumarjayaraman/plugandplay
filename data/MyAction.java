import java.util.function.*;

public class MyAction implements Function<String, String> {
    public String apply(String data) {
        return data.toUpperCase();
    }
}
