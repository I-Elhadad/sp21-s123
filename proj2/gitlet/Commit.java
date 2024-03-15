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
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;

// TODO: any imports you need here

import java.util.Date; // TODO: You'll likely use this in this class

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
    public static String HEAD;
    private String message;
    private String date;
    private String parent;
    private String sh1;
    void save()
    {
        File com = join(Repository.commit , sh1);
        writeObject(com,this);
        writeContents(Repository.HEAD,sh1);
    }

    public Commit(String message , String parent) {
        // hard code the initial time
        if (parent == null)
        {
            date = "00:00:00 UTC, Thursday, 1 January 1970";
        }
        else {

        }
        this.message = message;
        this.parent = parent;
        File f=join(Repository.CWD,"f");
        writeObject(f,this);
        byte[] byteArray =readContents(f);

        this.sh1 = sha1(byteArray);
        HEAD = sh1;
        save();

    }

    /* TODO: fill in the rest of this class. */
}
