package com.zyfera.assignment.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyfera.assignment.entity.Grade;
import com.zyfera.assignment.entity.Student;
import com.zyfera.assignment.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        calculateAverageGrades(student);
        return studentRepository.save(student);
    }

    public Student updateStudent(String stdNumber, Student updatedStudent) {
        Student student = studentRepository.findByStdNumber(stdNumber).orElseThrow();
        student.setName(updatedStudent.getName());
        student.setSurname(updatedStudent.getSurname());
        student.setGrades(updatedStudent.getGrades());
        calculateAverageGrades(student);
        return studentRepository.save(student);
    }

    private void calculateAverageGrades(Student student) {
        // Create a map to store lists of grades by course code
        Map<String, List<Double>> gradesByCourse = new HashMap<>();
    
        for (Grade grade : student.getGrades()) {
            // If the course code is not in the map, add a new list for it
            if (!gradesByCourse.containsKey(grade.getCode())) {
                gradesByCourse.put(grade.getCode(), new ArrayList<>());
            }
            // Add the grade value to the list for the course code
            gradesByCourse.get(grade.getCode()).add(grade.getValue());
        }
    
        // Clear the original grades list to replace with averages
        student.getGrades().clear();
    
        // Calculate the average grade for each course code and add it to the student's grades
        for (Map.Entry<String, List<Double>> entry : gradesByCourse.entrySet()) {
            String courseCode = entry.getKey();
            List<Double> values = entry.getValue();
    
            // Calculate the average value of the grades
            double average = 0.0;
            if (!values.isEmpty()) {
                double sum = 0.0;
                for (Double value : values) {
                    sum += value;
                }
                average = sum / values.size();
            }
    
            // Create a new Grade object with the average value
            Grade averageGrade = new Grade();
            averageGrade.setCode(courseCode);
            averageGrade.setValue(average);
            averageGrade.setStudent(student);
    
            // Add the average grade to the student's grades list
            student.getGrades().add(averageGrade);
        }
    }
    
}

