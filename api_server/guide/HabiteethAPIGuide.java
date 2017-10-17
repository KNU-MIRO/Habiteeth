import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;

import io.vertx.ext.web.Router;
import io.vertx.ext.web.Cookie;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.CookieHandler;

import java.io.*;
import java.util.*;

import com.sun.javafx.tk.quantum.PathIteratorHelper.Struct;

// simple REST API Best Practics code
// https://github.com/vert-x3/vertx-examples/blob/master/web-examples/src/main/java/io/vertx/example/web/rest/SimpleREST.java

public class HabiteethAPIGuide extends AbstractVerticle {

    private final static int portNumber = 8000;

    public Router createRouter() {
        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());
        router.route().handler(CookieHandler.create());
        return router;
    }

    public void launchRocket(Router router) {
        vertx.createHttpServer()
        .requestHandler(router::accept)
        .listen(HabiteethAPIGuide.portNumber);
    }

    public void start() {    

        Router router = createRouter();

        router.route("route_path/:param_name/:param2").handler(event -> {
            String parameter = event.request().getParam("param_name");

            event.put("key", parameter);
            routingContext.reroute("/other_route");
        });

        router.route("/other_route").handler(event -> {
            JsonObject rawData = new JsonObject();

            String value = event.get("key");
                    
            rawData.put("key", value).put("id", 12345);

            event.response()
                 .putHeader("context-type", "application/json")
                 .end(Json.encode(rawData));
        });

        router.route("/multiple_method")
              .method(HttpMethod.POST)
              .method(HttpMethod.PUT)
              .handler(event -> {
                // TODO

        });

        // Error Handler with error message example
        router.route("error_handle").handler( event -> {
            routingContext.response()
                          .setStatusCode(404)
                          .end("Not Found");
        });

        // Routing next event handler example
        router.route("/Start/:direction").handler(event -> {
            event.response()
                 .setChunked(true)
                 .write("A");
            event.vertx().setTimer(2000, tid -> event.next());
        });

        router.route("/Start/:direction").handler(event -> {
            event.response()
                 .write("B after 2sec on A");
            event.vertx().setTimer(3000, tid -> event.next());
        });

        router.route("/Start/:direction").handler(event -> {
            event.response()
                 .end("done event"); // real ended
        });

        //MIME
        /* produces : 제공해주는 content-type을 지칭함
        *  consumes : 클라이언트로 부터 오는 content-type을 제한
        */
        router.route("/MIME").produces("application/json").handler(event -> {
            String clientAccessContentType = event.getAcceptableContentType();
            System.out.println("Accept able content type : " + clientAccessContentType);
            ctx.response()
               .putHeader("content-type", clientAccessContentType)
               .end("<h1>" + clientAccessContentType + "</h1>");
        });

        // Get client localtion language
        router.route("/Localization").handler(event -> {
            System.out.println(event.preferredLocale() +"  user : " + event.user());
        });

        launchRocket(router);
    }
}


