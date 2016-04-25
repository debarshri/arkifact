package io.debarshri.github.arkifact;

import com.lexicalscope.jewel.cli.Option;

public interface Opts {

    @Option(shortName="p",defaultValue="8080")
    int getPort();

    @Option(shortName="r",defaultValue="repo/")
    String getRepo();
}
