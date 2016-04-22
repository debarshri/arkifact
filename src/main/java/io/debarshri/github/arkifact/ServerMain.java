package io.debarshri.github.arkifact;

import io.debarshri.github.arkifact.route.CreateApp;
import io.debarshri.github.arkifact.route.CreateArtifact;
import io.debarshri.github.arkifact.route.GetApp;
import io.debarshri.github.arkifact.route.Projects;
import spark.Spark;

public class ServerMain {
    public static void main(String[] args) {
        Spark.port(8081);
        Resource.REPO = "repo/";
        Spark.get("/", new Projects());
        Spark.get("/get/:appname", new GetApp());
        Spark.post("/create/:appname", new CreateApp());
        Spark.post("/for/:appname/add/type/:type", new CreateArtifact());
    }
}
