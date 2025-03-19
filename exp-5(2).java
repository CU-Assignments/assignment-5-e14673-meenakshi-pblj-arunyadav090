import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private double gpa;

 
    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

   
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', gpa=" + gpa + "}";
    }
}

public class Main {

   
    public static void serializeStudent(Student student, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(student);  // Serialize the student object to the file
            System.out.println("Student object serialized successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }
    }

    
    public static Student deserializeStudent(String fileName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Student) in.readObject();  
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Class not found.");
        }
        return null; 
    }

    public static void main(String[] args) {
        
        Student student = new Student(1, "John Doe", 3.75);

       
        String fileName = "student.ser";

       
        serializeStudent(student, fileName);

       
        Student deserializedStudent = deserializeStudent(fileName);

       
        if (deserializedStudent != null) {
            System.out.println("Deserialized Student Details: " + deserializedStudent);
        }
    }
}
//OUTPUT:
//Student object serialized successfully.
//Deserialized Student Details: Student{id=1, name='John Doe', gpa=3.75}
