package gitlet;

import java.io.IOException;

/** Driver class for Gitlet, a subset of the Git version-control system.
 *  @author TODO
 */
public class Main {

    /** Usage: java gitlet.Main ARGS, where ARGS contains
     *  <COMMAND> <OPERAND1> <OPERAND2> ... 
     */
    public static void main(String[] args) throws IOException {

        if(args.length==0)
        {
            System.out.println("no comand");
            System.exit(0);
        }
        String firstArg = args[0];

        switch(firstArg) {
            case "init":
                Repository.init();
                break;
            case "add":
                new add(args[1]);
                break;
            case "commit":


            // TODO: FILL THE REST IN
        }
    }
}
