package habiteeth.verticles.user;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.Router;

import habiteeth.seeds.UserSeed;
import habiteeth.models.User;
import habiteeth.helpers.LoggerPrinter;
import habiteeth.helpers.LoggerType;

public class UserVerticle extends AbstractVerticle {

    public UserSeed userSeed = new UserSeed();

    @Override
    public void start() {
      Router router = Router.router(vertx);
      router.route().handler(BodyHandler.create());
      router.get("/user").handler(this::handleGetUser);
      router.get("/user/owner").handler(this::handleGetOwner);
      vertx.createHttpServer().requestHandler(router::accept).listen(8000);
    }
  
    // API: /user?userId
    // userId: Integer
    private void handleGetUser(RoutingContext routingContext) {
        LoggerPrinter.print("[+] GET /user", LoggerType.SUCCESS);
        HttpServerResponse response = routingContext.response();
        String userId = routingContext.request().getParam("userId");

        // null check
        if (userId == null) {
            sendError(404, response, "parameter need 1 or 2 more need");
        }

        User targetUser = this.userSeed.findUser(Integer.parseInt(userId));

        // null check
        if (targetUser == null) {
            sendError(404, response, "Not Found");
        }

        response.putHeader("content-type", "application/json").end(targetUser.encodeModel());
    }

    // API: /user/owner?userId&uuid
    // userId: Integer, user identifier
    // uuid: String, Device inherent identifier
    private void handleGetOwner(RoutingContext routingContext) {
        LoggerPrinter.print("[+] GET /user/owner", LoggerType.SUCCESS);

        HttpServerResponse response = routingContext.response();
        String userId = routingContext.request().getParam("userId");
        String uuid = routingContext.request().getParam("uuid");

        if (userId == null || uuid == null) {
            sendError(404, response, "parameter need 1 or 2 more need");
        }

        User targetUser = this.userSeed.findOwner(Integer.parseInt(userId), uuid);
      
        if (targetUser == null) {
            sendError(403, response, "Authroized Failed");
        }

        response.putHeader("content-type", "application/json").end(targetUser.encodeModel());
    }

    private void sendError(int statusCode, HttpServerResponse response, String message) {
        LoggerPrinter.print("[-] Error: " + message, LoggerType.ERROR);
        response.setStatusCode(statusCode).end(message);
    }
}