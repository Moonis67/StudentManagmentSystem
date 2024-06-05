package Default;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.studentDAO;

public class App {


    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Student managment app");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Press 1 to Add");
            System.out.println("Press 2 to Delete");
            System.out.println("Press 3 to Display");
            System.out.println("Press 4 to exit");
            int c=Integer.parseInt(br.readLine());

            if(c==1){
                //add student
                System.out.println("Enter NAme: ");
                String name=br.readLine();

                System.out.println("Enter PhoneNum: ");
                String phone=br.readLine();

                System.out.println("Enter City: ");
                String city=br.readLine();
                
                //create student object to add student
                Student st=new Student(name, phone, city);
                boolean answer= studentDAO.insertStudentToDB(st);

                if(answer){
                    System.out.println("Student is added successfully");

                }
                else{
                    System.out.println("Something went wrong sorry");
                }
                System.out.println(st);

            }
            else if(c==2){
            //delete student
            System.out.println("Enter Student ID to delete: ");
            
            int userId=Integer.parseInt(br.readLine());
            boolean f= studentDAO.deleteStudent(userId);
            
            if(f){
                System.out.println("Student Deleted!!");

            }
            else{
                System.out.println("Something went wrong");
            }
            }
            else if(c==3){
                //display students
            studentDAO.displayAllStudents();

            }
            else if(c==4){
                System.out.println("Thanku for using..byebyeee");
                break;
            }
            else{

            };

        }
    }
}
