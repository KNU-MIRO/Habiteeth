package habiteeth.models;

import habiteeth.helpers.TimeHelper;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.json.Json;

public class User {

    public int userId;
    public String username;
    public String deviceUUID;
    public long totalDuration;
    public String lastEndTime;
    public long rank; // 1 ~ +999
    
    public User(int id, String name, String uuid) {
        this.userId = id;
        this.username = name;
        this.deviceUUID = uuid;
        this.rank = 999; // init value
    }

    // TODO: Model Extension method

    public void saveDuration(String startISO8061Date, String endISO8061Date) {
        this.totalDuration += TimeHelper.getDuration(startISO8061Date, endISO8061Date);
        this.lastEndTime = endISO8061Date;
    }

    public String encodeModel() {
        JsonObject rawData = new JsonObject();
        rawData.put("id", this.userId)
        .put("username", this.username)
        .put("device_uuid", this.deviceUUID)
        .put("total_duration", this.totalDuration)
        .put("last_end_time", this.lastEndTime);
       
        return rawData.encodePrettily();
    }
}