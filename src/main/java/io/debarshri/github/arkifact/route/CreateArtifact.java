package io.debarshri.github.arkifact.route;

import io.debarshri.github.arkifact.Resource;
import org.apache.commons.io.FileUtils;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.File;

/*curl -X POST --data-binary "@merchant-express-streaming-service-0.1.jar" "http://localhost:8081/app/test/add-artifact/type/jar"*/
public class CreateArtifact implements Route {
    public Object handle(Request request, Response response) throws Exception {
        String appname = request.params("appname");
        String type = request.params("type");
        long l = System.currentTimeMillis();
        String pathname =  Resource.REPO + "/" + appname + "/" + l +"."+type;
        File file = new File(pathname);
        FileUtils.writeByteArrayToFile(file, request.bodyAsBytes());
        return "ok with "+l;
    }
}
