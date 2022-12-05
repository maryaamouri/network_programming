
package school;


public class Employee extends Person {
   private float salary;

    public Employee(float salary, String name, String id) {
        super(name, id);
        this.salary = salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString()+"Employee{" + "salary=" + salary + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (Float.floatToIntBits(this.salary) != Float.floatToIntBits(other.salary)) {
            return false;
        }
        return true;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(Object o) {
        if(((Employee)o).getSalary()> this.salary)  
            return -1;
        if(((Employee)o).getSalary()< this.salary)  
            return 1;
        return 0;
        
        
    }
    
    
}
