package io.debarshri.github.arkifact.route;

import io.debarshri.github.arkifact.Resource;
import org.apache.commons.io.FileUtils;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * curl "http://localhost:8081/get/test"
 * curl "http://localhost:8081/get/commons" > commons.jar
 */
public class GetApp implements Route {
    public Object handle(Request request, Response response) throws Exception {

        File file = new File(Resource.REPO + "/" + request.params("appname"));

        if (!file.exists()) {
            response.status(503);
            return null;
        }

        List<String> collect = Arrays.asList(file.listFiles())
                .stream()
                .map(f -> f.getName())
                .map(f -> {
                    if (f.contains("_")) {
                        return f.split("_")[1];
                    }
                    return f;
                })
                .sorted()
                .collect(Collectors.toList());

        return FileUtils.readFileToByteArray(new File(Resource.REPO + "/" + request.params("appname") + "/" + collect.get(collect.size() - 1)));
    }
}
