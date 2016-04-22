package io.debarshri.github.arkifact.route;

import io.debarshri.github.arkifact.Resource;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.File;

public class CreateApp implements Route {
    public Object handle(Request request, Response response) throws Exception {
        String appname = request.params("appname");
        File file = new File(Resource.REPO+"/"+appname);
        return  file.mkdir();
    }
}
