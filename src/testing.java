import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.*;

public class testing {
    public static void main(String[] args) {
        Item asdf = new Item();
        asdf.asdf("equipment/dagger");

        System.out.println(asdf.CostQuantity);
        System.out.println(asdf.CostUnit);
        System.out.println(asdf.Name);
    }
}
