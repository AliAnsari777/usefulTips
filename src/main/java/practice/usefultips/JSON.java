package practice.usefultips;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSON {

    static void ConvertJsonToArray() {
        String informationInJsonFormat = "students: [ " +
                "{name: ali, class:programming, contact:546698745}, " +
                "{name: max, class:algorithm, contact:1234587562}," +
                "{name: sara, class:designing, contact:7854245874}" +
                "]";
        JSONObject jObject = new JSONObject(informationInJsonFormat);
        JSONArray jsonArray = jObject.getJSONArray("students");
        List<Student> students = new ArrayList<>();
        Student student = new Student();

        for (int i = 0; i < jsonArray.length(); i++) {

            Object object = jsonArray.get(i);
            JSONObject jsonObject = new JSONObject(object.toString());
            student.setName(jsonObject.getString("name"));
            student.setClassName(jsonObject.getString("class"));
            student.setContact(jsonObject.getString("contact"));

            students.add(student);
        }

        for(Student s : students){
            System.out.println(s.toString());
            System.out.println();
        }
    }

    static class Student{
        String name;
        String className;
        String contact;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", className='" + className + '\'' +
                    ", contact='" + contact + '\'' +
                    '}';
        }
    }
}
