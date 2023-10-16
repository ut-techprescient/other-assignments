package com.ut.student.model;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SubjectModel {

    private String name;
    private final float passingMark = 33.33F;
    private final float maxMark = 100F;
    private float marksObtained;

    public SubjectModel(String name, float marksObtained){
        this.name = name;
        this.marksObtained = marksObtained;
    }

    public void setMarksObtained(float marksObtained) {
        assert (0 <= marksObtained) && (marksObtained <= maxMark);
        this.marksObtained = marksObtained;
    }
}
