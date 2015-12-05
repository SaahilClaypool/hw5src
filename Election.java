import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

class ElectionData {
    LinkedList<String> ballot = new LinkedList<String>();
    // LinkedList<String> votes = new LinkedList<String>();
    VoteData votes = new HashVote();


    Scanner keyboard = new Scanner(System.in);

    ElectionData() {
        this.ballot.add("Gompei");
        this.ballot.add("Husky");
    }

    public void printBallot() {
        System.out.println("The candidates are ");
        for (String s : ballot) {
            System.out.println(s);
        }
    }
    public void processVotes(String first, String second, String third) throws DuplicateVotesException, UnknownCandidateException {
        if(!ballot.contains(first)){
            throw new UnknownCandidateException(first);
        }
        if(!ballot.contains(second)){
            throw new UnknownCandidateException(second);
        }
        if(!ballot.contains(second)){
            throw new UnknownCandidateException(second);
        }
        if(first.equals(second) || first.equals(third)){
            throw new DuplicateVotesException(first);
        }
        if(second.equals(third)){
            throw new DuplicateVotesException(second);
        }
        // move to data class
        votes.addTally(first, second,third);
    }
    public void addCandidate(String cand) throws CandidateExistsException{
        // move to data(check and throw) whole method)
        // chekcing if ballot contains still in this?
        if(!ballot.contains(cand)){
            ballot.add(cand);
            votes.addOption(cand);
        }
        else
            throw new CandidateExistsException(cand);
    }
    public void screen() {
        this.printBallot();
        String[] myVote = new String[3];
        System.out.println("Who is your first choice?");
        String candidate = keyboard.next();
        myVote[0] = candidate;
        System.out.println("Who is your second choice?");
        String candidate2 = keyboard.next();
        myVote[1] = candidate2;
        System.out.println("Who is your third choice?");
        String candidate3 = keyboard.next();
        myVote[2] = candidate3;
        System.out.printf("You voted for \n    1. %s \n    2. %s \n    3. %s\n", candidate, candidate2, candidate3);
        try {
            processVotes(myVote[0], myVote[1], myVote[2]);
        } catch (DuplicateVotesException e) {
            e.printStackTrace();
            System.out.printf("Duplicate Canditate: %s\n", e.cand);


        } catch (UnknownCandidateException e) {
            e.printStackTrace();
            System.out.printf("Unknown Canditate: %s\n", e.cand);
        }
    }

    public String findWinnerMostFirstVotes(){
        return votes.getWinnerMostVotes();
    }
    // getSum of individual list, return sum of all three.

    public String findWinnerMostPoints(){
        return votes.getWinnerMostPoints();
    }
    public static void main(String[] args) {
        ElectionData el = new ElectionData();
        el.screen();

    }
}