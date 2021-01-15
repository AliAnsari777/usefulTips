package practice.usefultips;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSON {
    // this is the method that convert a string in format of JSON to a JSON object and then to a JSON array
    // we can put any string with json format into JSONObject and use (getString) to give the key and receive the value
    // if in Json string we have an array of object then we can first convert the text into object and then
    // take out the array out of object and put it into and JSONArray like what I did in first step here
    // because we have a Json string that it has students as key which has an array of students.
    // then I went through the array and put each item into and object and then retrieve its value by using its keys.
    static void ConvertJsonToArray() {
        String informationInJsonFormat = "{'students': [ " +
                "{'name': 'ali', 'class':'programming', 'contact':'546698745'}, " +
                "{'name': 'max', 'class':'algorithm', 'contact':'1234587562'}," +
                "{'name': 'sara', 'class':'designing', 'contact':'7854245874'}" +
                "]}";
        JSONObject jObject = new JSONObject(informationInJsonFormat);
        JSONArray jsonArray = jObject.getJSONArray("students");
        List<Student> students = new ArrayList<>();


        for (int i = 0; i < jsonArray.length(); i++) {
            Student student = new Student();
            Object object = jsonArray.get(i);
            JSONObject jsonObject = new JSONObject(object.toString());
            student.setName(jsonObject.getString("name"));
            student.setClassName(jsonObject.getString("class"));
            student.setContact(jsonObject.getString("contact").toString());

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
