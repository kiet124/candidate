package com.mycompany.candidate;


import com.mycompany.candidate.Candidate;

public class Experience extends Candidate {
    private final int expInYear;
    private final String proSkill;

    public Experience(int candidateId, String firstName, String lastName, int birthYear, String address, String phone, String email, int expInYear, String proSkill) {
        super(candidateId, firstName, lastName, birthYear, address, phone, email, 0);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }


    @Override
    public String toString() {
        return super.toString() + " | " + expInYear + " | " + proSkill;
    }
}
