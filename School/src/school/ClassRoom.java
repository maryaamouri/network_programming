
package school;

import java.util.ArrayList;
import java.util.LinkedList;


public class ClassRoom implements Cloneable, Comparable{
static private int MaxnumberOfStudents;
private int classid;
private Employee Mainteacher;
private ArrayList <Employee> teachers;
private LinkedList <Student> students;

    public ClassRoom(int classnum, Employee Mainteacher, ArrayList<Employee> teachers, LinkedList<Student> students) {
        this.classid = classnum;
        this.Mainteacher = Mainteacher;
        this.teachers = teachers;
        this.students = students;
    }

    public ClassRoom() {
        this.classid= 0;
        this.Mainteacher = null;
        this.teachers = null;
        this.students = null;
    }

    public int getNumberOfStudents() {
        return students.size();
    }
public static int getMaxNumberOfStudents() {
        return MaxnumberOfStudents;
    }
    public int getClassid() {
        return classid;
    }

    public Employee getMainteacher() {
        return Mainteacher;
    }

    public ArrayList<Employee> getAllTeachers() {
        return teachers;
    }

    public LinkedList<Student> getِAllStudents() {
        return students;
    }

    
    ////////////----------new methods ---------------//////////////
    
    
public boolean fillRandom ( int numOfStudents)
{
    if(numOfStudents <=0 || numOfStudents> MaxnumberOfStudents) return false;
    for(int i=1;i<=numOfStudents;i++)
        students.add(i, new Student ( (float)(Math.random())*4 ,"student name"+i ,i+"" )  );
        return true;
}




public boolean addStudent (Student s)
{
    if(s==null || students.size()== MaxnumberOfStudents)
    return false;
    
    students.add(s);
    return true;
}

@Override
    public String toString() {
        return "ClassRoom{" + "classid=" + classid + ", Mainteacher=" + Mainteacher + ", teachers=" + teachers + ", students=" + students + '}';
    }


public boolean removeStudent (Student s)
{if( ! students.contains(s))
    return false;
return students.remove(s);
}


//------------------------------------------------------------


public int searchForStudentIndex (String id)
{
    int i=-1;
    for( Student s: students)
    {
        if(s.getId()==id)
            return i;
        i++;
        
    }
    return i;
    
}

public int searchForEmployeeIndex (String id)
{
    int i=-1;
    for( Employee e: teachers)
    {
        if(e.getId()==id)
            return i;
        i++;
        
    }
    return i;
    
    
}



public boolean removeStudentById (String id)
{ int i = this.searchForStudentIndex(id);
if(i<0)
    return false;
students.remove(i);
return true;

}
public Student getStudentByID (String id)
{   int i = this.searchForStudentIndex(id);
        if(i<0)return null;
    return students.get(i);
}
public ArrayList<Student> getStudentByName (String name)
{ ArrayList<Student> ss = new ArrayList<Student>();

for(Student s : students)
    if(s.getName().equals(name))
        ss.add(s);
    return ss;
}

public ArrayList<Student> getStudentsByGpa (float gpa)
{
    ArrayList<Student> ss = new ArrayList<Student>();

for(Student s : students)
    if(s.getGpa()==gpa)
        ss.add(s);
    return ss;
}

public ArrayList<Student> getPassStudents (float gpa)
{
 
    ArrayList<Student> ss = new ArrayList<Student>();

for(Student s : students)
    if(s.getGpa()>=2.0)
        ss.add(s);
    return ss;
}


    


    @Override
    public int compareTo(Object o) {
        ClassRoom cr = (ClassRoom)o;
        if(cr.getNumberOfStudents()<this.getNumberOfStudents())
            return 1;
        if(cr.getNumberOfStudents()>this.getNumberOfStudents())
            return -1;
        return 0;
    }
    
}
