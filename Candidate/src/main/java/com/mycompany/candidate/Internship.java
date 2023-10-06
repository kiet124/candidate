package com.mycompany.candidate;

public class Internship extends Candidate {
    private final String majors;
    private final String semester;
    private final String university;

    public Internship(int candidateId, String firstName, String lastName, int birthYear, String address, String phone, String email, String majors, String semester, String university) {
        super(candidateId, firstName, lastName, birthYear, address, phone, email, 2); 
        this.majors = majors;
        this.semester = semester;
        this.university = university;
    }

    @Override
    public String toString() {
        return super.toString() + " | " + majors + " | " + semester + " | " + university;
    }
}
