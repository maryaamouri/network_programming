package school;


class Student extends Person {
    private float gpa;

    public Student(float gpa, String name, String id) {
        super(name, id);
        this.gpa = gpa;
    }

   

    public float getGpa() {
        return gpa;
       
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
    
    
  

    @Override
    public String toString() {
        
        return super.toString()+"Student{" + "gpa=" + gpa + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(Object o) {
        return super.compareTo(o); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }
    
      
}