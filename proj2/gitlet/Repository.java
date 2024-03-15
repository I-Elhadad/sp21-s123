package gitlet;


import java.io.File;
import java.io.IOException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

import static gitlet.Utils.*;

// TODO: any imports you need here

/** Represents a gitlet repository.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Repository {
    /**
     * TODO: add instance variables here.
     *
     *
     * List all instance variables of the Repository class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided two examples for you.
     */


    /** The current working directory. */
    public static final File CWD = new File(System.getProperty("user.dir"));
    /** The .gitlet directory. */
    public static final File GITLET_DIR = join(CWD, ".gitlet");

    /* TODO: fill in the rest of this class. */
    public static File stage = join(GITLET_DIR,"staging area");
    public static File commit = join(GITLET_DIR,"commits");
    public static File addition = join(stage,"addition");
    public static File removal = join(stage,"removal");
    public static File HEAD = join(GITLET_DIR,"HEAD");




    public static void init() throws IOException {
        if(GITLET_DIR.exists())
        {
            System.out.println("A Gitlet version-control system already exists in the current directory.");
            System.exit(0);
        }
        GITLET_DIR.mkdir();
        stage.mkdir();
        commit.mkdir();
        addition.mkdir();
        removal.mkdir();
        HEAD.createNewFile();


        new Commit("initial commit" , null);
    }
}
