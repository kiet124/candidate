package com.mycompany.candidate;

public class Fresher extends Candidate {
    private final String graduationDate;
    private final String graduationRank;
    private final String education;

    public Fresher(int candidateId, String firstName, String lastName, int birthYear, String address, String phone, String email, String graduationDate, String graduationRank, String education) {
        super(candidateId, firstName, lastName, birthYear, address, phone, email, 1);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }



    @Override
    public String toString() {
        return super.toString() + " | " + graduationDate + " | " + graduationRank + " | " + education;
    }
}
