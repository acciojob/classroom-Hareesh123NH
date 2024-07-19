package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private HashMap<String, Student> studentMap;
    private HashMap<String, Teacher> teacherMap;
    private HashMap<String, List<String>> teacherStudentMapping;

    public StudentRepository(){
        this.studentMap = new HashMap<String, Student>();
        this.teacherMap = new HashMap<String, Teacher>();
        this.teacherStudentMapping = new HashMap<String, List<String>>();
    }

    public void saveStudent(Student student){
        // your code goes here
    	//System.out.println("Hareesh");
        System.out.println(student.getName());
        studentMap.put(student.getName(), student);
    }

    public void saveTeacher(Teacher teacher){
        // your code goes here
        teacherMap.put(teacher.getName(), teacher);
    }

    public void saveStudentTeacherPair(String student, String teacher){
        if(studentMap.containsKey(student) && teacherMap.containsKey(teacher)){
            // your code goes here
            studentMap.put(student, studentMap.get(student));
            teacherMap.put(teacher, teacherMap.get(teacher));
            List<String> li=new ArrayList<>();
            if(teacherStudentMapping.containsKey(teacher)){
               li=teacherStudentMapping.get(teacher);
            }
            li.add(student);
            teacherStudentMapping.put(teacher, li);
        }
    }


    public Student findStudent(String student){
        // your code goes here
        if(studentMap.containsKey(student)){
            return studentMap.get(student);
        }
        return new Student();
    }

    public Teacher findTeacher(String teacher){
        // your code goes here
        if(teacherMap.containsKey(teacher)){
            return teacherMap.get(teacher);
        }
        return new Teacher();
    }

    public List<String> findStudentsFromTeacher(String teacher){
        // your code goes here
        // find student list corresponding to a teacher
        if(teacherStudentMapping.containsKey(teacher)){
            return teacherStudentMapping.get(teacher);
        }
        return new ArrayList<>();
    }

    public List<String> findAllStudents(){
        // your code goes here
        return new ArrayList<>(studentMap.keySet());
    }

    public void deleteTeacher(String teacher){
        // your code goes here
        if(teacherStudentMapping.containsKey(teacher)){
            //List<String> students=teacherStudentMapping.get(teacher);
            for(String student:teacherStudentMapping.get(teacher)){
                if(studentMap.containsKey(student)){
                    studentMap.remove(student);
                }
            }
            teacherStudentMapping.remove(teacher);
        }
        if(teacherMap.containsKey(teacher)){
            teacherMap.remove(teacher);
        }
    }

    public void deleteAllTeachers(){
        // your code goes here
        //HashSet<String> studentSet = new HashSet<>();

        //directorMap = new HashMap<>();

        for(String teacher: teacherStudentMapping.keySet()){
            deleteTeacher(teacher);
        }

        teacherStudentMapping=new HashMap<>();
        teacherMap=new HashMap<>();
    }
}