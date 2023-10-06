package com.mycompany.candidate;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.time.Year;

public class Management{
    private static final ArrayList<Candidate> candidates = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void start() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    createExperienceCandidate();
                    break;
                case 2:
                    createFresherCandidate();
                    break;
                case 3:
                    createInternshipCandidate();
                    break;
                case 4:
                    searchCandidates();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("CANDIDATE MANAGEMENT SYSTEM");
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Internship");
        System.out.println("4. Searching");
        System.out.println("5. Exit");
        System.out.print("Please choose an option (1-5): ");
    }

    private static void createExperienceCandidate() {
        System.out.println("Creating Experience Candidate:");
        Candidate candidate = createCandidate(0); // Experience
        if (candidate != null) {
            candidates.add(candidate);
            System.out.print("Candidate created successfully. Do you want to continue (Y/N)? ");
            String continueChoice = scanner.nextLine();
            if (!continueChoice.equalsIgnoreCase("Y")) {
                displayAllCandidates();
            }
        }
    }

    private static void createFresherCandidate() {
        System.out.println("Creating Fresher Candidate:");
        Candidate candidate = createCandidate(1); // Fresher
        if (candidate != null) {
            candidates.add(candidate);
            System.out.print("Candidate created successfully. Do you want to continue (Y/N)? ");
            String continueChoice = scanner.nextLine();
            if (!continueChoice.equalsIgnoreCase("Y")) {
                displayAllCandidates();
            }
        }
            
    }

    private static void createInternshipCandidate() {
        System.out.println("Creating Internship Candidate:");
        Candidate candidate = createCandidate(2); // Internship
        if (candidate != null) {
            candidates.add(candidate);
            System.out.print("Candidate created successfully. Do you want to continue (Y/N)? ");
            String continueChoice = scanner.nextLine();
            if (!continueChoice.equalsIgnoreCase("Y")) {
                displayAllCandidates();
            }
        }
    }

    private static Candidate createCandidate(int candidateType) {
        System.out.print("Enter Candidate ID: ");
        int candidateId = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Birth Year (1900.." + Year.now().getValue() + "): ");
        int birthYear = scanner.nextInt();
        scanner.nextLine(); 

        if (birthYear < 1900 || birthYear > Year.now().getValue()) {
            System.out.println("Invalid birth year. Please enter a valid year.");
            return null;
        }

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Phone (minimum 10 digits): ");
        String phone = scanner.nextLine();

        if (phone.length() < 10 || !Pattern.matches("\\d+", phone)) {
            System.out.println("Invalid phone number. Please enter a valid phone number.");
            return null;
        }

        System.out.print("Enter Email (e.g., annguyen@fpt.edu.vn): ");
        String email = scanner.nextLine();

        if (!Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", email)) {
            System.out.println("Invalid email address. Please enter a valid email address.");
            return null;
        }

        if (candidateType == 0) { 
            System.out.print("Enter Year of Experience (0-100): ");
            int expInYear = scanner.nextInt();
            scanner.nextLine(); 

            if (expInYear < 0 || expInYear > 100) {
                System.out.println("Invalid year of experience. Please enter a valid year of experience.");
                return null;
            }

            System.out.print("Enter Professional Skill: ");
            String proSkill = scanner.nextLine();

            return new Experience(candidateId, firstName, lastName, birthYear, address, phone, email, expInYear, proSkill);
        } else if (candidateType == 1) { 
            System.out.print("Enter Graduation Date: ");
            String graduationDate = scanner.nextLine();

            System.out.print("Enter Graduation Rank (Excellence, Good, Fair, Poor): ");
            String graduationRank = scanner.nextLine();

            if (!isValidGraduationRank(graduationRank)) {
                System.out.println("Invalid graduation rank. Please enter a valid graduation rank.");
                return null;
            }

            System.out.print("Enter University where Student Graduated: ");
            String education = scanner.nextLine();

            return new Fresher(candidateId, firstName, lastName, birthYear, address, phone, email, graduationDate, graduationRank, education);
        } else if (candidateType == 2) { 
            System.out.print("Enter Majors: ");
            String majors = scanner.nextLine();

            System.out.print("Enter Semester: ");
            String semester = scanner.nextLine();

            System.out.print("Enter University Name: ");
            String university = scanner.nextLine();

            return new Internship(candidateId, firstName, lastName, birthYear, address, phone, email, majors, semester, university);
        }

        return null;
    }

    private static boolean isValidGraduationRank(String rank) {
        return rank.equalsIgnoreCase("Excellence") || rank.equalsIgnoreCase("Good") || rank.equalsIgnoreCase("Fair") || rank.equalsIgnoreCase("Poor");
    }

    private static void displayAllCandidates() {
        System.out.println("List of Candidates:");
        for (Candidate candidate : candidates) {
            System.out.println(candidate);
        }
    }

private static void searchCandidates() {
    System.out.print("Input Candidate name (First name or Last name): ");
    String searchName = scanner.nextLine().toLowerCase();

    System.out.print("Input type of candidate (0 for Experience, 1 for Fresher, 2 for Internship): ");
    int searchType = scanner.nextInt();
    

    System.out.println("The candidates found:");
    boolean found = false;
    for (Candidate candidate : candidates) {
        String firstName = candidate.getFirstName().toLowerCase();
        String lastName = candidate.getLastName().toLowerCase();
        if ((firstName.contains(searchName) || lastName.contains(searchName)) && candidate.getCandidateType() == searchType) {
            System.out.println(candidate);
            found = true;
        }
    }

    if (!found) {
        System.out.println("No candidates found matching the search criteria.");
    }
}




}
