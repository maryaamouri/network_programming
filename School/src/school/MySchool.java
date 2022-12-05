/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package school;

/**
 *
 * @author HITECH
 */
public class MySchool {
private static MySchool myschool = null;
private String name;
    private MySchool() {
    }
    
    public static MySchool getSchool ()
    {if (myschool == null)
        return new MySchool();
    return myschool;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}
