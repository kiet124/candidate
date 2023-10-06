package com.mycompany.candidate;

public class Candidate {
    private final int candidateId;
    private final String firstName;
    private final String lastName;
    private final int birthYear;
    private final String address;
    private final String phone;
    private final String email;
    private final int candidateType;

    public Candidate(int candidateId, String firstName, String lastName, int birthYear, String address, String phone, String email, int candidateType) {
        this.candidateId = candidateId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.candidateType = candidateType;
    }

    

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getCandidateType() {
        return candidateType;
    }

    @Override
    public String toString() {
        return getFullName() + " | " + birthYear + " | " + address + " | " + phone + " | " + email + " | " + candidateType;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
