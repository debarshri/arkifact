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
 *  curl "http://localhost:8081/get/test"
 */
public class GetApp implements Route {
    public Object handle(Request request, Response response) throws Exception {
        File file = new File(Resource.REPO + "/" + request.params("appname"));
        List<String> collect = Arrays.asList(file.listFiles()).stream().map(f -> f.getName()).sorted().collect(Collectors.toList());
        return FileUtils.readFileToByteArray(new File(Resource.REPO + "/" + request.params("appname")+"/"+collect.get(collect.size() - 1)));
    }
}
