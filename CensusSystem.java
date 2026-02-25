 
public class CensusSystem {
//q7
    static class Student {
        private String name;
        private int age;
        private String school;
        private int grade;
        private String citizenship;
        private String phone;

        public Student(String name, int age, String school, int grade, String citizenship, String phone) {
            this.name = name;
            this.age = age;
            this.school = school;
            this.grade = grade;
            this.citizenship = citizenship;
            this.phone = phone;
        }

        public String getName() { return name; }
        public int getAge() { return age; }
        public String getSchool() { return school; }
        public int getGrade() { return grade; }
        public String getCitizenship() { return citizenship; }
        public String getPhone() { return phone; }

        public String getNameInitials() {
            String[] parts = name.split(" ");
            StringBuilder initials = new StringBuilder();
            for (String part : parts) {
                initials.append(part.charAt(0)).append(".");
            }
            return initials.toString();
        }

        @Override
        public String toString() {
            return String.format("%s | %d | Grade %d | %s",
                    name, age, grade, school);
        }
    }
public static Student[] parseCSV(String[] csvData) {

        Student[] students = new Student[csvData.length - 1];

        for (int i = 1; i < csvData.length; i++) {

            String[] data = csvData[i].split(",");

            String name = data[0].trim();
            int age = Integer.parseInt(data[1].trim());
            String school = data[2].trim();
            int grade = Integer.parseInt(data[3].trim());
            String citizenship = data[4].trim();
            String phone = data[5].trim();

            students[i - 1] = new Student(name, age, school, grade, citizenship, phone);
        }

        return students;
    }
    public static boolean isValidCitizenship(String cit) {

        if (cit.length() != 10) return false;

        if (cit.charAt(2) != '-') return false;

        for (int i = 0; i < cit.length(); i++) {
            if (i == 2) continue;
            if (!Character.isDigit(cit.charAt(i))) return false;
        }

        return true;
    }
    public static void findBySchool(Student[] students, String school) {
        for (Student s : students) {
            if (s.getSchool().equalsIgnoreCase(school)) {
                System.out.println(s);
            }
        }
    }

    public static int countByGrade(Student[] students, int grade) {
        int count = 0;
        for (Student s : students) {
            if (s.getGrade() == grade) count++;
        }
        return count;
    }
    public static double averageAge(Student[] students) {
        int total = 0;
        for (Student s : students) {
            total += s.getAge();
        }
        return (double) total / students.length;
    }

    public static Student findLongestName(Student[] students) {
        Student longest = students[0];

        for (Student s : students) {
            if (s.getName().length() > longest.getName().length()) {
                longest = s;
            }
        }
        return longest;
    }
    public static String generateCensusReport(Student[] students) {

        StringBuilder report = new StringBuilder();

        int valid = 0;
        int invalid = 0;

        report.append("========== NEPAL SCHOOL CENSUS REPORT ==========\n\n");

        for (Student s : students) {

            boolean isValid = isValidCitizenship(s.getCitizenship());

            if (isValid) valid++;
            else invalid++;

            report.append(String.format(
                    "%-6s | %-25s | Age: %-3d | Grade: %-2d | %s\n",
                    s.getNameInitials(),
                    s.getName(),
                    s.getAge(),
                    s.getGrade(),
                    isValid ? "Valid" : "Invalid"
            ));
        }
       
        report.append("\n-------------------------------------------\n");
        report.append("Total Students: ").append(students.length).append("\n");
        report.append("Valid Citizenship: ").append(valid).append("\n");
        report.append("Invalid Citizenship: ").append(invalid).append("\n");

        report.append("\nAverage Age: ")
              .append(String.format("%.2f", averageAge(students)))
              .append("\n");

        Student longest = findLongestName(students);
        report.append("Longest Name: ").append(longest.getName()).append("\n");

        return report.toString();
    }
    public static void main(String[] args) {

        String[] csvData = {
                "Name,Age,School,Grade,Citizenship,Phone",
                "Ram Bahadur Thapa,18,Itahari Int. College,12,01-0012345,9841234567",
                "Sita Kumari Rai,17,Itahari Int. College,11,01-0054321,9807654321",
                "Hari Prasad Sharma,19,ICK College,12,02-0098765,9812345678",
                "Gita Devi Tamang,16,ICP College,10,03-0011111,9800000000",
                "Bikash Kumar Limbu,18,Itahari Int. College,12,01-0077777,9841111111",
                "Anita Rai,17,ICK College,11,04-002222,981234",
                "Deepak Shah,20,ICP College,12,01-00ABCDE,9867890123"
        };

        Student[] students = parseCSV(csvData);

        System.out.println(generateCensusReport(students));

        System.out.println("\nStudents from ICK College:");
        findBySchool(students, "ICK College");

        System.out.println("\nGrade 12 Count: " + countByGrade(students, 12));
    }
}
