package utility;

/**
 * Created with IntelliJ IDEA.
 * User: rrt
 * Date: 8/23/14
 * Time: 1:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class Student {

    /*
     * Student class have 4 variables which will be constructed as Student Object into List<Student>.
     */
    public String firstName;
    public String lastName;
    public String score;
    public String id;

    @Override
    public String toString(){
        return "Student" + "("+"id= "+id+")"+ firstName+" "+lastName+" "+" Grade = "+score;
    }

}
