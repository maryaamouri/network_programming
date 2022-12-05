
package school;



 
abstract class Person implements Comparable, Cloneable {
   private String name;
   private String id;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", id=" + id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
       if(((Person)obj).getName().equals(this.getName())  &&  ((Person)obj).getId() == id)
        return true;
       
       return false;
    }

    @Override
    public  int compareTo(Object o)
    {
        Person p1 = (Person)o;
        
        return  this.name.compareTo(p1.getName());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
      
}


   

