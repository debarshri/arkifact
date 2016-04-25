package io.debarshri.github.arkifact;

import com.lexicalscope.jewel.cli.CliFactory;
import io.debarshri.github.arkifact.route.*;
import spark.Spark;

public class ServerMain {
    public static void main(String[] args) {

        final Opts opts = CliFactory.parseArguments(Opts.class, args);
        Spark.port(opts.getPort());
        Resource.REPO = opts.getRepo();

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
