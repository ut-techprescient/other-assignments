package com.ut.student;

import com.ut.base.IAssignment;
import com.ut.student.model.StudentModel;
import com.ut.student.model.SubjectModel;
import com.ut.student.util.GradeCalculator;
import com.ut.utils.CmdUtil;

import java.util.ArrayList;
import java.util.List;

public class StudentApp implements IAssignment {

    private List<SubjectModel> takeSubjectInput(int subjectDetails){
        List<SubjectModel> studentSubjects = new ArrayList<>();
        int ct = 1;
        while(subjectDetails > 0) {
            String subSuff = (ct == 1)? "1st": (ct == 2)? "2nd": (ct == 3)? "3rd": ct+"th";
            CmdUtil.displayMessage("\n == Enter " + subSuff +" Subject Detail == \n");
            String name = CmdUtil.takeStringInput("\n Enter Subject Name: \n");
            float marksObtained = CmdUtil.takeFloatInput("\nEnter Mark in Subject: \n");
            studentSubjects.add(
              new SubjectModel(name, marksObtained)
            );
            ct++;
            subjectDetails--;
        }
        return studentSubjects;
    }

    private StudentModel takeStudentInput(){
        CmdUtil.displayMessage("\n == Enter Student Detail == \n");
        int rollNo = CmdUtil.takeIntegerInput("Enter Roll No: \n");
        String name = CmdUtil.takeStringInput("Enter Name: \n");
        String className = CmdUtil.takeStringInput("Enter Class: \n");
        int numberOfSubjects = CmdUtil.takeIntegerInput("\n == Enter No Of Subjects Student Enroll In == \n");
        List<SubjectModel> subjects = takeSubjectInput(numberOfSubjects);
        return  new StudentModel(
          name,
          rollNo,
          className,
          subjects
        );
    }


    @Override
    public void run() {
        CmdUtil.displayMessage("..Student Application..");
        String msg = "Enter to number of student";
        int noOfStudents = CmdUtil.takeIntegerInput(msg);
        List<StudentModel> allStudents = new ArrayList<>();

        while (noOfStudents != 0){
            StudentModel student = takeStudentInput();
            allStudents.add(student);
            noOfStudents--;
        }

        for(StudentModel stu: allStudents){
            GradeCalculator calculator = new GradeCalculator(stu);
            calculator.studentGrade();
            String message = "\n =======  Result  ========= \n";
            message += "\n Name: " + stu.getName() +" \n";
            message += "\n Total Marks: " + calculator.totalMark() + "\n";
            message += "\n Grade: " + calculator.studentGrade() + "\n";
            message += "\n ======= ***** ========";
            CmdUtil.displayMessage(message);
        }

    }
}
