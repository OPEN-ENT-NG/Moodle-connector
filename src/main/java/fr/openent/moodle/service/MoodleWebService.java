package fr.openent.moodle.service;

import fr.wseduc.webutils.Either;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

public interface MoodleWebService{

    /**
     * delete folders
     * @param folder folder to delete
     * @param handler function handler returning data
     */
    void deleteFolders (JsonObject folder, Handler<Either<String, JsonObject>> handler);


    /**
     * Create a folder
     * @param folder folder to create
     * @param handler function handler returning data
     */
    void createFolder (JsonObject folder, Handler<Either<String, JsonObject>> handler);

    /**
     * move a folder
     * @param folders folders to move
     * @param handler function handler returning data
     */
    void moveFolder(JsonObject folders, Handler<Either<String, JsonObject>> handler);


    /**
     * Create a course
     * @param course course to create
     * @param handler function handler returning data
     */
    void createCourse (JsonObject course, Handler<Either<String, JsonObject>> handler);

    /**
     * Delete courses
     * @param course course to delete
     * @param handler function handler returning data
     */
    void deleteCourse(JsonObject course, Handler<Either<String, JsonObject>> handler);

    /**
     * get course preferences of user
     * @param id_user
     * @param handler function handler returning data
     */
    void getPreferences(String id_user, Handler<Either<String, JsonArray>> handler);

    /**
     * set course preferences of user
     * @param course course where preferences was changed
     * @param handler function handler returning data
     */
    void setPreferences(JsonObject course, Handler<Either<String, JsonObject>> handler);

    /**
     * get list courses ant shared by folder
     * @param id_folder
     * @param id_user
     * @param handler
     */
    void getCoursInEnt(long id_folder, String id_user, Handler<Either<String, JsonArray>> handler);
    /**
     * is containt a object with value of courid
     * @param courid
     * @return
     */
    boolean getValueMoodleIdinEnt(Integer courid,JsonArray object);

    /**
     * get list folders by user
     * @param id_user
     * @param handler
     */
    void getFoldersInEnt(String id_user,Handler<Either<String, JsonArray>> handler);

    /**
     * count Item folders In folder
     * @param id_folder
     * @param userId
     * @param defaultResponseHandler
     */
    void countItemInfolder(long id_folder, String userId, Handler<Either<String, JsonObject>> defaultResponseHandler);

    /**
     * count Item courses In folder
     * @param id_folder
     * @param userId
     * @param defaultResponseHandler
     */
    void countCoursesItemInfolder(long id_folder, String userId, Handler<Either<String, JsonObject>> defaultResponseHandler);

    /**
     * get courses and shared by users
     * @param userId
     * @param eitherHandler
     */
    void getCoursesByUserInEnt(String userId, Handler<Either<String, JsonArray>> eitherHandler);

    /**
     * get choice of user in a specific view
     * @param userId
     * @param eitherHandler
     */
    void getChoices(String userId, Handler<Either<String, JsonArray>> eitherHandler);

    /**
     * set choice of user in a specific view in the DataBase
     * @param courses where the choice is stock
     * @param view
     * @param handler
     */
    void setChoice(JsonObject courses, String view, Handler<Either<String, JsonObject>> handler);

    /**
     * get users
     * @param usersIds
     * @param handler
     */
    void getUsers(JsonArray usersIds, Handler<Either<String, JsonArray>> handler);

    /**
     * get groups
     * @param groupsIds
     * @param handler
     */
    void getGroups(JsonArray groupsIds, Handler<Either<String, JsonArray>> handler);

    /**
     * get sharedbookmark
     * @param sharedBookMarkId
     * @param handler
     */
    void getSharedBookMark(String sharedBookMarkId, Handler<Either<String, JsonArray>> handler);

    /**
     * insert duplication table
     * @param courseToDuplicate course to duplicate
     * @param handler function handler returning data
     */
    void insertDuplicateTable (JsonObject courseToDuplicate, Handler<Either<String, JsonObject>> handler);

//    /**
//     * update duplication table
//     * @param updateCourseToDuplicate course to duplicate
//     * @param handler function handler returning data
//     */
//    void updateDuplicateTable (JsonObject updateCourseToDuplicate, Handler<Either<String, JsonObject>> handler);
}
