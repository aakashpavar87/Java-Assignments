class User {
    public String username;
    public String email;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void set(String username, String email) {
        this.username = username;
        this.email = email;
    }
}

class Professor extends User {
    public String department, name;

    public Professor(String depart, String name) {
        department = depart;
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String d) {
        department = d;
    }
}

class Course {
    public int courseCode;
    public String courseName;
    public int creditHours;

    public void setDetails(int cc, String cn, int ch) {
        courseCode = cc;
        courseName = cn;
        creditHours = ch;
    }

    public int getCC() {
        return courseCode;
    }

    public int getCH() {
        return creditHours;
    }

    public String getCN() {
        return courseName;
    }
}

class Department {
    public String course;
    public String prof;
    public String uniDepartment;

    public void setProfessor1(Professor p) {
        prof = p.name;
    }

    public void setCourse1(Course c) {
        course = c.getCN();
    }

    public void setDepartment(String dp) {
        uniDepartment = dp;
    }

    public String getProfessor() {
        return prof;
    }

    public String getCourse() {
        return course;
    }
}

class UniversityDepartmentSystem {
    public static void DisplayInfo(Professor p, Course c, Department d) {
        System.out.println("========= Printing Professor Information =========");
        System.out.println("Name : " + p.name);
        System.out.println("Username : " + p.getUsername());
        System.out.println("Email : " + p.getEmail());
        System.out.println("Department : " + p.getDepartment());
        System.out.println("==================================================");

        System.out.println("========= Printing Course Information ============");
        System.out.println("Course Name: " + c.getCN());
        System.out.println("Course Code: " + c.getCC());
        System.out.println("Course Credit Hours: " + c.getCH());
        System.out.println("==================================================");

        System.out.println("========= Printing Department Information =========");
        System.out.println("Department Name : " + d.uniDepartment);
        System.out.println("Department Professor : " + d.getProfessor());
        System.out.println("Department Course : " + d.getCourse());
        System.out.println("==================================================");
    }

    public class Question5 {

        public static void main(String[] args) {
            System.out.println("\t\tName : Aakash Pavar Roll No: 3057");
            Professor p = new Professor("Biology", "Mr. Mehta");
            Course c = new Course();
            Department d = new Department();
            p.set("MilanMehta010", "mehta@professor@gmail.com");
            p.setDepartment("Computer Science");
            c.setDetails(305, "Programming with JAVA", 50);
            d.setProfessor1(p);
            d.setCourse1(c);
            d.setDepartment(p.getDepartment());

            DisplayInfo(p, c, d);
        }
    }
}
