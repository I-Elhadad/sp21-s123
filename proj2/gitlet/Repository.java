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
    public static final File GITLET_DIR = join("/home/ibrahem/sp21-s123/proj2", ".gitlet");

    /* TODO: fill in the rest of this class. */
    public static File stage = join(GITLET_DIR,"staging area");
    public static File commit = join(GITLET_DIR,"commits");
    public static File addition = join(stage,"addition");
    public static File removal = join(stage,"removal");
    public static File HEAD = join(GITLET_DIR,"HEAD");
    public static boolean  check_exist(String cwd,String name,String check)
    {

        File loc=join(cwd,name);
        Commit temp = readObject(loc,Commit.class);
        if(temp.blobs.contains(check))
            return true;
        return false;

    }




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


        new Commit("initial commit");
    }


    public static void add(String name) throws IOException {
        String sha1;
        byte [] arr=readContents(Utils.join(CWD , name));
        sha1=Utils.sha1(arr);
        File add = join(addition , sha1);
        File rem = join(removal , sha1);
        if(!add.exists())
        {
            writeContents(add,arr);
            add.createNewFile();
        }
        if(rem.exists())
        {
            rem.delete();
        }
    }
    public static void rm(String name)throws IOException
    {
        //System.out.println(name);
        String sha1;
        byte [] arr=readContents(Utils.join(CWD , name));
        sha1=Utils.sha1(arr);
        //System.out.println(sha1);
        File add = join(addition , sha1);
        File rem = join(removal , sha1);
//        writeContents(add,arr);
        if(add.exists()) {
            add.delete();
        }else if(check_exist(String.valueOf(Repository.commit),Commit.HEAD,name)) {
                File temp = join(CWD, name);
                writeContents(rem, arr);
                rem.createNewFile();
                temp.delete();
        }else System.out.println("No reason to remove the file.");
    }
}
