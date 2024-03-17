package gitlet;
import jdk.jshell.execution.Util;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import gitlet.Utils.*;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

// TODO: any imports you need here

import static gitlet.Utils.*;


/** Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Commit implements Serializable{
    /**
     * TODO: add instance variables here.
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */

    /** The message of this Commit. */
    public static String HEAD= (readContentsAsString(join(Repository.GITLET_DIR,"HEAD")));
    private String message;
    HashSet<String> blobs;
    private String date;
    private String parent=null;
    private String sh1;
    void save()
    {
        File com = join(Repository.commit , sh1);
        writeObject(com,this);
        writeContents(Repository.HEAD,sh1);
    }

    public Commit(String message ) {
        // hard code the initial time
        if (HEAD.isEmpty())
        {
            date = "00:00:00 UTC, Thursday, 1 January 1970";
        }
        else {
            parent = HEAD;
        }
        blobs=new HashSet<>();

        if(parent!=null) {
            File comm=join(Repository.commit,parent);
            Commit temp = readObject(comm,Commit.class);
            blobs=temp.blobs;
        }

        this.message = message;
        File directory_add = new File(String.valueOf(Repository.addition));
        File[] add_blobs=directory_add.listFiles();
        assert add_blobs != null;
        for(File it:add_blobs) {
            blobs.add(it.getName());
            it.delete();
        }

        File directory_rem = new File(String.valueOf(Repository.removal));
        File[] rem_blobs=directory_rem.listFiles();
        assert rem_blobs != null;
        for(File it:rem_blobs) {
            blobs.remove(it.getName());
            it.delete();
        }
        File f=join(Repository.CWD,"f");
        writeObject(f,this);
        byte[] byteArray =readContents(f);
        this.sh1 = sha1(byteArray);
        HEAD = new String(sh1);
        save();

    }

    /* TODO: fill in the rest of this class. */
}
