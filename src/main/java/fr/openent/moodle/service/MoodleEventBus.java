package fr.openent.moodle.service;

import io.vertx.core.Handler;
import fr.wseduc.webutils.Either;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

public interface MoodleEventBus {

    /**
     * Get email to create a course
     * @param action Method call
     * @param handler function handler returning data
     */
    void getParams (JsonObject action, Handler<Either<String, JsonObject>> handler);

    /**
     * get image to bus
     * @param idImage User Id
     * @param handler function handler returning data
     */

    void getImage (String idImage, Handler<Either<String,JsonObject>> handler);

    /**
     * get users & groups to bus
     * @param groupIds Group Ids
     * @param handler function handler returning data
     */

    void getUsers (JsonArray groupIds, Handler<Either<String,JsonArray>> handler);

    /**
     * get users & groups to bus
     * @param zimbraEmail Array with user(s) id
     * @param handler function handler returning data
     */

    void getZimbraEmail (JsonArray zimbraEmail, Handler<Either<String,JsonArray>> handler);
}
