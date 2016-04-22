package io.debarshri.github.arkifact.route;

import io.debarshri.github.arkifact.Resource;
import org.apache.commons.io.FileUtils;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.File;

public class CreateArtifactTags implements Route {
    @Override
    public Object handle(Request request, Response response) throws Exception {
        String appname = request.params("appname");
        String type = request.params("type");
        String tag = request.params("tag");
        long l = System.currentTimeMillis();
        String pathname =  Resource.REPO + "/" + appname + "/" +tag+"_"+ l +"."+type;
        File file = new File(pathname);
        FileUtils.writeByteArrayToFile(file, request.bodyAsBytes());
        return "ok with "+l;
    }
}
