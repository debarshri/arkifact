package io.debarshri.github.arkifact.route;

import io.debarshri.github.arkifact.Resource;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.File;
import java.util.Arrays;

public class Projects implements Route {
    public Object handle(Request request, Response response) throws Exception {
        return Arrays.asList(new File(Resource.REPO).list());
    }
}
