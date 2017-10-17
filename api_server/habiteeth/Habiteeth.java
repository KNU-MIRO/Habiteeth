package habiteeth;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

import java.util.HashMap;
import java.util.Map;

public class Habiteeth extends AbstractVerticle {

  @Override
  public void start() {

    Router router = Router.router(vertx);

    router.route().handler(BodyHandler.create());
    router.put("/test/:update").handler(this::handlePutTest);
    router.get("/test").handler(this::handleGetTest);

    vertx.createHttpServer().requestHandler(router::accept).listen(8080);
  }

  private void handleGetTest(RoutingContext routingContext) {
    HttpServerResponse response = routingContext.response();
    //response.putHeader("content-type", "application/json").end(model.encodePrettily());
  }

  private void handlePutTest(RoutingContext routingContext) {
    String updateTarget = routingContext.request().getParam("update");
    HttpServerResponse response = routingContext.response();
    if (updateTarget == null) {
      sendError(400, response);
    } else {
      JsonObject product = routingContext.getBodyAsJson();
      if (product == null) {
        sendError(400, response);
      } else {
        response.end();
      }
    }
  }

  private void sendError(int statusCode, HttpServerResponse response) {
    response.setStatusCode(statusCode).end();
  }
}
