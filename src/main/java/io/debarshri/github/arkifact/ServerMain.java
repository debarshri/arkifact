package io.debarshri.github.arkifact;

import io.debarshri.github.arkifact.route.*;
import spark.Spark;

public class ServerMain {
    public static void main(String[] args) {
        Spark.port(8081);
        Resource.REPO = "repo/";
        Spark.get("/", new Projects());
        Spark.get("/get/:appname", new GetApp());

        //todo
        Spark.get("/get/:appname/listnames", new GetApp());
        //todo
        Spark.get("/get/:appname/tag/:tagname", new GetAppForTag());
        //todo
        Spark.get("/tags/:appname", new GetAppForTag());
        //todo
        Spark.get("/get/:appname/tag/:tagname/latest", new GetAppForTagLatest());

        Spark.post("/create/:appname", new CreateApp());
        Spark.post("/app/:appname/add-artifact/type/:type", new CreateArtifact());
        Spark.post("/app/:appname/add-artifact/type/:type/tag/:tag", new CreateArtifactTags());
    }
}
