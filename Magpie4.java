
/**
 * A program to carry on conversations with a human user.
 * This version:
 * <ul><li>
 * Uses advanced search for keywords
 * </li></ul>
 *
 * @author Laurie White
 * @version April 2012
 */
public class Magpie4
{
    /**
     * Get a default greeting
     *
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Welcome, lets have a chat.";
    }

    /**
     * Gives a response to a user statement
     *
     * @param statement
     * the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        if (findKeyword(statement, "no") >= 0)
        {
            response = "Why so negative?";
        }
        else if ((findKeyword(statement, "mother") >= 0) ||
        (findKeyword(statement, "father") >= 0) ||
        (findKeyword(statement, "brother") >= 0) ||
        (findKeyword(statement, "sister") >= 0)   )
        {
            response = "Tell me more about your family.";
        }
        else if (findKeyword(statement, "pet") >= 0)
        {
            response = "How old is he?";
        }
        else if (findKeyword(statement, "doctor") >= 0)
        {
            response = "ooh... I hate shots.";
        }
        else
        {
            response = getRandomResponse();
        }
        return response;
    }

    /**
     * Search for one word in phrase. The search is not case
     * sensitive. This method will check that the given goal
     * is not a substring of a longer string (so, for
     * example, "I know" does not contain "no").
     *
     * @param statement
     * the string to search
     * @param goal
     * the string to search for
     * @param startPos
     * the character of the string to begin the
     * search at
     * @return the index of the first occurrence of goal in
     * statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal,
    int startPos)
    {
        String phrase = statement.trim().toLowerCase();
        goal = goal.toLowerCase();
        int index = -1;

        boolean front = false;
        boolean back = false; 

        index = statement.indexOf(goal);
        while(index > -1)
        {
            //test if the character before is a letter

            if(index == 0)//goal is the first word 
            {
                front = true;
            }
            else
            {
                String firstlet = statement.substring(index-1, index);
                //System.out.println(firstlet);
                if(firstlet.compareTo("a") <=0 &&
                (firstlet.compareTo("z") <=0) ||
                (firstlet.equals(" ")))
                {
                    front = true;
                }
            }

            //check back side

            int lastIndex = goal.length()+index;
            if(lastIndex == statement.length())
            {
                back = true;
            }
            else
            {
                String lastlet = statement.substring(lastIndex, lastIndex+1);
                //System.out.println(lastlet);
                if(lastlet.compareTo("a") <=0 &&
                (lastlet.compareTo("z") <=0) ||
                (lastlet.equals(" ")))
                {    
                    back = true;
                }
            }

            if(front == true && back == true)
            {
                return index;
            }

            index = statement.indexOf(goal, index+1);
        }
        return -1;
    }

    /**
     * Search for one word in phrase. The search is not case
     * sensitive. This method will check that the given goal
     * is not a substring of a longer string (so, for
     * example, "I know" does not contain "no"). The search
     * begins at the beginning of the string.
     *
     * @param statement
     * the string to search
     * @param goal
     * the string to search for
     * @return the index of the first occurrence of goal in
     * statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal)
    {
        return findKeyword(statement, goal, 0);
    }

    /**
     * Pick a default response to use if nothing else fits.
     *
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 8;
        double r = Math.random();
        int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
        String response = "";

        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        else if (whichResponse == 4)
        {
            response = "Super cool.";
        }
        else if (whichResponse == 5)
        {
            response = "Wow, I can't believe it!";
        }
        else if (whichResponse == 6)
        {
            response = "Nice job.";
        }
        else if (whichResponse == 7)
        {
            response = "How do you do it!";
        }

        return response;
    }

}

