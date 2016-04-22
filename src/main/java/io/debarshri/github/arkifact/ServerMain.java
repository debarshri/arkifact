package io.debarshri.github.arkifact;

import io.debarshri.github.arkifact.route.*;
import spark.Spark;

public class ServerMain {
    public static void main(String[] args) {
        Spark.port(8081);
        Resource.REPO = "repo/";
        Spark.get("/", new Projects());
        Spark.get("/get/:appname", new GetApp());

        Spark.get("/get/:appname/listnames", new GetApp());
        Spark.get("/get/:appname/tag/:tagname", new GetApp());
        Spark.get("/get/:appname/tag/:tagname/latest", new GetApp());

        Spark.post("/create/:appname", new CreateApp());
        Spark.post("/for/:appname/addArtifact/type/:type", new CreateArtifact());
        Spark.post("/for/:appname/addArtifact/type/:type/tag/:tag", new CreateArtifactTags());
    }
}
